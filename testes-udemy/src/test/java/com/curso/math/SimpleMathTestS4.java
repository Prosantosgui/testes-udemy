package com.curso.math;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("Test Math Operations in SimpleMath Class")
class SimpleMathTestS4 {

    SimpleMath math;
    
    
    @BeforeEach
    void beforeEachMethod() {
        math = new SimpleMath();
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"Pelé", "Senna", "Keith Moon"})
    void testValueSource(String firstName) {
    	System.out.println(firstName);
    	assertNotNull(firstName);
    }
    
    @AfterEach
    void afterEachMethod() {
        System.out.println("Running @AfterEach method!");
    }
    
        	
    @DisplayName("Test 6.2 / 2 = 3.1")
    @ParameterizedTest
    //@MethodSource("testDivisionInputParameter")
    @MethodSource
    void testDivision(double firstNumber, double secondNumber, double expected) {
    	
    	System.out.println("Test " + firstNumber + " / "
    			+ secondNumber + " = " + expected + "!");
        Double actual = math.division(firstNumber, secondNumber);
        
        assertEquals(expected, actual, 2D,
                () -> firstNumber + "/" + secondNumber +
                " did not produce " + expected + "!");
    }
    
    //public static Stream<Arguments> testDivisionInputParameter(){
    public static Stream<Arguments> testDivision(){
    	return Stream.of(
    			Arguments.of(6.2D, 2D, 3.1D),
    			Arguments.of(71D, 14D, 5.07D),
    			Arguments.of(18.3D, 3.1D, 5.9D)
      );
    }

    // test[System Under Test]_[Condition or State Change]_[Expected Result]
    //@Disabled("TODO: We need still work on it!")
    @Test
    @DisplayName("Test Division by Zero")
    void testDivision_When_FirstNumberIsDividedByZero_ShouldThrowArithmeticException() {
        
        //given
        double firstNumber = 6.2D;
        double secondNumber = 0D;
        
        var expectedMessage = "Impossible to divide by zero!";
        
        //when & then
        ArithmeticException actual = assertThrows(
            ArithmeticException.class, () -> {
                //when & then
                math.division(firstNumber, secondNumber);
            }, () -> "Division by zero should throw an ArithmeticException");
        
        assertEquals(expectedMessage, actual.getMessage(),
            () -> "Unexpected exception message!");
    }
  
}