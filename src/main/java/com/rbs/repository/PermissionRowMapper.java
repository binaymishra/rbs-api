package com.rbs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rbs.domain.Permission;

public class PermissionRowMapper implements RowMapper<Permission> {

	@Override
	public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
		final Permission permission = new Permission(
				rs.getLong("permission_id"),
				rs.getString("permission_name"),
				rs.getBoolean("permission_enable"));
		return permission;
	}

}
