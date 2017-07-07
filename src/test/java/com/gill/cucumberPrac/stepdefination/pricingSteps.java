package com.gill.cucumberPrac.stepdefination;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gill.cucumberPrac.pageobjects.SSEHomePage;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class pricingSteps {
	
	static WebDriver driver;
	
	@Before
	public void beforeScenario(){
		   System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
		   ChromeOptions options =  new ChromeOptions();
		   DesiredCapabilities capabilities =  new DesiredCapabilities();
		   capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		   driver =  new ChromeDriver();
	}
	
	@After
	public void afterScenario(){
		driver.close();
	}
	
	@Given("^I navigate to sse website$")
	public void i_navigate_to_sse_website() throws Throwable {
	   driver.navigate().to("https://sse.co.uk");
	}

	@Given("^I go to pricing and tariff Information$")
	public void i_go_to_pricing_and_tariff_Information() throws Throwable {
	   SSEHomePage sseHomePage = new SSEHomePage(driver);
	   sseHomePage.gotoPricingAndTarrifInfo();
	}

	@When("^I enter the post code \"([^\"]*)\"$")
	public void i_enter_the_post_code(String postCode) throws Throwable {
		SSEHomePage sseHomePage = new SSEHomePage(driver);
		sseHomePage.enterPostCode(postCode);
		sseHomePage.clickTariffButton();
	}

	@Then("^I see the pricing details for \"([^\"]*)\"$")
	public void i_see_the_pricing_details_for(String tariffType) throws Throwable {
		SSEHomePage sseHomePage = new SSEHomePage(driver);
		sseHomePage.getTariff(tariffType);
	}

	@Then("^price value of should be \"([^\"]*)\"$")
	public void price_value_of_should_be(String price) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
