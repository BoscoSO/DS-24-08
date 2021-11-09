
import e3.Network;
import e3.net.NetworkManager;
import e3.net.implementaciones.MappedNetwork;
import e3.net.implementaciones.TabledNetwork;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class NetworkTest_e3 {
    private Network tabledNet;
    private Network mappedNet;

    @BeforeEach
    void setup() {
        tabledNet =new Network(new TabledNetwork());
        mappedNet =new Network(new MappedNetwork());

        List<NetworkManager.TopicOfInterest> tops1 = new ArrayList<>();
        tops1.add(NetworkManager.TopicOfInterest.Deportes);
        tops1.add(NetworkManager.TopicOfInterest.Informatica);
        tops1.add(NetworkManager.TopicOfInterest.Moda);

        List<NetworkManager.TopicOfInterest> tops2 = new ArrayList<>();
        tops2.add(NetworkManager.TopicOfInterest.Deportes);
        tops2.add(NetworkManager.TopicOfInterest.Informatica);
        tops2.add(NetworkManager.TopicOfInterest.Hogar);
        tops2.add(NetworkManager.TopicOfInterest.Coches);

        tabledNet.altaUser("Xoel");
        tabledNet.altaUser("Alvaro");
        tabledNet.altaUser("Pedro",tops1);
        tabledNet.altaUser("Luis",tops2);

        mappedNet.altaUser("Alvaro");
        mappedNet.altaUser("Pedro",tops1);
        mappedNet.altaUser("Luis",tops2);
        mappedNet.altaUser("Xoel");
    }

    @Test
    public void test1() {
        assertEquals(tabledNet.showUsersInfo(),mappedNet.showUsersInfo());
        assertEquals(tabledNet.getTopicsFromUser("Luis"),mappedNet.getTopicsFromUser("Luis"));
        assertEquals(tabledNet.getCommonTopicsFor(List.of(new String[]{"Luis", "Pedro"})),
                     mappedNet.getCommonTopicsFor(List.of(new String[]{"Luis", "Pedro"})));


        List<NetworkManager.TopicOfInterest> tops = new ArrayList<>();
        tops.add(NetworkManager.TopicOfInterest.Deportes);
        tabledNet.setUserTopics("Xoel",tops);
        mappedNet.setUserTopics("Xoel",tops);
        assertEquals(tabledNet.getTopicsFromUser("Xoel"),tops);

        tabledNet.bajaUser("Luis");
        mappedNet.bajaUser("Luis");
        assertEquals(tabledNet.showUsersInfo(),mappedNet.showUsersInfo());
        assertEquals(tabledNet.getUsersForTopic(NetworkManager.TopicOfInterest.Deportes),
                     mappedNet.getUsersForTopic(NetworkManager.TopicOfInterest.Deportes));

        tabledNet.addTopicToUser("Alvaro", NetworkManager.TopicOfInterest.Deportes);
        mappedNet.addTopicToUser("Alvaro", NetworkManager.TopicOfInterest.Deportes);
        assertEquals(tabledNet.showUsersInfo(),mappedNet.showUsersInfo());
        tabledNet.deleteTopicFromUser("Alvaro", NetworkManager.TopicOfInterest.Deportes);
        mappedNet.deleteTopicFromUser("Alvaro", NetworkManager.TopicOfInterest.Deportes);
        assertEquals(tabledNet.showUsersInfo(),mappedNet.showUsersInfo());

        assertEquals(tabledNet.getPopularTopics(),mappedNet.getPopularTopics());
    }


    @Test
    void testExceptionsForMappedNet() {

        assertThrows(IllegalArgumentException.class, () ->mappedNet.altaUser("Luis"));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.altaUser("Luis",null));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.altaUser(null,List.of(
                                            new NetworkManager.TopicOfInterest[]{NetworkManager.TopicOfInterest.Moda,
                                                                            NetworkManager.TopicOfInterest.Deportes})));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.bajaUser("Asdffgdfg"));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.setUserTopics("Asdffgdfg",null));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.setUserTopics(null,null));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.addTopicToUser("Luis",null));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.addTopicToUser("asd",NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.addTopicToUser(null, NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.addTopicToUser("Luis", NetworkManager.TopicOfInterest.Deportes));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.deleteTopicFromUser("Luis", NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.deleteTopicFromUser("asd", NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.deleteTopicFromUser(null, NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.deleteTopicFromUser("Luis", null));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.deleteTopicFromUser(null, null));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.getUsersForTopic(null));
        assertThrows(IllegalArgumentException.class, () ->mappedNet.getCommonTopicsFor(List.of(new String[]{"Luis", "adfuo"})));



    }

    @Test
    void testExceptionsForTabledNet() {

        assertThrows(IllegalArgumentException.class, () ->tabledNet.altaUser("Luis"));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.altaUser("Luis",null));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.altaUser(null,List.of(
                new NetworkManager.TopicOfInterest[]{NetworkManager.TopicOfInterest.Moda,
                        NetworkManager.TopicOfInterest.Deportes})));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.bajaUser("Asdffgdfg"));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.setUserTopics("Asdffgdfg",null));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.setUserTopics(null,null));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.addTopicToUser("Luis",null));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.addTopicToUser("asd",NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.addTopicToUser(null, NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.addTopicToUser("Luis", NetworkManager.TopicOfInterest.Deportes));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.deleteTopicFromUser("Luis", NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.deleteTopicFromUser("asd", NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.deleteTopicFromUser(null, NetworkManager.TopicOfInterest.Moda));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.deleteTopicFromUser("Luis", null));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.deleteTopicFromUser(null, null));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.getUsersForTopic(null));
        assertThrows(IllegalArgumentException.class, () ->tabledNet.getCommonTopicsFor(List.of(new String[]{"Luis", "adfuo"})));
        //assertThrows(IllegalArgumentException.class, () ->tabledNet.getCommonTopicsFor(List.of(new String[]{"Luis", null})));



    }

}
