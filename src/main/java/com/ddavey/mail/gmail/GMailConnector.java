package com.ddavey.mail.gmail;

import com.ddavey.mail.MailClient;
import com.ddavey.mail.MailConnector;

public class GMailConnector implements MailConnector {
	private GMailAccount account;

	GMailConnector(GMailAccount account, String clientId, String clientSecret) {
		this.account = account;
	}

	@Override
	public MailClient connect() {

		return null;
	}

}
