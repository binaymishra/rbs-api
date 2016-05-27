package com.rbs.repository.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rbs.config.ApplicationConfig;
import com.rbs.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class UserRepositoryImplTest {

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
		System.err.println(userRepository.fetchByUsernameAndPassword("vinay", "bWlzaHJh"));
	}

}
