package test;

import java.util.GregorianCalendar;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Calendar;

class TestCalendar {

	@ParameterizedTest
	@ValueSource(ints = {1825, 1910, 1955, 2002, 2021})
	public void Should_check_if_year_is_leap_also_in_gregorian(int year) {
		Calendar cal = new Calendar(year);
		GregorianCalendar gregCal = new GregorianCalendar();
		
		boolean expectedResult = gregCal.isLeapYear(year);
		boolean actualResult = cal.isLeapYear();
		
		assertEquals(expectedResult, actualResult);
	}

	// test cases for equivalent partitions:
	
	// 1. equivalence class: year <= 1900 --> should return false
	@Test
	public void Should_check_if_year_is_not_leap_if_year_less_than_1900() {
		Calendar cal = new Calendar(1900);
		
		assertFalse(cal.isLeapYear());
	}
	
	// 2. equivalence class: year > 2000  --> should return false
	@Test
	public void Should_check_if_year_is_not_leap_if_year_is_higher_than_2000() {
		Calendar cal = new Calendar(2001);
		
		assertFalse(cal.isLeapYear());
	}
	
	// 3. equivalence class: year > 1900 & <= 2000 & not divisible by 4 --> should return false 
	@Test
	public void Should_check_if_year_is_not_leap_if_not_divisible_by_4() {
		Calendar cal = new Calendar(1995);
		
		assertFalse(cal.isLeapYear());
	}
	
	// 4. equivalence class: year > 1900 & <= 2000 & divisible by 4 & not divisible by 100 --> should return true
	@Test
	public void Should_check_if_year_is_leap_if_divisible_by_4_and_not_divisible_by_100() {
		Calendar cal = new Calendar(1996);
		
		assertTrue(cal.isLeapYear());
	}
	
	// 5. equivalence class: year > 1900 & <= 2000 & divisible by 4 & divisble by 400 --> should return true
	@Test
	public void Should_check_if_year_is_leap_if_divisible_by_4_and_divisible_by_400() {
		Calendar cal = new Calendar(2000);
		
		assertTrue(cal.isLeapYear());
	}

}