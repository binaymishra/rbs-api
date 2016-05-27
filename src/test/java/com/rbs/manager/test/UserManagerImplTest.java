package com.rbs.manager.test;

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
import com.rbs.domain.User;
import com.rbs.exceptions.RbsException;
import com.rbs.manager.UserManager;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class UserManagerImplTest {
	private static final Logger LOGGER = Logger.getLogger(UserManagerImplTest.class);

	@Autowired
	@Qualifier("userManager")
	private UserManager userManager;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {	}

	@Before
	public void setUp() throws Exception {	}

	@After
	public void tearDown() throws Exception {	}

	@Test
	public void test_authenticate_success() throws RbsException {
		User user = userManager.authenticate("vinay", "bWlzaHJh");
		Assert.assertNotNull(user);
		LOGGER.debug(user);
	}

	@Test(expected = RbsException.class)
	public void test_authenticate_failed() throws RbsException {
		userManager.authenticate("vinay_wrong", "password_wrong");
	}
}
