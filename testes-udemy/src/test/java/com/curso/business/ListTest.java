package com.curso.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.Test;

public class ListTest {
	
	@Test
	void testMockingList_When_SizeIsCalled_ShouldReturn10() {

		// Given / Arrange
		List<?> list = mock(List.class);
		// When / Act
		when(list.size()).thenReturn(10);
		// Then / Assert
		assertEquals(10, list.size());
		assertEquals(10, list.size());
		assertEquals(10, list.size());
	}
	
	@Test
	void testMockingList_When_GetIsCalled_ShouldReturnCurso() {
		
		// Given / Arrange
		var list = mock(List.class);
		// When / Act
		when(list.get(anyInt())).thenReturn("Curso");
		// Then / Assert
		assertEquals("Curso", list.get(0));
		assertEquals("Curso", list.get(1));
			
	}
	@Test
	void testMockingList_When_ThrowsAnyException() {
		
		// Given / Arrange
		var list = mock(List.class);
		// When / Act
		when(list.get(anyInt())).thenThrow(new RuntimeException("Foo Bar!!"));
		// Then / Assert
		assertThrows(RuntimeException.class, 
				()-> {
					list.get(anyInt());
					}, 
				() -> "Should have thrown an RuntimeException");
		
	}
}
