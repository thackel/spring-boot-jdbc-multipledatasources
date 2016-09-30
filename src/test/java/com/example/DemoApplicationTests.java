package com.example;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private DataSource primaryDataSource;

	@Autowired
	@Qualifier("second")
	private DataSource secondaryDataSource;

	@Test
	public void contextLoads() throws SQLException {
		Assert.assertNotNull(primaryDataSource);
		Assert.assertNotNull(secondaryDataSource);
		Assert.assertNotEquals(primaryDataSource, secondaryDataSource);
		Assert.assertNotNull(primaryDataSource.getConnection());
		Assert.assertNotNull(secondaryDataSource.getConnection());
	}

}
