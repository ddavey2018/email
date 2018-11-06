package com.ddavey.mail.expressions.comparitor;

public class Contains extends TwoSidedComparitor {

	public Contains(String lhs, String rhs) {
		super(lhs, rhs);
	}

	public boolean isTrue() {
		return lhs.contains(rhs);
	}

	@Override
	protected Type getType() {
		return Type.CONTAINS;
	}

}
