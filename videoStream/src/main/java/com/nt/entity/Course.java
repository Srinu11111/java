package com.nt.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Course {
	@Id
	private int courseId;
	private String title;
	public Course() {
		
	}
	public Course(int courseId, String title) {
		super();
		this.courseId = courseId;
		this.title = title;
	}
	public int getCourseId() {
		return courseId;
	}
	public String getTitle() {
		return title;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public void setTitle(String title) {
		this.title = title;
	}

}
