package TestCases;

import org.testng.annotations.Test;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.HomePage;
import Utils.testBase;

public class homePagetest extends testBase {

//	@BeforeTest
//	public void init() {
//		
//		//Initialising browser		
//		Initialisation();
//	}
//	
	@Test
	public void homePage() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 10);

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.EnterSearch("lond");

		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@class='ui-menu-item']/a")));
		
		homePage.selectRegion("Londonderry");

		homePage.clickSearchBtn();

	}

}
