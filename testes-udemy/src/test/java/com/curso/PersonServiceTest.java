package com.curso;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.curso.model.Person;
import com.curso.service.IPersonService;
import com.curso.service.PersonService;

public class PersonServiceTest {

	IPersonService service;
	Person person;

	@BeforeEach
	void setup() {
        service = new PersonService();
        person = new Person(
            "Keith",
            "Moon",
            "kmoon@erudio.com.br",
            "Wembley - UK",
            "Male"
        );

	}

	@DisplayName("When Create a Person with Success Should Return a Person Object")
	@Test
	@Disabled
	void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {

		// Given / Arrange
		IPersonService service = new PersonService();

		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		assertNotNull(actual, () -> "The createPerson should not have returned null!");
	}

	@DisplayName("When Create a Person with Success Should Contains Valid Fields in Returned Person Object")
	@Test
	void testCreatePerson_WhenSuccess_ShouldContainsFirstNameInReturnedPersonObject() {

		// Given / Arrange
		IPersonService service = new PersonService();

		Person person = new Person("Keith", "Moon", "kmoon@curso.com.br", "Wembley - UK", "Male");

		// When / Act
		Person actual = service.createPerson(person);

		// Then / Assert
		assertNotNull(actual, () -> "The createPerson should not have returned null!");
		assertEquals(person.getFirstName(), actual.getFirstName(), 
				() -> "The firstName is different");
		
		assertEquals(person.getLastName(), actual.getLastName(), 
				() -> "The lastName is different");
		assertEquals(person.getAddress(), actual.getAddress(), 
				() -> "The address is different");
		assertEquals(person.getGender(), actual.getGender(), 
				() -> "The Gender is different");
		assertEquals(person.getEmail(), actual.getEmail(), 
				() -> "The Email is different");
	}
	
	// test[System Under Test]_[Condition or State Change]_[Expected Result]
	@DisplayName("When Create a Person with null email Should throw Exception")
	@Disabled
	@Test
	void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {

		// Given / Arrange
		IPersonService service = new PersonService();
		person.setEmail(null);

		// When / Act
		Person actual = service.createPerson(person);
		assertThrows(IllegalArgumentException.class, 
				() -> service.createPerson(person),
				() -> "Empty email should have causae an IllegalArgumentException");
		
		// Then / Assert
	}
}
