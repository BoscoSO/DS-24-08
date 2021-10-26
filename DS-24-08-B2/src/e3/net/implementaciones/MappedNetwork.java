package e3.net.implementaciones;

import e3.net.NetworkManager;

import java.util.List;

public class MappedNetwork implements NetworkManager {


    @Override
    public void addUser(String user, List<TopicOfInterest> topicsOfInterest) {

    }

    @Override
    public void removeUser(String user) {

    }

    @Override
    public void addInterest(String user, TopicOfInterest topicOfInterest) {

    }

    @Override
    public void removeInterest(String user, TopicOfInterest topicOfInterest) {

    }

    @Override
    public List<String> getUsers() {
        return null;
    }

    @Override
    public List<TopicOfInterest> getInterests() {
        return null;
    }

    @Override
    public List<TopicOfInterest> getInterestsUser(String user) {
        return null;
    }
}
