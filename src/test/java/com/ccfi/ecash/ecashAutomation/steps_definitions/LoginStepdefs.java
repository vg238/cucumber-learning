package com.ccfi.ecash.ecashAutomation.steps_definitions;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ccfi.ecash.ecashAutomation.config.PropertiesReader;
import com.ccfi.ecash.ecashAutomation.config.SharedDriver;

import cucumber.api.java8.En;

public class LoginStepdefs implements En {
	
	public LoginStepdefs(SharedDriver driver, PropertiesReader propertiesReader) {
		Given("^I open nationwide$", () -> {
			System.out.println("IN HERE");
			Properties p = propertiesReader.getProperties();
			System.out.println(p.get("teller_username"));
			driver.get("http://www.nationwide.com");

		});

		And("^get a Quote for (\\d+)$", (Integer arg1) -> {			
			WebDriverWait wait = new WebDriverWait(driver, 1);
			wait.until(ExpectedConditions.elementToBeClickable(By.id("zipInput")));
			(driver.findElement(By.id("zipInput"))).sendKeys(arg1.toString());
			System.out.println("Value entered");
		});
	}

}
