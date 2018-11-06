package com.ddavey.mail.expressions.group;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ddavey.mail.expressions.comparitor.Contains;
import com.ddavey.mail.expressions.comparitor.IsEqualTo;

@SpringBootTest
public class GroupTests {
	@Test
	public void andGroupTests() {
		assertTrue(new AndGroup(new IsEqualTo("aaa", "aaa"), new Contains("aaa", "a")).isTrue());
		assertTrue(new AndGroup(new AndGroup(new IsEqualTo("aaa", "aaa"), new Contains("aaa", "a")),
				new AndGroup(new IsEqualTo("bbb", "bbb"), new Contains("bbb", "b"))).isTrue());
	}

	@Test
	public void orGroupTests() {
		assertTrue(new OrGroup(new IsEqualTo("aaa", "aaa"), new Contains("aaa", "a")).isTrue());
		assertTrue(new OrGroup(new IsEqualTo("aaa", "bbb"), new Contains("aaa", "a")).isTrue());
		assertTrue(new OrGroup(new AndGroup(new IsEqualTo("aaa", "bbb"), new Contains("aaa", "c")),
				new AndGroup(new IsEqualTo("bbb", "bbb"), new Contains("bbb", "b"))).isTrue());
	}
}
