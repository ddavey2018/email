package com.ddavey.mail.expressions.group;

import com.ddavey.mail.expressions.Criterion;

public final class OrGroup extends Group {

	protected OrGroup(Criterion... criteria) {
		super(AndOr.OR, criteria);
	}

	@Override
	public boolean isTrue() {
		for (Criterion criteria : getCriteria()) {
			if (criteria.isTrue()) {
				return true;
			}
		}
		return false;
	}

}
