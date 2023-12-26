package com.curso.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.curso.service.CourseService;

// CourseBusiness = SUT - System (Method) Under Test
public class CourseBusiness {

	//CourseService is a Dependency
	private CourseService service;

	public CourseBusiness(CourseService service) {
		this.service = service;
	}
	
	public List<String> retrieveCourseRelatedToSpring(String student) {
		
		var filteredCourses = new ArrayList<String>();
		if("Foo Bar".equals(student)) return filteredCourses;
		
		var allCourses = service.retrieveCourses(student);
		
		for (String course : allCourses) {
			if(course.contains("Spring")) {
				filteredCourses.add(student);
			}
		}
		
		return filteredCourses;
	}
}
