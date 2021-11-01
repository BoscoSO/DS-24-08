package e3.net;

import java.util.ArrayList;
import java.util.List;

public interface NetworkManager {
    enum TopicOfInterest {Moda, Informatica, Tecnologia, Coches, Hogar, Deportes}




    void addUser(String user, List<TopicOfInterest> topicsOfInterest) throws IllegalArgumentException;

    void removeUser(String user) throws IllegalArgumentException;

    void addInterest(String user, TopicOfInterest topicOfInterest) throws IllegalArgumentException;

    void removeInterest(String user, TopicOfInterest topicOfInterest) throws IllegalArgumentException;

    List<String> getUsers();

    List<TopicOfInterest> getInterests();

    List<TopicOfInterest> getInterestsUser(String user) throws IllegalArgumentException;
}
