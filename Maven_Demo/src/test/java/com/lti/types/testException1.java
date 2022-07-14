package com.lti.types;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.lti.entity.Calculator;

class testException1 {

	@Test
	  void testException() {

		  Calculator c= new Calculator();
		  
		  final Exception e = assertThrows(ArithmeticException.class, () -> {
			  c.searchEmpId(0);
	    
	    });
	    Assertions.assertEquals("u enetered zero",e.getMessage());
	  }

}
