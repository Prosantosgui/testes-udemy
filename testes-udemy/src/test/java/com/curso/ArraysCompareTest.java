package com.curso;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class ArraysCompareTest {

	@Test
	@Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
	void testSortPerfomance() {
		int[] numbers = {25, 8, 21, 32, 3};
		for (int i = 0; i < 100000; i++) {
			numbers[0] = i;
			Arrays.sort(numbers);
		}
	}

}
