/**
 * 
 */
package com.centrica.httptask.service.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author wemccl
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Greeting {

	public Greeting() {		
	}
	
    private String message;

    public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}
	

	public Greeting(String s) { 
       this.message = s;
    }
}
