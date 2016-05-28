package com.rbs.domain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.RecursiveToStringStyle;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_EMPTY, content = Include.NON_NULL)
public class Permission {

	private Long id;
	private String name;
	private Boolean enable;

	public Permission() {
		// Default Constructor
	}

	public Permission(Long id, String name, Boolean enable) {
		super();
		this.id = id;
		this.name = name;
		this.enable = enable;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *          the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *          the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enable
	 */
	public Boolean getEnable() {
		return enable;
	}

	/**
	 * @param enable
	 *          the enable to set
	 */
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(3, 9).append(id).append(name).append(enable).build();
	}

	@Override
	public boolean equals(Object obj) {
		Permission other = (Permission) obj;
		return new EqualsBuilder().append(id, other.id).append(name, other.name).append(enable, other.enable).build();
	}

	@Override
	public String toString() {
		return new ReflectionToStringBuilder(this, new RecursiveToStringStyle()).build();
	}

}
