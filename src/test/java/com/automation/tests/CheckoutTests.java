package com.automation.tests;

//import org.openqa.selenium.devtools.v127.autofill.model.CreditCard;

import com.automation.base.BaseTest;
import com.automation.testdata.TestDataFactory;
import com.automation.testdata.TestPaymentBuilder;
import com.automation.models.CreditCard;

public class CheckoutTests extends BaseTest{

	//CreditCard visa = new CreditCard("12345", "John", "08", "2002", "123");
	
	CreditCard visa = TestDataFactory.createValidVisaCard();
	
	CreditCard payment = TestPaymentBuilder
			.from(visa)
			.withCardHolder(null)
			.withCardNumber(null)
			.withExpiryYear(null)
			.withCvv(null)
			.build();
;

	
}
