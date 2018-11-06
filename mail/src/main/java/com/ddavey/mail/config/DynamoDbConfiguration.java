package com.ddavey.mail.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.ListTablesResult;

@Configuration
public class DynamoDbConfiguration {

	@Bean
	public AmazonDynamoDB dynamoDb() throws Exception {
		AmazonDynamoDB dynamodb = null;

		dynamodb = AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
				new AwsClientBuilder.EndpointConfiguration("http://localhost:8000", "us-west-2")).build();
		listTables(dynamodb.listTables(), "DynamoDB Local over HTTP");
		return dynamodb;
	}

	@Bean
	@Autowired
	public DynamoDBMapper dynamoDbMapper(AmazonDynamoDB client) {
		return new DynamoDBMapper(client);
	}

	public static void listTables(ListTablesResult result, String method) {
		System.out.println("found " + Integer.toString(result.getTableNames().size()) + " tables with " + method);
		for (String table : result.getTableNames()) {
			System.out.println(table);
		}
	}
}
