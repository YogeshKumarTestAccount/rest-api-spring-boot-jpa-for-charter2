package com.charter.springboot.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Course {

	@Id
	private String courseId;
	private String courseName;
	private String courseDescription;

	@ManyToOne(fetch=FetchType.EAGER)
	private RelatedTopic relatedTopic;

	public Course() {
		// TODO Auto-generated constructor stub
	}

	public Course(String courseId, String courseName, String courseDescription, String topicId) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.relatedTopic = new RelatedTopic(topicId, "", "");
	}

	public String getCourseId() {
		return courseId;
	}

	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	public RelatedTopic getRelatedTopic() {
		return relatedTopic;
	}

	public void setRelatedTopic(RelatedTopic relatedTopic) {
		this.relatedTopic = relatedTopic;
	}

}
