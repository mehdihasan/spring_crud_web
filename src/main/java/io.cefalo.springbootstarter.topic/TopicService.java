package io.cefalo.springbootstarter.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "name1", "description1"),
            new Topic("2", "name2", "description2"),
            new Topic("3", "name3", "description3"),
            new Topic("4", "name4", "description4"),
            new Topic("5", "name5", "description5"),
            new Topic("6", "name6", "description6"),
            new Topic("7", "name7", "description7"))
    );

    public List<Topic> getTopicList() {
        List<Topic> topicList = new ArrayList<>();
        topicRepository.findAll().forEach(topicList::add);
        return topicList;
        // return topics;
    }

    public Topic getTopic(String id) {
        return topicRepository.findOne(id);
        // return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get();
    }

    public void addTopic(Topic topic) {
        topicRepository.save(topic);
        //topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        /*int i = 0;
        for (Topic myTopic: topics) {
            if (id.equalsIgnoreCase(myTopic.getId())) {
                topics.set(i, topic);
                return;
            }
            i++;
        }*/
        topicRepository.save(topic);
    }

    public void deleteTopic(String id) {
        topicRepository.delete(id);
        // topics.removeIf(topic -> topic.getId().equalsIgnoreCase(id));
    }
}
