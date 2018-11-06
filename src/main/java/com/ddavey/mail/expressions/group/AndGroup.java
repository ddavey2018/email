package com.ddavey.mail.expressions.group;

import com.ddavey.mail.expressions.Criterion;

import lombok.Builder;

@Builder
public class AndGroup extends Group {

	protected AndGroup(Criterion... criteria) {
		super(AndOr.AND, criteria);
	}

	public AndGroup() {
	}

	@Override
	public boolean isTrue() {
		for (Criterion criteria : getCriteria()) {
			if (!criteria.isTrue()) {
				return false;
			}
		}
		return true;
	}

}
