package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.resultsPage;
import Utils.testBase;

public class resultsPageTest extends testBase{

	
	@Test
	public void resultPage() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);

		resultsPage resultPage = PageFactory.initElements(driver, resultsPage.class);
		
		resultPage.verifyPageTitle();
		
		resultPage.getAllPropertiesPrices();
		
		
		
		
	}
}
