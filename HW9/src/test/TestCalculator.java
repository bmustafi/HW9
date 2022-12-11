package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.Calculator;


class TestCalculator {

	Calculator calculator = new Calculator();

	@Test
	public void Should_add_two_numbers_and_return_result() {
		int expectedResult = 2 + 3;
		int actualResult = calculator.add(2, 3);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_substract_two_numbers_and_return_result() {
		int expectedResult = 2 - 3;
		int actualResult = calculator.sub(2, 3);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_multiply_two_numbers_and_return_result() {
		int expectedResult = 2 * 3;
		int actualResult = calculator.multiply(2, 3);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_divide_two_numbers_and_return_result() {
		float expectedResult = 4 / 2;
		float actualResult = calculator.divide(4, 2);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_throw_an_arithmetic_exception_if_denominator_is_zero() {
		Exception exception = assertThrows(ArithmeticException.class, () -> {
			calculator.divide(4, 0);
		});
		
		String expectedMessage = "ZeroDivisionError";
		String actualMessage = exception.getMessage();
		
		assertEquals(expectedMessage, actualMessage);
	}
}