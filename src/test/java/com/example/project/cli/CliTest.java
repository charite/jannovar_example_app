package com.example.project.cli;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class CliTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Assert.assertEquals(Cli.foo(), 42);
	}

}
