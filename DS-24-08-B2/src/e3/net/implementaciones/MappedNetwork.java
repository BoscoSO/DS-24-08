package e3.net.implementaciones;

import e3.net.NetworkManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MappedNetwork implements NetworkManager {

    private final Map<String, List<TopicOfInterest>> mappedList = new HashMap<>();

    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) throws IllegalArgumentException {
        if (topicsOfInterest == null || user == null) throw new IllegalArgumentException("Parametro null");
        if (mappedList.containsKey(user))
            throw new IllegalArgumentException("El usuario " + user + " ya existe");
        mappedList.put(user, distinct(topicsOfInterest));
    }

    @Override
    public void removeUser(String user) throws IllegalArgumentException {
        if (!mappedList.containsKey(user))
            throw new IllegalArgumentException("No existe el usuario " + user);

        mappedList.remove(user);
    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) throws IllegalArgumentException {

        if (topicOfInterest == null || user == null) throw new IllegalArgumentException("Parametro null");
        if (!mappedList.containsKey(user))
            throw new IllegalArgumentException("No existe el usuario " + user);

        if (mappedList.get(user).contains(topicOfInterest))
            throw new IllegalArgumentException("El usuario ya tiene este tema añadido");
        else {
            mappedList.get(user).add(topicOfInterest);
        }
    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) throws IllegalArgumentException {
        if (topicOfInterest == null || user == null) throw new IllegalArgumentException("Parametro null");
        if (!mappedList.containsKey(user))
            throw new IllegalArgumentException("No existe el usuario " + user);

        if(!mappedList.get(user).remove(topicOfInterest))
            throw new IllegalArgumentException("El usuario no tiene este tema añadido");


    }

    @Override
    public List<String> getUsers() {
        return mappedList.keySet().stream().toList();
    }

    @Override
    public List<TopicOfInterest> getInterests() {

        List<TopicOfInterest> list = new ArrayList<>();
        for (List<TopicOfInterest> lti : mappedList.values()) {
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
        if (!mappedList.containsKey(user))
            throw new IllegalArgumentException("No existe el usuario " + user);

        return mappedList.get(user);
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
