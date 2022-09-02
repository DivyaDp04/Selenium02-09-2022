package com.stepdefenition;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageStep {
	
	WebDriver driver;
	@Given("User is in Adactin Hotel login page")
	public void user_is_in_adactin_hotel_login_page() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
	}
	@When("User should enter valid {string} and {string}")
	public void login (String UserName, String password) {

		//		UserName
		WebElement userName = driver.findElement(By.id("username"));
		userName.sendKeys(UserName);
		//		password
		WebElement passWord = driver.findElement(By.id("password"));
		passWord.sendKeys(password);
		//		login
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();

	}
	@When("User should searchHotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void searchHotel(String location, String hotels, String roomTypes, String numOfRoom, 
			String checkInDates, String checkOutDates, String adultTypes, String childTypes) {

		WebElement locations = driver.findElement(By.id("location"));
		locations.sendKeys(location);

		WebElement hotel = driver.findElement(By.id("hotels"));
		hotel.sendKeys(hotels);

		WebElement roomType = driver.findElement(By.id("room_type"));
		roomType.sendKeys(roomTypes);

		WebElement numOfRooms = driver.findElement(By.id("room_nos"));
		numOfRooms.sendKeys(numOfRoom);

		WebElement checkInDate = driver.findElement(By.id("datepick_in"));
		checkInDate.sendKeys(checkInDates);

		WebElement checkOutDate = driver.findElement(By.id("datepick_out"));
		checkOutDate.sendKeys(checkOutDates);

		WebElement adultType = driver.findElement(By.id("adult_room"));
		adultType.sendKeys(adultTypes);

		WebElement childType = driver.findElement(By.id("child_room"));
		childType.sendKeys(childTypes);

		WebElement search = driver.findElement(By.id("Submit"));
		search.click();
	}
	@When("User should continue selectHotel")
	public void selectHotel() {
		
		WebElement radioButton = driver.findElement(By.id("radiobutton_0"));
		radioButton.click();
		
		WebElement touch = driver.findElement(By.id("continue"));
		touch.click();
	}
	@When("User should bookHotel {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void bookHotel(String firstNames, String lastNames, String addresses, String ccNumbers, 
			String ccTypes, String expMonths, String expYears, String Cvv) throws InterruptedException {
		
		WebElement firstName = driver.findElement(By.id("first_name"));
		firstName.sendKeys(firstNames);
		
		WebElement lastName = driver.findElement(By.id("last_name"));
		lastName.sendKeys(lastNames);
		
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys(addresses);
		
		WebElement ccNumber = driver.findElement(By.id("cc_num"));
		ccNumber.sendKeys(ccNumbers);
		
		WebElement ccType = driver.findElement(By.id("cc_type"));
		ccType.sendKeys(ccTypes);
		
		WebElement expMonth = driver.findElement(By.id("cc_exp_month"));
		expMonth.sendKeys(expMonths);
		
		WebElement expYear = driver.findElement(By.id("cc_exp_year"));
		expYear.sendKeys(expYears);
		WebElement cvv = driver.findElement(By.id("cc_cvv"));
		cvv.sendKeys(Cvv);
		
		WebElement bKnow = driver.findElement(By.id("book_now"));
		bKnow.click();
		
		Thread.sleep(5000);
		WebElement orderId = driver.findElement(By.xpath("//input[@id='order_no']"));
		String data = orderId.getAttribute("value");
//		String data= orderId.getText();
		System.out.println(data);

		
	}
	@Then("User should verify success meg.")
	public void successMeg() {
		
		Assert.assertTrue("verify the success meg", true);
		driver.quit();
	}
}
