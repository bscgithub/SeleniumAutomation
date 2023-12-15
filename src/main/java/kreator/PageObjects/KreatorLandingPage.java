package kreator.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import kreator.ReusableComponents.ReusableComponents;


public class KreatorLandingPage extends ReusableComponents{
	
	WebDriver driver;
	
	public KreatorLandingPage(WebDriver driver) 
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	//Page Factory
	
	@FindBy(id="username")
	WebElement kreatorUserName;
	
	@FindBy(id="password")
	WebElement kreatorPassword;
	
	@FindBy(xpath = "//button[text()='Log In']")
	WebElement kreatorLoginButton;
	
	@FindBy(css=".css-0")
	WebElement loadingDots;
	
	@FindBy(css=".nav-link")
	WebElement pagesLink;
	
	@FindBy(css=".greet")
	WebElement greet;
	
	
	
	
	// Action Methods
	
	public String kreatorToolLogin(String userName, String password) 	
	{
		kreatorUserName.sendKeys(userName);
		kreatorPassword.sendKeys(password);
		kreatorLoginButton.click();
		waitForElementInvisisble(loadingDots,5);
		String greetMsg = greet.getText();
		return greetMsg;
	}
	
	public void kreatorURL(String URL) 	
	{
		driver.get(URL);
	}
	
	

}
