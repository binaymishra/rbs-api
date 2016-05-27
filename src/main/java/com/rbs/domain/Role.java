package com.rbs.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Binay Mishra
 *
 */
public class Role {
	
	private String role;
	
	public Role() {
		// Default constructor.
	}

	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}

	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(3, 9)
				.append(this.role)
				.build();
	}
	
	@Override
	public boolean equals(Object obj) {
		Role other = (Role) obj;
		return new EqualsBuilder()
				.append(this.role, other.role)
				.build();
	}
	
	@Override
	  public String toString() {
	    return new ReflectionToStringBuilder(this, 
	    		new RecursiveToStringStyle()).build();
	  }
}
