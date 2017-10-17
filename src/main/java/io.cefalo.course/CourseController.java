package io.cefalo.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    public CourseService courseService;

    @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses(@PathVariable String id) {
        return courseService.getCourseList();
    }

    @RequestMapping("/topics/{topicId}/course/{id}")
    public Course getCourse(@PathVariable String id) {
        return courseService.getCourse(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/course")
    public void addTopic(@RequestBody Course course) {
        courseService.addCourse(course);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/course/{id}")
    public void addTopic(@RequestBody Course course, @PathVariable String id) {
        courseService.updateCourse(id, course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/course/{id}")
    public void deleteTopic(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
