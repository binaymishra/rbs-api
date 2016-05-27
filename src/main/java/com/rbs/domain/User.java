package com.rbs.domain;

import java.util.Set;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

/**
 * @author Binay Mishra
 *
 */
public class User {
	private Long id;
	private String username;
	private String password;

	private Set<Role> roles;

	public User() {
		// Default constructor.
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
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the roles
	 */
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(3, 9)
				.append(id)
				.append(username)
				.build();
	}

	@Override
	public boolean equals(Object obj) {
		User other = (User) obj;
		return new EqualsBuilder()
				.append(id, id)
				.append(username, other.username)
				.build();
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this,
	    		new RecursiveToStringStyle()).build();
	}
}
