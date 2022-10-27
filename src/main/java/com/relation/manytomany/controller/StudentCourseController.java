package com.relation.manytomany.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.relation.manytomany.service.ServiceClass;
import com.relation.manytomany.service.StudentDto;
import com.relation.models.Course;
import com.relation.models.Student;

@RestController
@RequestMapping("/studentcourse")
public class StudentCourseController {
	@Autowired
	ServiceClass service;
	
	@GetMapping("/allstudent")
	public List<Student> findAllStudent(){
		return service.findAllStudents();
	}
	
	@GetMapping("/allcourse")
	public List<Course> findAllCourse(){
		
		return service.findAllCourse();
	}
	
	@GetMapping("/course/{cid}")
	public Course courseById(@PathVariable int cid)
	{
		return service.findCourseById(cid);
	}
	
	@GetMapping("/student/{sid}")
	public Student studentById(@PathVariable int sid)
	{
		return service.findStudentById(sid);
	}
	
	@PostMapping(path="/student")
	public Student addStudent(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@PostMapping(path="/course")
	public Course addCourse(@RequestBody Course course)
	{
		return service.newCourse(course);
	}
	
	@PutMapping(path="/student")
	public Student updateStudent(@RequestBody StudentDto student)
	{
		return service.updateStudent(student);
	}
	
	@PutMapping(path="/course")
	public Course updateCourse(@RequestBody Course course)
	{
		return service.updateCourse(course);
	}
	
	@DeleteMapping(path="/student/{sid}")
	public void deleteStudent(@PathVariable int sid)
	{
		service.deleteStudent(sid);
	}
}
