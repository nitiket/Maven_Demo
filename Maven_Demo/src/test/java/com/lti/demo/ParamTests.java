package com.lti.demo;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.sun.org.glassfish.gmbal.ParameterNames;

class ParamTests {
	
	@Disabled
	@ParameterizedTest
	@ValueSource(ints = {8,10,20,5,100})
	public void testArrays(int arg) {
		System.out.println(" arg: "+arg);
		Assertions.assertTrue(arg%2==0);
	}
	
	@Disabled
	@ParameterizedTest
	@DisplayName("Should pass all non-null arguments to method")
	@ValueSource(strings = {"Hello","World","GET1024"})
	public void testParam(String msg) {
		Assertions.assertNotNull(msg);
	}
	
	@Disabled
	@ParameterizedTest(name="#{index} = {0}")
	@DisplayName("Should pass all non-null arguments to method")
	@ValueSource(strings = {"Hello","Hello World","Hello GET1024"})
	public void testParam1(String msg) {
		String searchKey = "Hello";
		Assertions.assertNotNull(msg.contains(searchKey));
	}
	
	// log in 3 attempts - same code
	@RepeatedTest(3)
	public void shouoldRepeat() {
		int x = 10, y = 20;
		assertEquals(200, x*y);
	}
	
	// Junit 5 support lambda
	@Test
	public void testLambda() {
		
		Integer[] intAry = {3,7,5,2,10};
		List<Integer> numbers = Arrays.asList(intAry);
		
		Assertions.assertAll( () -> assertEquals(3, numbers.get(0)), 
							() -> assertEquals(7, numbers.get(1)),
							() -> assertEquals(5, numbers.get(2)),
							() -> assertEquals(2, numbers.get(3)),
							() -> assertEquals(10, numbers.get(4))
						);
		
	}
	
	// testing whether exceptions is called - excep obj got created
	@Test
	void testExceptions() {
		Assertions.assertThrows(NumberFormatException.class, ()->{
			Integer.parseInt("One");
		});
				
				
	}
	
	

}





















