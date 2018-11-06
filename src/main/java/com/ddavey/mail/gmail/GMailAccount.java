package com.ddavey.mail.gmail;

import com.ddavey.mail.EmailAccount;
import com.ddavey.mail.MailConnector;

import lombok.Data;

@Data
public class GMailAccount extends EmailAccount {
	private String accessToken;
	private String refreshToken;

	public GMailAccount(String emailAddress, String accessToken, String refreshToken) {
		super(emailAddress);
	}

	public GMailAccount() {
		super();
	}

	@Override
	public MailConnector getMailConnector() {
		// TODO Auto-generated method stub
		return null;
	}

}
