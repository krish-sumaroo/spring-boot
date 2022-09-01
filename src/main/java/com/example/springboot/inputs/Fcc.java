package com.example.springboot.inputs;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;


@Validated
public class Fcc {
	
	@NotEmpty
	@Size(min = 5, max = 200, message = "{validation.name.size}")
	private String fcc;

	public String getFcc() {
		return fcc;
	}

	public void setFcc(String fcc) {
		this.fcc = fcc;
	}
	
	
	public Fcc(@Size(min = 5, max = 200, message = "{validation.name.size}") @Valid String fcc) {
		this.fcc = fcc;
	}
	

	@Override
	public String toString() {
		
		if(this.fcc.length() > 5) {
			this.fcc = "newFcc";
		}
		
		return this.fcc;
		
	}
	
	

}
