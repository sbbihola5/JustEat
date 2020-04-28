package Stepdefinition;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SearchRestaurant {
	WebDriver driver;

@Given("^I want food in \"([^\"]*)\"$")
public void i_want_food_in(String arg1) throws Throwable {
	System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
	 driver = new FirefoxDriver();
	 driver.get("https://www.just-eat.co.uk/");
	 Thread.sleep(3000);
	 driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("AR51 1AA");
	 Thread.sleep(3000);
}

@When("^I search for restaurants$")
public void i_search_for_restaurants() throws Throwable {
	//WebDriverWait wait = new WebDriverWait( driver , 10);
	//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), 'Search')]")));
			
	driver.findElement(By.className("Form_c-search-btn-text_1jLYr")).click();
}

@Then("^I should see some restaurants in \"([^\"]*)\"$")
public void i_should_see_some_restaurants_in(String arg1) throws Throwable {

	List<WebElement> restroList = driver
			.findElements(By.xpath("//div[@class='c-listing-loader'] //section"));
	
	System.out.println(" List size -->" + restroList.size());

	System.out.println("------ Restaurants---------");

	for (int i = 0; i < 5; i++) {
		
		System.out.println(restroList.get(i).getText());
	}
}

}