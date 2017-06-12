/**
 * 
 */
package com.centrica.httptask.service.model;

/**
 * @author wemccl
 *
 */
public class Motd {

    private String message;

    public String getMessage() {
		return message;
	}
	

	public void setMessage(String message) {
		this.message = message;
	}
	

	public Motd(String s) { 
       this.message = s;
    }	
}
