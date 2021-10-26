package e3.net;

import java.util.List;

public interface NetworkManager {
    enum TopicOfInterest{Interes1,Interes2,Interes3,Interes4}

    void addUser(String user, List<TopicOfInterest> topicsOfInterest);

    void removeUser(String user);

    void addInterest(String user, TopicOfInterest topicOfInterest);

    void removeInterest(String user, TopicOfInterest topicOfInterest);

    List<String> getUsers();

    List<TopicOfInterest> getInterests();

    List<TopicOfInterest> getInterestsUser(String user);
}
