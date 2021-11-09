package e3;

import e3.net.NetworkManager;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private final NetworkManager manager;

    public Network(NetworkManager manager) {
        this.manager = manager;
    }

    public void altaUser(String user) {
        manager.addUser(user, new ArrayList<>());
    }

    public void altaUser(String user, List<NetworkManager.TopicOfInterest> topics) {
        manager.addUser(user, topics);
    }

    public void bajaUser(String user) {
        manager.removeUser(user);
    }

    public void setUserTopics(String user, List<NetworkManager.TopicOfInterest> topics) {
        bajaUser(user);
        altaUser(user, topics);
    }

    public void addTopicToUser(String user, NetworkManager.TopicOfInterest topic) {
        manager.addInterest(user, topic);
    }

    public void deleteTopicFromUser(String user, NetworkManager.TopicOfInterest topic) {
        manager.removeInterest(user, topic);
    }

    public List<NetworkManager.TopicOfInterest> getTopicsFromUser(String user) {
        return manager.getInterestsUser(user);
    }

    public List<String> getUsersForTopic(NetworkManager.TopicOfInterest topic){
        if(topic==null)throw new IllegalArgumentException("null no es valido");
        List<String> list = new ArrayList<>();
        for (String user : manager.getUsers().stream().sorted().toList()) {
            if (manager.getInterestsUser(user).contains(topic)) {
                if (!list.contains(user))
                    list.add(user);
            }
        }

        return list;
    }
    public List<NetworkManager.TopicOfInterest> getPopularTopics() {
        return manager.getInterests();
    }
    public List<NetworkManager.TopicOfInterest> getCommonTopicsFor(List<String> users) {
        List<NetworkManager.TopicOfInterest> list = new ArrayList<>(List.of(NetworkManager.TopicOfInterest.values()));
        for (String us : users) {
                list.retainAll(manager.getInterestsUser(us));
        }
        return list;
    }

    public String showUsersInfo() {
        StringBuilder cad = new StringBuilder("Network Users Info.\n");
        for (String user : manager.getUsers().stream().sorted().toList()) {
            cad.append("  -").append(user).append("\n");
            for (NetworkManager.TopicOfInterest topic : manager.getInterestsUser(user)) {
                cad.append("\t. ").append(topic).append("\n");
            }
        }
        return cad.toString();
    }



}
