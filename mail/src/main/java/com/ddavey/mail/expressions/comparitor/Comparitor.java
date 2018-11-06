package com.ddavey.mail.expressions.comparitor;

import com.ddavey.mail.expressions.Criterion;

import lombok.Getter;
import lombok.Setter;

public abstract class Comparitor implements Criterion {
	@Getter
	@Setter
	protected String lhs;

	public enum Type {
		IS_EQUAL_TO, IS_NOT_EQUAL_TO, CONTAINS
	};

	@Getter
	private Type comparitorType;

	protected abstract Type getType();

}
