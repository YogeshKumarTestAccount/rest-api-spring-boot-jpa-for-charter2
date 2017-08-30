package com.charter.springboot.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.charter.springboot.model.Course;
import com.charter.springboot.model.RelatedTopic;
import com.charter.springboot.service.CourseService;

@RestController
public class SpringCourseController {

	@Autowired
	private CourseService courseService;
        private static final Logger logger = LoggerFactory.getLogger(SpringCourseController.class);
	
	@RequestMapping("/topics/{topicId}/courses")
	public List<Course> getAllCourse(@PathVariable String topicId) {
		logger.info("getAll Service"+topicId);
		return courseService.getAllCourse(topicId);
	}

	@RequestMapping("/courses/{courseId}")
	public Course findByCourseId(@PathVariable String courseId) {
		return courseService.getCourseByCourseID(courseId);
	}
		
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourseById(@PathVariable String id) {
		logger.info("get Service"+id);
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	public void addTopic(@RequestBody Course course, @PathVariable String topicId) {
		System.out.println("Ht Post Service");
		course.setRelatedTopic(new RelatedTopic(topicId, "", ""));
		System.out.println("Post Service course"+course);
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, @PathVariable String id) {
		course.setRelatedTopic(new RelatedTopic(topicId, " ", " "));
		courseService.updateCourse(course, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/course/{id}")
	public void deleteCourse(@PathVariable String id) {
                logger.info("delete Method called successFully..");
		courseService.deleteCourse(id);
	}

}
