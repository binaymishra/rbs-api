package com.rbs.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.rbs.domain.User;

public class UserRowMapper implements RowMapper<User> {

	private User user;

	public UserRowMapper() {
		// Default constructor;
	}

	public UserRowMapper(User user) {
		super();
		this.user = user;
	}

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {

		if(null == user)
			user = new User();

		user.setId(rs.getLong("user_id"));
		user.setUsername(rs.getString("user_name"));
		user.setPassword(rs.getString("user_password"));

		return user;
	}

}
