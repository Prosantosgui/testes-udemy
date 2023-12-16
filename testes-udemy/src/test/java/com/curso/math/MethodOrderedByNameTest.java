package com.curso.math;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.Random.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
class MethodOrderedByNameTest {


	@Test
	void testD() {
		System.out.println("Running Test D");
	}
	
	@Test
	void testA() {
		System.out.println("Running Test A");
	}
	
	@Test
	void testC() {
		System.out.println("Running Test C");
	}
	@Test
	void testB() {
		System.out.println("Running Test B");
	}


}
