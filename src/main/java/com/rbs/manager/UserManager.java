package com.rbs.manager;

import com.rbs.domain.User;
import com.rbs.exceptions.RbsException;

/**
 * @author Binay Mishra
 *
 */
public interface UserManager {

	/**
	 * @param username
	 * @param password
	 * @return
	 * @throws RbsException
	 */
	public User authenticate(String username, String password) throws RbsException;

}
