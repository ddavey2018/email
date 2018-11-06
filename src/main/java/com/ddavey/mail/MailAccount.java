package com.ddavey.mail;

import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBIndexHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.ddavey.mail.rules.Rule;

import lombok.Data;

@Data
@DynamoDBTable(tableName = "MailAccount")
public abstract class MailAccount {
	protected String username;
	@DynamoDBHashKey(attributeName = "accountId")
	protected Long accountId;

	@DynamoDBAutoGeneratedKey
	@DynamoDBIndexHashKey
	protected Integer mailAccountId;

	private List<Rule> rules;

	protected MailAccount(String username) {
		this.username = username;
	}

}
