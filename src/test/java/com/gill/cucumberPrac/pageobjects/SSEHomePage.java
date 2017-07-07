package com.gill.cucumberPrac.pageobjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SSEHomePage {
	
	WebDriver driver;
	
	@FindBy(linkText = "Energy")
	private WebElement energyLink;
	
	@FindBy(xpath = "//*[contains(@title,'Prices and tariff information')]")
	private WebElement priceAndTariffLink;	
	
	@FindBy(id = "postcode")
	private WebElement txtPostcode;
	
	@FindBy(xpath = "//*[contains(@value,'View tariffs')]")
	private WebElement btnViewTariff;
	
	@FindBy(xpath = "(//*[@id='2']/h3)[1]")
	private WebElement fix2020Tariff;
	
	@FindAll(@FindBy(xpath = ".//*[@id='2']/table/tbody/tr"))
	private List<WebElement> tableRowsFix2020;
	
	@FindAll(@FindBy(css = ".best-value"))
	private List<WebElement> allTariff;
	
	public SSEHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickEnergyLink(){
		energyLink.click();
	}
	
	public void clickOnPriceAndTariffLink(){
		Actions action =  new Actions(driver);
		action.moveToElement(priceAndTariffLink).click().perform();		
	}
	
	public void enterPostCode(String postCode){
		txtPostcode.sendKeys(postCode);
	}
	
	public void clickTariffButton(){
		btnViewTariff.click();
	}
	
	public void gotoPricingAndTarrifInfo(){
		clickEnergyLink();
		clickOnPriceAndTariffLink();
	}
	
	public void getTariff(String tariff){
		for (WebElement webElement : tableRowsFix2020) {
			 List<WebElement> row = webElement.findElements(By.xpath("/th/span"));
			
			for (WebElement webElement2 : row) {
				System.out.println(webElement2.getText());
			}
			
		}
	}
}
