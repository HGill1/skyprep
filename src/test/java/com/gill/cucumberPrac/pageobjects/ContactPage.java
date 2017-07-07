package com.gill.cucumberPrac.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sun.awt.windows.WEmbeddedFramePeer;

public class ContactPage {
	
	WebDriver driver;	
	
	@FindBy(name = "name_field")
	private WebElement name;
	
	@FindBy(id="rinfo")
	private WebElement radiobutton;
	
	@FindBy(id="cdona")
	private WebElement checkbox;
	
	@FindBy(id = "slider-1")
	private WebElement sBar;
	
	@FindBy(name = "address_field")
	private WebElement address;
	
	@FindBy(name = "postcode_field")
	private WebElement postcode;
	
	@FindBy(name = "email_field")
	private WebElement email;
	
	@FindBy(id = "submit_message")
	private WebElement submitButton;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterName(String cname){
		name.sendKeys(cname);
	}
	
	public void enterAddress(String caddress){
		address.sendKeys(caddress);
	}
	
	public void enterPostCode(String cPostCode){
		postcode.sendKeys(cPostCode);
	}
	
	public void enterEmail(String cemail){
		email.sendKeys(cemail);
	}
	
	public void fillForm(String name, String address, String postcode, String email){
		this.enterName(name);
		this.enterAddress(address);
		this.enterPostCode(postcode);
		this.enterEmail(email);
		this.submitButton.click();
	}

}
