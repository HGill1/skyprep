package com.gill.cucumberPrac.stepdefination;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gill.cucumberPrac.mappingObjects.ContactUs;
import com.gill.cucumberPrac.pageobjects.ContactPage;
import com.gill.cucumberPrac.pageobjects.ContactUsPage;
import com.gill.cucumberPrac.pageobjects.HomePage;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class DatadrivenSteps {

	protected static WebDriver driver;	
	
	@Given("^I navigate to zoo website$")
	public void i_navigate_to_zoo_website() throws Throwable {
	  System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
	  ChromeOptions chromeOptions = new ChromeOptions();
	  DesiredCapabilities capabilities =  DesiredCapabilities.chrome();
	  capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
	  driver = new ChromeDriver(capabilities);
	  driver.navigate().to("http://www.thetestroom.com/webapp/index.html");
	}

	@When("^I navigate to contact form$")
	public void i_navigate_to_contact_form() throws Throwable {
	  HomePage homePage =  new HomePage(driver);
	  homePage.clickContact();
	}

	@When("^I submit the form with valid data$")
	public void i_submit_the_form_with_valid_data(List<ContactUs> contactUs) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		ContactPage contactPage =  new ContactPage(driver);
		
		for (ContactUs contactField : contactUs) {
			contactPage.fillForm(contactField.getName(),
					contactField.getAddress(), contactField.getPostcode(),contactField.getEmail());
		}

		//contactPage.fillForm(data.get(1).get(1), data.get(2).get(1), data.get(3).get(1), data.get(4).get(1));
	}

	@Then("^I check that the form has been submitted$")
	public void i_check_that_the_form_has_been_submitted() throws Throwable {
	   ContactUsPage contactUsPage = new ContactUsPage(driver);
	   Assert.assertTrue(contactUsPage.getHeading("We have your message"));
	}

	
}
