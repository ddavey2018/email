package com.ddavey.mail;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

public abstract class Repo<T> {
	private DynamoDBMapper dynamodb;
	private Class<T> cls;

	protected Repo(DynamoDBMapper dynamodb) {
		this.dynamodb = dynamodb;
	}

	public <T> void list(DynamoDBQueryExpression<T> expression) {
		// dynamodb.query(expression., expression);
	}
}
