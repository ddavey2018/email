package com.ddavey.mail.expressions.comparitor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ComparitorTests {
	@Test
	public void isEqualTo() {
		assertTrue(new IsEqualTo("aaa", "aaa").isTrue());
		assertFalse(new IsEqualTo("aaa", "bbb").isTrue());
	}

	@Test
	public void isContains() {
		assertTrue(new Contains("aaa", "a").isTrue());
		assertFalse(new Contains("aaa", "b").isTrue());
	}
}
