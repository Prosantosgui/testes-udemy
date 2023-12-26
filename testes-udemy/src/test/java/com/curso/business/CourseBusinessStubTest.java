package com.curso.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.curso.service.CourseService;
import com.curso.service.CourseServiceStub;

class CourseBusinessStubTest {
	
	
	@Test
	void testCourseRelatedToSpring_When_UsingAStub() {

		// Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		// When / Act
		var filteredCourses = business.retrieveCourseRelatedToSpring("Leandro");
		
		// Then / Assert
		assertEquals(4, filteredCourses.size());
		
	}
	
	
	@Test
	void testCourseRelatedToSpring_When_UsingAFoorBarStub() {

		// Given / Arrange
		CourseService stubService = new CourseServiceStub();
		CourseBusiness business = new CourseBusiness(stubService);
		
		// When / Act
		var filteredCourses = business.retrieveCourseRelatedToSpring("Foo Bar");
		
		// Then / Assert
		assertEquals(0, filteredCourses.size());
		
	}
	
}
