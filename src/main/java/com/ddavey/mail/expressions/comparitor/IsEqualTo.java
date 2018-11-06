package com.ddavey.mail.expressions.comparitor;

public class IsEqualTo extends TwoSidedComparitor {

	public IsEqualTo(String lhs, String rhs) {
		super(lhs, rhs);
	}

	@Override
	protected Type getType() {
		return Type.IS_EQUAL_TO;
	}

	@Override
	public boolean isTrue() {
		return lhs.equals(rhs);
	}

}
