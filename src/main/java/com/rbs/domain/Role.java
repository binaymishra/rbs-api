package com.rbs.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Binay Mishra
 *
 */
@JsonInclude(value=Include.NON_EMPTY, content=Include.NON_NULL)
public class Role {

	private Long   id;
	private String role;

	public Role() {
		// Default constructor.
	}

	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
				.append(role)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		Role other = (Role) obj;
		return new EqualsBuilder()
				.append(role, other.role)
				.build();
	}

	@Override
	  public String toString() {
	    return new ReflectionToStringBuilder(this,
	    		new RecursiveToStringStyle()).build();
	  }
}
