package com.example.springboot.validation;

import javax.validation.constraints.Min;

public class InputValidation {
	
	public static String fcc(String fccValue) {		
		
		if(fccValue.length() > 3) {
			return fccValue;
		}
		else {
			return "another";
		}
		
	}
	
	
	

}
