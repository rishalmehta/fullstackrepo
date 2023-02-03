package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Courses;

public interface CourseService {

	public List<Courses> getCourses();
	
	public Courses getCourse(long courseid);
	
	public Courses addCourse(Courses tempobj);
	
	public long deleteCourse(long courseid);

	public long getCourseAndUpdate(Courses obj);
}
