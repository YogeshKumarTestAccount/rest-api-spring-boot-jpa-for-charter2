package com.charter.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charter.springboot.model.RelatedTopic;
import com.charter.springboot.service.TopicService;

@RestController
public class SpringTopicController {

	@Autowired
	private TopicService topicService;
	private static final Logger logger = LoggerFactory.getLogger(SpringCourseController.class);
	
	@RequestMapping(method=RequestMethod.GET,value="/topics")
	
	public List<RelatedTopic> getAllTopics() {
		logger.info("getAllTopics Service Called");
		System.out.println("getAllTopics Service Called1");
		return topicService.getAllTopics();
		
		
	}

	@RequestMapping(method=RequestMethod.GET,value="/topics/{id}")
	public RelatedTopic getTopicById(@PathVariable String id) {
		return topicService.getTopicById(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	public void addTopic(@RequestBody RelatedTopic topic) {

		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	public void updateTopics(@RequestBody RelatedTopic topic, @PathVariable String id) {

		topicService.updateTopic(topic, id);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	public void deleteTopic(@PathVariable String id) {

		topicService.deleteTopic(id);
	}

}
