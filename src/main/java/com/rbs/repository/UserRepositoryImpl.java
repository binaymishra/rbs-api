package com.rbs.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.rbs.domain.Permission;
import com.rbs.domain.Role;
import com.rbs.domain.User;
import com.rbs.exceptions.DataBaseException;

/**
 * @author Binay Mishra
 *
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

	private static final String USER_SQL = "SELECT user_id, user_name, user_password FROM USER_TABLE  WHERE user_name = ? AND user_password = ?";
	private static final String ROLES_BY_USER_ID_SQL = "SELECT role.role_id, role_name FROM AUTHORIZATION_TABLE auth, ROLE_TABLE  role WHERE auth.AUTH_ROLE_ID = role.ROLE_ID AND auth.AUTH_USER_ID = ?";
	private static final String USER_ROLE_ID_PERMISSION_SQL = "SELECT permission.permission_id, permission.permission_name, permission.permission_enable FROM PERMISSION_TABLE permission, AUTHORIZATION_TABLE auth WHERE permission.permission_id = auth.auth_permission_id AND auth.auth_role_id = ?";

	private JdbcTemplate template;

	@Autowired
	public UserRepositoryImpl(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	/* (non-Javadoc)
	 * @see com.rbs.repository.UserRepository#fetchByUsernameAndPassword(java.lang.String, java.lang.String)
	 */
	@Override
	public User fetchByUsernameAndPassword(String username, String password) {
		User user = null;
		try {
			user = template.queryForObject(USER_SQL, new UserRowMapper(), username, password);
		} catch (DataAccessException dataAccessException) {
			throw new DataBaseException(dataAccessException.getMessage(), dataAccessException);
		}
		return user;
	}


	/* (non-Javadoc)
	 * @see com.rbs.repository.UserRepository#fetchRolesByUserId(java.lang.Long)
	 */
	@Override
	public List<Role> fetchRolesByUserId(Long userId) {
		try {
			return template.query(ROLES_BY_USER_ID_SQL, new RoleRowMapper(), userId);
		} catch (DataAccessException dataAccessException) {
			throw new DataBaseException(dataAccessException.getMessage(), dataAccessException);
		}
	}
	/* (non-Javadoc)
	 * @see com.rbs.repository.UserRepository#fetchPermissionsByRoleId(java.lang.Long)
	 */
	@Override
	public List<Permission> fetchPermissionsByRoleId(Long roleId) {
		try {
			return template.query(USER_ROLE_ID_PERMISSION_SQL, new PermissionRowMapper(), roleId);
		} catch (DataAccessException dataAccessException) {
			throw new DataBaseException(dataAccessException.getMessage(), dataAccessException);
		}
	}

}
