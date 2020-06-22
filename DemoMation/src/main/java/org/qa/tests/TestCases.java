package org.qa.tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.qa.util.UtilClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class TestCases extends UtilClass {

	@Test(enabled=false)
	public void BookAFlight() throws InterruptedException
	{
		driver.get("https://phptravels.net/home");
		String CurrTest = new Throwable() .getStackTrace()[0]  .getMethodName(); 
		testReport = extent.createTest("verify TC "+CurrTest);
		driver.manage().window().maximize();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".flights"))).click();
		testReport.log(Status.PASS,"Selected on flights");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flights")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".custom-control:nth-child(2) > .custom-control-label"))).click();
		testReport.log(Status.PASS,"Round trip selected");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".chosen-container-single-nosearch span"))).click();
		testReport.log(Status.PASS,"Class of travell selected to bussiness class");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".active-result:nth-child(2)"))).click();
		testReport.log(Status.PASS,"Selected on flights");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_location_from"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location_from"))).sendKeys("CCD");
		testReport.log(Status.PASS,"Source location selected");
		Thread.sleep(1500);
		{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s2id_location_to"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("location_to"))).sendKeys("JFK");
		Thread.sleep(1500);
		{
			Actions action = new Actions(driver);
			action.sendKeys(Keys.ENTER).build().perform();
		}
		testReport.log(Status.PASS,"Destination location selected");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlightsDateStart"))).click();
		Thread.sleep(1500);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[8]/div/div/div[2]/div[26]"))).click();
		testReport.log(Status.PASS,"From date selected");
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlightsDateEnd"))).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[9]/div/div/div[2]/div[31]"))).click();
		testReport.log(Status.PASS,"To date selected");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-4:nth-child(1) .btn:nth-child(1)"))).click();
		testReport.log(Status.PASS,"One Adult added");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-4:nth-child(2) .btn:nth-child(1)"))).click();
		testReport.log(Status.PASS,"One child added");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-4:nth-child(3) .btn:nth-child(1)"))).click();
		testReport.log(Status.PASS,"One infant added");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-md-12 > .btn-primary"))).click();
		testReport.log(Status.PASS,"Searched for the flights");
		testReport.log(Status.PASS,wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".post-heading"))).getText());

		testReport.log(Status.PASS,"verify TC "+CurrTest);
	}
}  

