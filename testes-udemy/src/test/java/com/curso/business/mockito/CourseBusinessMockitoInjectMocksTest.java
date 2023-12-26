package com.curso.business.mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.curso.business.CourseBusiness;
import com.curso.service.CourseService;

@ExtendWith(MockitoExtension.class)
class CourseBusinessMockitoInjectMocksTest {
	
	@Mock
	CourseService mockService;
	
	@InjectMocks
	CourseBusiness business;
	//business = new CourseBusiness(mockService);
	
	List<String> courses;
	
	@BeforeEach
	void setup() {
		
		courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
            );
	}
	
	@Test
	void testCourseRelatedToSpring_When_UsingAMock() {
		
		//Given / Arrange
		 when(mockService.retrieveCourses("Leandro"))
		 	.thenReturn(courses)
		 ;
		
		// When / Act
		var filteredCourses = business.retrieveCourseRelatedToSpring("Leandro");
		
		// Then / Assert
		assertEquals(4, filteredCourses.size());
		
	}
	
}
