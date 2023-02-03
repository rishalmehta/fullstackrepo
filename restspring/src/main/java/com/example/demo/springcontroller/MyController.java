package com.example.demo.springcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Courses;
import com.example.demo.service.CourseService;

@RestController
public class MyController {
	
	@Autowired
	private CourseService crservice;

	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}

	@GetMapping("/courses")
	public List<Courses> getCourses() {
		return this.crservice.getCourses();
	}
	
	@GetMapping("/courses/{courseid}")
	public Courses getCourse(@PathVariable String courseid) {
		return this.crservice.getCourse(Long.parseLong(courseid));
	}
	
	@PostMapping("/courses")
	public Courses addCourse(@RequestBody Courses obj) {
		System.out.println(obj.getId()+" course added successfully!");
		return this.crservice.addCourse(obj);
	}

	@PutMapping("/courses")
	public String getCourseAndUpdate(@RequestBody Courses obj) {
		long tempid= this.crservice.getCourseAndUpdate(obj);
		return tempid+" course updated sucessfully!";
	}

	@DeleteMapping("/courses/{courseid}")
	public String deleteCourse(@PathVariable String courseid) {
		return ""+this.crservice.deleteCourse(Long.parseLong(courseid))+" course deleted successfully!";
	}
}
