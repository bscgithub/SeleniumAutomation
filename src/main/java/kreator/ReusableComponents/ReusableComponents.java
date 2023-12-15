package kreator.ReusableComponents;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableComponents {

	WebDriver driver;
	
	public ReusableComponents(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	/* Page Factory */
	
	@FindBy(xpath="//input[@placeholder='Search for any page']")
	WebElement pageNameForSearch;
	
	@FindBy(css=".search-results")
	WebElement searchResults;
	
	@FindBy(css=".page-details")
	WebElement displayedPageNameElement;

	public void waitForElementVisisble(WebElement element, int sec) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementInvisisble(WebElement element, int sec) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public String searchPage(String pageName)
	{
		pageNameForSearch.sendKeys(pageName);
		
		Actions Actions = new Actions(driver);
		Actions.moveToElement(searchResults);
		WebElement pageNameElement = driver.findElement(By.xpath("//li[text()='"+pageName+"']"));
		Actions.scrollToElement(pageNameElement).moveToElement(pageNameElement).click().build().perform();
		
		String displayedPageName = displayedPageNameElement.getText();
		return displayedPageName;
	}
	
	public void selectElement(WebElement webElement, String string)
	{
		Select select = new Select(webElement);
		select.selectByVisibleText(string);
		
	}
	
	public int selectElementSize(WebElement webElement)
	{
		Select select = new Select(webElement);
		List<WebElement> options = select.getOptions();
		return options.size();
		
	}
	
	public void selectElementByIndex(WebElement webElement, int index)
	{
		Select select = new Select(webElement);
		select.selectByIndex(index);
	}
	
	public int generateRandomInteger(int num)
	{
		Random random = new Random();
		int randomInt = random.nextInt(num)+1;
		return randomInt;
		
	}
	
	public String generateRandomAlphanumeric(int stringLength)
	{
		
		 String randomAlphanumeric = RandomStringUtils.randomAlphanumeric(stringLength);
		 return randomAlphanumeric;
	
	}
		

	
}
