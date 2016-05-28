package com.rbs.repository.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rbs.config.ApplicationConfig;
import com.rbs.domain.Permission;
import com.rbs.domain.User;
import com.rbs.exceptions.DataBaseException;
import com.rbs.repository.UserRepository;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class UserRepositoryImplTest {

	private static final Logger LOGGER = Logger.getLogger(UserRepositoryImplTest.class);

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {	}

	@Before
	public void setUp() throws Exception {	}

	@After
	public void tearDown() throws Exception {	}

	@Test
	public void test_fetchByUsernameAndPassword() {
		User user = userRepository.fetchByUsernameAndPassword("vinay", "bWlzaHJh");
		Assert.assertNotNull(user);
		LOGGER.debug(user);
	}

	@Test(expected=DataBaseException.class)
	public void test_fetchByWrongUsernameAndPassword() {
		User user = userRepository.fetchByUsernameAndPassword("vinay", "wrong password");
		Assert.assertNull(user);
	}

	@Test
	public void test_fetchPermissionsByRoleId_success(){
		List<Permission> permissions = userRepository.fetchPermissionsByRoleId(Long.valueOf(2));
		Assert.assertFalse(permissions.isEmpty());
		LOGGER.debug(permissions);
	}

	@Test
	public void test_fetchPermissionsByRoleId_failed(){
		List<Permission> permissions = userRepository.fetchPermissionsByRoleId(Long.valueOf(1002));
		Assert.assertTrue(permissions.isEmpty());
	}

}
