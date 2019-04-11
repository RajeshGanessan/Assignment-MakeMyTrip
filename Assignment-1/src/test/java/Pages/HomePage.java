package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class HomePage {

	WebDriver driver;

	private List<WebElement> options;
	private List<WebElement> properties;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Locating elements
	@FindBy(how = How.XPATH, using = "//input[@id='search-input-location']")
	WebElement searchBox;

	@FindBy(how = How.XPATH, using = "//button[@id='search-submit']")
	WebElement searchBtn;

	// to get the list of region count
	public List<WebElement> getOptions() {

		// options = driver.findElements(By.cssSelector("li.ui-menu-item > a"));

		options = driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
		return options;
	}

	// Methods for performing action
	public void EnterSearch(String searchTerm) {
		searchBox.sendKeys(searchTerm);
	}

	// selecting region
	public void selectRegion(String regionName) throws InterruptedException {

		List<WebElement> suggesions = getOptions();

		// Select required item
		for (WebElement sug : suggesions) {
			if (sug.getText().equals(regionName)) {
				sug.click();
			}
		}
	}

	// clicking search button
	public void clickSearchBtn() {
		searchBtn.click();
	}

}
