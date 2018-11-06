package com.ddavey.mail;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;

public abstract class Repo<T extends Object> {
	private DynamoDBMapper dynamodb;
	private Class<T> cls;

	protected Repo(DynamoDBMapper dynamodb, Class<T> cls) {
		this.dynamodb = dynamodb;
		this.cls = cls;
	}

	public <T> void list(DynamoDBQueryExpression<T> expression) {
		dynamodb.query(cls, expression);
	}
}
