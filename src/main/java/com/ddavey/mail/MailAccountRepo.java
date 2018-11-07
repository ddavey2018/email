package com.ddavey.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.QueryResultPage;

@Service
public class MailAccountRepo {
	@Autowired
	private DynamoDBMapper dynamodb;

	public QueryResultPage<MailAccount> list(DynamoDBQueryExpression<MailAccount> expression) {
		return dynamodb.queryPage(MailAccount.class, expression);
	}
}
