/**
 * 
 */
package com.centrica.httptask.api.model;

/**
 * @author wemccl
 *
 */
public class Employee {

	private String id ;
	private String name ;	
    private String motd;

    
    public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	/**
     * 
     * @param name
     */
	public Employee(String id) { 
       this.id = id;
    }
	
	/**
	 * 
	 * @return
	 */
    public String getMotd() {
		return motd;
	}
    
	/**
	 * 
	 * @param motd
	 */
	public void setMotd(String motd) {
		this.motd = motd;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
