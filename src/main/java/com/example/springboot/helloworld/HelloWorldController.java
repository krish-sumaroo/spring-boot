package com.example.springboot.helloworld;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.HttpStatus;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.inputs.Fcc;
import com.example.springboot.validation.InputValidation;

@RestController
@Validated
public class HelloWorldController {
	
	
	@GetMapping(path="/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path="/hello-world/id/{id}")
	public HelloWorldBean helloWorldVar(@PathVariable String id) {
		return new HelloWorldBean(String.format("hello world, %s", id));
	}
	
	
	@GetMapping(path="/hello-world-bean")
	public HelloWorldBean helloWorldBean() {		
		return new HelloWorldBean("Hello World");		
	}
	
	@GetMapping(path="/validation_static/{fcc}")
	public HelloWorldBean fcc1(@PathVariable String fcc) {		
		
		String newFcc = InputValidation.fcc(fcc);
		return new HelloWorldBean(newFcc);		
	}
	
	@GetMapping(path="/validation/{fcc}")
	public String fcc(@Valid @PathVariable  Fcc fcc) {		

		return fcc.toString();		
	}
	
	@GetMapping(path="/validation2/{fcc}")
	public String fcc2(@Size(min = 5, max = 200, message = "{validation.name.size}") @Valid @PathVariable  Fcc fcc) {		

		return fcc.toString();
		
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	  @ResponseStatus(HttpStatus.BAD_REQUEST)
	  ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
	    return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	  }

}
