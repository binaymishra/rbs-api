package com.rbs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rbs.domain.Role;

public class RoleRowMapper implements RowMapper<Role> {

	@Override
	public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Role role = new Role(rs.getLong("role_id"), rs.getString("role_name"));
		return role;
	}

}
