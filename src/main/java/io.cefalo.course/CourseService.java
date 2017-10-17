package io.cefalo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    private List<Course> courses = new ArrayList<>(Arrays.asList(
            new Course("1", "name1", "description1"),
            new Course("2", "name2", "description2"),
            new Course("3", "name3", "description3"),
            new Course("4", "name4", "description4"),
            new Course("5", "name5", "description5"),
            new Course("6", "name6", "description6"),
            new Course("7", "name7", "description7"))
    );

    public List<Course> getCourseList() {
        List<Course> courseList = new ArrayList<>();
        courseRepository.findAll().forEach(courseList::add);
        return courseList;
    }

    public Course getCourse(String id) {
        return courseRepository.findOne(id);
    }

    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    public void updateCourse(String id, Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(String id) {
        courseRepository.delete(id);
    }
}
