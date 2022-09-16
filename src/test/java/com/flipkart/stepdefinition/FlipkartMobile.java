package com.flipkart.stepdefinition;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class FlipkartMobile {
	
	static WebDriver driver;
	@Given("user launch flipkart")
	public void user_launch_flipkart() {
		System.out.println("Mobile Section");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\durai\\eclipse-workspace\\ExcelReadWrite\\dri\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}

	@Given("user login flipkart")
	public void user_login_flipkart() {
		System.out.println("Flipkart Login");
		WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
		close.click();
		System.out.println("================================");
	}
	
	String name = "";
		
		@When("user search mobile by using {string}")
		public void user_search_mobile_by_using(String phone) {
			System.out.println("Mobile Search using Phone");
			name = phone;
			WebElement src = driver.findElement(By.xpath("//input[@class='_3704LK']"));
			src.sendKeys(phone);
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			WebElement ent = driver.findElement(By.xpath("//button[@type='submit']"));
			driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
			ent.click();
			driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
			WebElement ent1 = driver.findElement(By.xpath("(//div[contains(text(),'"+name+"')])[2]"));
			ent1.click();
			System.out.println("=====================");
		}

	@When("user click the mobile and windows handling")
	public void user_click_the_mobile_and_windows_handling() {
		System.out.println("Windows Handling");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement nxtSrc = driver.findElement(By.xpath("(//span[contains(text(),'"+name+"')])[1]"));
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		nxtSrc.click();
		driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		String par = driver.getWindowHandle();
		Set<String> chi = driver.getWindowHandles();
		for (String string : chi) {
			if (!par.equals(string)) {
				driver.switchTo().window(string);
				driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			}
		}
		System.out.println("================================");
	}

	@When("user scrolldown to specification")
	public void user_scrolldown_to_specification() {
		System.out.println("Scroll Down");
	 	JavascriptExecutor js =(JavascriptExecutor)driver;
	 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	WebElement spec = driver.findElement(By.xpath("//div[text()='Specifications']"));
	 	js.executeScript("arguments[0].scrollIntoView(true)", spec);
	 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	System.out.println("================================");
	}

	@Then("user take screenshot")
	public void user_take_screenshot() throws IOException {
		System.out.println("Screen shot");
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File trg= new File("C:\\Users\\durai\\eclipse-workspace\\CucumberFlipkartProgram\\target\\ScreenshotiPhone.png");
		File trg1= new File("C:\\Users\\durai\\eclipse-workspace\\CucumberFlipkartProgram\\target\\Screenshotrealme.png");
		File trg2= new File("C:\\Users\\durai\\eclipse-workspace\\CucumberFlipkartProgram\\target\\ScreenshotSAMSUNG.png");
		FileUtils.copyFile(src, trg);
		FileUtils.copyFile(src, trg1);
		FileUtils.copyFile(src, trg2);
		System.out.println("================================");
		driver.quit();
	}

}
