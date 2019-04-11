package Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class resultsPage {

	WebDriver driver;

	private List<WebElement> properties;
	private List<String> activeProps;
	private int propInt;
	private ArrayList<Integer> intNum = new ArrayList<Integer>();
	private String pageTitle;
	private String value;

	public resultsPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Property for sale in London')]")
	WebElement title;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-agent__text']/h4")
	WebElement propName;

	// To get page title
	public String getTitle() {

		pageTitle = driver.getTitle();

		return pageTitle;
	}

	// verifying page title
	public void verifyPageTitle() {

		String ExpectedTitle = "Property for Sale in Londonderry - Buy Properties in Londonderry - Zoopla";

		Assert.assertEquals(getTitle(), ExpectedTitle);
		System.out.println("Title successfully verified");
	}

	// to get the list of property details
	public List<WebElement> allProperties() {

		properties = driver
				.findElements(By.xpath("//ul[@class='listing-results clearfix js-gtm-list']/li/div/div[2]/a"));

		return properties;
	}

	// selecting region
	public void getProperties() throws InterruptedException {

		List<WebElement> suggesions = allProperties();

		activeProps = new ArrayList<String>();
		// Select required item
		for (WebElement props : suggesions) {

			value = props.getText();

			activeProps.add(value);
		}

		// System.out.println(activeProps);

	}

	// sorting the property values
	public void sortProperty() {

		String newSub = null;

		String subText;

		for (String newValue : activeProps) {

			int length = newValue.length();
			// System.out.println(length);
			if (length < 3) {
				try {
					System.out.println("no values");
				} catch (StringIndexOutOfBoundsException e) {
					e.getMessage();
				}
			} else if (length > 3) {

				subText = newValue.substring(1, 7);
				if (subText.contains(",")) {
					newSub = subText.replaceAll(",", "");
					try {
						propInt = Integer.parseInt(newSub);
					} catch (NumberFormatException e) {
						e.toString();
					}
				}

				else {
					continue;
				}

			}

		}
		System.out.println(intNum);
	}

	// verifying title
	public void checkTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 10);

		wait.until(ExpectedConditions.visibilityOf(title));

		if (title.isDisplayed()) {
			System.out.println("title displayed");
		}
	}

	// selecting PropertyName
	public void selectPropName() {

		if (propName.isDisplayed()) {
			propName.click();
		}
	}

	// Selecting property based on index
	public void selectProperty(int index) {

		properties.get(index).click();

	}
}
