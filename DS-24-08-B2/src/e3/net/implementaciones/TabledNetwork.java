package e3.net.implementaciones;

import e3.net.NetworkManager;

import java.util.ArrayList;
import java.util.List;


public class TabledNetwork implements NetworkManager {

    private final List<String> users = new ArrayList<>();
    private final List<List<TopicOfInterest>> topics_user = new ArrayList<>();


    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) throws IllegalArgumentException {
        if (topicsOfInterest == null || user == null) throw new IllegalArgumentException("Parametro null");
        if (users.contains(user)) throw new IllegalArgumentException("El usuario "+user+" ya existe");

        users.add(user);
        topics_user.add(distinct(topicsOfInterest));
    }

    @Override
    public void removeUser(String user) throws IllegalArgumentException {
        if (user == null) throw new IllegalArgumentException("Parametro null");
        if (!users.contains(user))
            throw new IllegalArgumentException("No existe el usuario " + user);
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                users.remove(i);
                topics_user.remove(i);
                return;
            }
        }
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) throws IllegalArgumentException {
        if (topicOfInterest == null || user == null) throw new IllegalArgumentException("Parametro null");
        if (!users.contains(user))
            throw new IllegalArgumentException("No existe el usuario " + user);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                if (topics_user.get(i).contains(topicOfInterest))
                    throw new IllegalArgumentException("El usuario ya tiene este tema añadido");
                topics_user.get(i).add(topicOfInterest);
                return;
            }
        }
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) throws IllegalArgumentException {
        if (topicOfInterest == null || user == null) throw new IllegalArgumentException("Parametro null");
        if (!users.contains(user))
            throw new IllegalArgumentException("No existe el usuario " + user);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                for (int c = 0; c < topics_user.get(i).size(); c++) {
                    if (topics_user.get(i).get(c) == topicOfInterest) {
                        topics_user.get(i).remove(c);
                        return;
                    }

                }
                throw new IllegalArgumentException("El usuario no tiene este tema añadido");
            }
        }
    }

    @Override
    public List<String> getUsers() {
        return users;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        List<TopicOfInterest> list = new ArrayList<>();
        for (List<TopicOfInterest> lti : topics_user) {
            for (TopicOfInterest ti : lti) {
                if (!list.contains(ti))
                    list.add(ti);
            }
        }
        return list;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) throws IllegalArgumentException {
        if (user == null) throw new IllegalArgumentException("Parametro null");
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).equals(user)) {
                return topics_user.get(i);
            }
        }
        throw new IllegalArgumentException("No existe el usuario " + user);
    }

    private List<TopicOfInterest> distinct(List<TopicOfInterest> list) {
        List<TopicOfInterest> laux=new ArrayList<>();
        for(TopicOfInterest o:list){
            if(!laux.contains(o))
                laux.add(o);
        }
        return laux;
    }
}
