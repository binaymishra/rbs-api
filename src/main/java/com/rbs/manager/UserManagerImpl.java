package com.rbs.manager;

import java.util.HashSet;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.rbs.domain.Permission;
import com.rbs.domain.Role;
import com.rbs.domain.User;
import com.rbs.exceptions.DataBaseException;
import com.rbs.exceptions.RbsException;
import com.rbs.repository.UserRepository;

/**
 * @author Binay Mishra
 *
 */
@Service("userManager")
public class UserManagerImpl implements UserManager {

	private UserRepository userRepository;

	@Autowired
	public UserManagerImpl(@Qualifier("userRepository") UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/*
	 * @see com.rbs.manager.UserManager#authenticate(java.lang.String, java.lang.String)
	 */
	@Override
	public User authenticate(String username, String password) throws RbsException {
		try {
			User user = userRepository.fetchByUsernameAndPassword(username, password);
			if(null == user)
				throw new RbsException("Invalid username or password");

				setRolesToUser(user);

			return user;
		} catch (DataBaseException dataBaseException) {
			throw new RbsException("Something wrong with database." ,dataBaseException);
		}
	}

	/*
	 * This method sets respective roles to user.
	 *
	 * @param user
	 */
	public void setRolesToUser(final User user) throws RbsException{
		try {
  			List<Role> roles = userRepository.fetchRolesByUserId(user.getId());
  			setPermissionsToRoles(roles);
  			user.setRoles(new HashSet<Role>(roles));
		}catch (DataBaseException dataBaseException) {
			throw new RbsException("Something wrong with database.", dataBaseException);
		}
	}

	/*
	 * This method sets the permissions to the respective roles of the User.
	 *
	 * @param user
	 * @throws RbsException
	 */
	private void setPermissionsToRoles(final List<Role> roles) throws RbsException {
		try {
			if (CollectionUtils.isNotEmpty(roles))
				for (Role role : roles) {
					List<Permission> permissions = userRepository.fetchPermissionsByRoleId(role.getId());
					if (CollectionUtils.isNotEmpty(permissions))
						role.setPermissions(new HashSet<Permission>(permissions));
				}
		} catch (DataBaseException dataBaseException) {
			throw new RbsException("Something wrong with database.", dataBaseException);
		}
	}
}
