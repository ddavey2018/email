package com.ddavey.mail.expressions;

import lombok.Data;

@Data
public abstract class Expression implements Criterion {
	protected String lhs;
	protected String rhs;

}
