package com.curso.business.mockito;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Test;

class HamcrestMatchersTest {

	@Test
	void testHamcrestMatchers() {

		// Given 
		List<Integer> scores = Arrays.asList(99,100,101,105);
		
		// When
		assertThat(scores, hasSize(4));
		assertThat(scores, hasItems(100,101));
		assertThat(scores, everyItem(greaterThan(98)));
		assertThat(scores, everyItem(lessThan(106)));
		
		// Check String
		assertThat("", is(emptyString()));
		assertThat(null, is(emptyOrNullString()));
		
		// Arrays
		Integer[] array = {1 ,2 ,3};
		assertThat(array, arrayWithSize(3));
		assertThat(array, arrayContainingInAnyOrder(3,2,1));
	}
}
