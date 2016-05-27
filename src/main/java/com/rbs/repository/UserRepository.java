package com.rbs.repository;

import com.rbs.domain.User;

/**
 * @author Binay Mishra
 *
 */
public interface UserRepository {
	
	public User fetchByUsernameAndPassword(String username, String password);
}
