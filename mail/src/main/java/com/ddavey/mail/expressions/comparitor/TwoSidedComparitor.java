package com.ddavey.mail.expressions.comparitor;

import lombok.Data;

@Data
public abstract class TwoSidedComparitor extends Comparitor {
	protected String rhs;

	protected TwoSidedComparitor(String lhs, String rhs) {
		this.lhs = lhs;
		this.rhs = rhs;
	}
}
