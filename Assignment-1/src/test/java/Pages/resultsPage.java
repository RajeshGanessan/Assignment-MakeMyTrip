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
	private ArrayList<Integer> priceList = new ArrayList<Integer>();
	private String pageTitle;
	private String value;

	public resultsPage(WebDriver driver) {
		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//h1[contains(text(),'Property for sale in London')]")
	WebElement title;

	@FindBy(how = How.XPATH, using = "//div[@class='ui-agent__text']/h4")
	WebElement propName;
	
	@FindBy(how = How.XPATH, using = "//li[contains(@id,'listing_')]//a[contains(@class,'text-price')]")
	List<WebElement> listPriceProperties;

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

	

	// selecting region
	public void getAllPropertiesPrices() {
		
		for(WebElement PropertyPrices : listPriceProperties) {
			
			if(PropertyPrices.getText().replaceAll("[^0-9]", "").isEmpty()){
				System.out.println(PropertyPrices.getText());
				System.out.println("The One Property has a price="+PropertyPrices.getText()+" which is not the actual value, So this property was not added in Pricelist");

			}
			else {
				priceList.add(Integer.parseInt(PropertyPrices.getText().replaceAll("[^0-9]","")));
			}
			
		}
		System.out.println("List of Properties in Reverse Order");
		Collections.sort(priceList, Collections.reverseOrder());
		System.out.println(priceList);

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
