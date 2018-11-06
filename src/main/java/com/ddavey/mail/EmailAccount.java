package com.ddavey.mail;

import lombok.Data;

@Data
public abstract class EmailAccount {
	protected String emailAddress;
	protected boolean connected = false;

	protected EmailAccount(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	protected EmailAccount() {
	}

	public abstract MailConnector getMailConnector();
}
