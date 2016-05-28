package com.rbs.repository;

import java.util.List;

import com.rbs.domain.Permission;
import com.rbs.domain.User;

/**
 * @author Binay Mishra
 *
 */
public interface UserRepository {

	public User fetchByUsernameAndPassword(String username, String password);

	public List<Permission> fetchPermissionsByRoleId(Long roleId);
}
