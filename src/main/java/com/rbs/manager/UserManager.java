package com.rbs.manager;

import com.rbs.domain.User;

/**
 * @author Binay Mishra
 *
 */
public interface UserManager {
	
	/**
	 * @param username
	 * @param password
	 * @return
	 */
	public User authenticate(String username, String password);

}
