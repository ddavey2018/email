package com.ddavey.mail.rules;

import java.util.List;

import com.ddavey.mail.expressions.Criterion;
import com.ddavey.mail.rules.actions.Action;

import lombok.Data;

@Data
public class Rule {
	private Criterion criteria;
	private List<Action> actions;
}
