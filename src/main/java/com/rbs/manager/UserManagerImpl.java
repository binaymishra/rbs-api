package com.rbs.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

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
			return user;
		} catch (DataBaseException dataBaseException) {
			throw new RbsException("Something wrong with database." ,dataBaseException);
		}
	}

}
