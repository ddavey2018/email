package com.ddavey.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

@Service
public class MailAccountRepo {
	@Autowired
	private DynamoDBMapper dynamodb;

	public void list(DynamoDBScanExpression expression) {
		dynamodb.scanPage(clazz, expression);
	}
}
