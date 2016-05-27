package com.rbs.repository;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rbs.domain.User;

/**
 * @author Binay Mishra
 *
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	private static final String USER_SQL = "SELECT user.USER_ID, user.USER_NAME, user.USER_PASSWORD, role.ROLE_NAME FROM USER_TABLE user, ROLE_TABLE role WHERE user.USER_ID = role.ROLE_USER_ID AND user.USER_NAME = ? AND user.USER_PASSWORD = ?";

	private JdbcTemplate template;

	@Autowired
	public UserRepositoryImpl(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	/*
	 * @see com.rbs.repository.UserRepository#fetchByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User fetchByUsernameAndPassword(String username, String password) {
		return template.query(USER_SQL, new UserRowMapper(new User()), username, password).get(0);
	}

}
