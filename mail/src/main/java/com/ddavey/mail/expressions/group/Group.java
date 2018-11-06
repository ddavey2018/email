package com.ddavey.mail.expressions.group;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.ddavey.mail.expressions.Criterion;

import lombok.Getter;
import lombok.Setter;

public abstract class Group implements Criterion {
	public enum AndOr {
		AND, OR
	};

	@Getter
	protected AndOr andOr = AndOr.AND;

	@Getter
	@Setter
	protected Criterion[] criteria;

	protected Group(AndOr andOr, Criterion... criteria) {
		this.andOr = andOr;
		this.criteria = criteria;
		assertNotNull(criteria);
		assertNotEquals(0, criteria.length);
	}

	protected Group() {
	}

}
