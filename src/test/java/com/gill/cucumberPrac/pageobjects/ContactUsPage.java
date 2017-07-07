package com.gill.cucumberPrac.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsPage {
	
    WebDriver driver;

	@FindBy(tagName = "body")
	private WebElement heading;
	
	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean getHeading(String pageHeading){
		return heading.getText().contains(pageHeading);
	}

}
