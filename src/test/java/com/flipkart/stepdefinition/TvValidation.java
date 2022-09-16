package com.flipkart.stepdefinition;

import java.io.File;
import java.io.IOException;
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

public class TvValidation {
	
	static WebDriver driver;
	@Given("user launches the flipkart")
	public void user_launches_the_flipkart() {
		System.out.println("Tv Section");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\durai\\eclipse-workspace\\ExcelReadWrite\\dri\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}

	@Given("user enter to login page")
	public void user_enter_to_login_page() {
		System.out.println("Flipkart Login");
		WebElement close = driver.findElement(By.xpath("//button[text()='✕']"));
		close.click();
		System.out.println("================================");
	}
	
	String name = "";
	@When("user search Tv by using {string}")
	public void user_search_Tv_by_using(String product) {
		System.out.println("Tv Search using Product");
		name = product;
		WebElement src = driver.findElement(By.xpath("//input[@class='_3704LK']"));
		src.sendKeys(name +" Tv");
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		WebElement ent = driver.findElement(By.xpath("//button[@type='submit']"));
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		ent.click();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		WebElement ent1 = driver.findElement(By.xpath("(//div[contains(text(),'"+name+"')])[2]"));
		ent1.click();
		System.out.println("=====================");
	}

	@When("user click Tv and move to next page and windows handling")
	public void user_click_Tv_and_move_to_next_page_and_windows_handling() {
		System.out.println("Windows Handling");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement nxtSrc = driver.findElement(By.xpath("//span[contains(text(),'"+name+"')]"));
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

	@When("user moves to specification using scrolldown")
	public void user_moves_to_specification_using_scrolldown() {
		System.out.println("Scroll Down");
	 	JavascriptExecutor js =(JavascriptExecutor)driver;
	 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	WebElement spec = driver.findElement(By.xpath("//div[text()='Specifications']"));
	 	js.executeScript("arguments[0].scrollIntoView(true)", spec);
	 	driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	 	System.out.println("================================");
	}

	@Then("user get the screenshot")
	public void user_get_the_screenshot() throws IOException {
		System.out.println("Screen shot");
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File trg3= new File("C:\\Users\\durai\\eclipse-workspace\\CucumberFlipkartProgram\\target\\ScreenshotSamsungTv.png");
		File trg4= new File("C:\\Users\\durai\\eclipse-workspace\\CucumberFlipkartProgram\\target\\ScreenshotSonyTv.png");
		File trg5= new File("C:\\Users\\durai\\eclipse-workspace\\CucumberFlipkartProgram\\target\\ScreenshotOneplusTv.png");
		FileUtils.copyFile(src, trg3);
		FileUtils.copyFile(src, trg4);
		FileUtils.copyFile(src, trg5);
		System.out.println("================================");
		driver.quit();
	}

	
}
