package kreator.PageObjects;

import java.util.List;

import org.openqa.selenium.By;	
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import kreator.ReusableComponents.ReusableComponents;

public class Dashboard extends ReusableComponents {
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	/* Page Factory */
	
	@FindBy(xpath="//*[text()='Connect']")
	WebElement connectButton;
	
	@FindBy(id="username")
	WebElement SFUserName;
	
	@FindBy(id="password")
	WebElement SFPassword;
	
	@FindBy(id="sfLoginUrl")
	WebElement SFURL;
	
	@FindBy(id="securityToken")
	WebElement SFSecurityToken;
	
	@FindBy(xpath = "//button[text()='Log In']")
	WebElement SFLoginButton;
	
	@FindBy(xpath="//span[text()='Login to Salesforce Org: gc-kreator successful!']")
	WebElement toastMsg;
	
	@FindBy(xpath="//button[text()='Add a Page']")
	WebElement addAPage;
	
	@FindBy(xpath="//input[@placeholder='Search for any page']")
	WebElement pageNameForSearch;
	
	@FindBy(css=".search-results")
	WebElement searchResults;
	
	@FindBy(css=".page-details")
	WebElement displayedPageNameElement;
	
	@FindBy(css=".import-btn")
	WebElement importBtn;
	
	@FindBy(xpath="//*[text()='Salesforce Objects']")
	WebElement salesforceObjects;
	
	@FindBy(xpath="//*[text()='Lightning Components']")
	WebElement lightningComponents;
	
	@FindBy(css=".modal-title")
	WebElement modalTitle;
	
	@FindBy(xpath="(//select[@class='rdl-control'])[1]")
	WebElement availableContainerSFObj;
	
	@FindBy(xpath="(//select[@class='rdl-control'])[2]")
	WebElement selectedContainer;
	
	@FindBy(xpath="(//select[@class='rdl-control'])[3]")
	WebElement availableContainerLightningComp;
	
	@FindBy(xpath="(//span[text()='>'])[1]")
	WebElement moveRightSFObj;
	
	@FindBy(xpath="(//span[text()='>'])[2]")
	WebElement moveRightLightningComp;
	
	@FindBy(xpath="//button[text()='Import']")
	WebElement importBtnOnModal;
	
	@FindBy(css=".css-0")
	WebElement loadingDots;
	
	@FindBy(xpath="//*[contains(text(),'Artifacts imported successfully')]")
	WebElement notificationMsg;
	
	@FindBy(xpath="//span[text()='Page saved successfully!!']")
	WebElement pageSavedMsg;
	
	/*Add Page Elements*/
	@FindBy(xpath="//label[text()='Page/Screen Object']")
	WebElement modalHeader;
	
	@FindBy(xpath="//input[@name='screenName']")
	WebElement name;
	
	@FindBy(xpath="//*[@name='htmlDesc']")
	WebElement htmlAuthorComment;
	
	@FindBy(xpath="//*[@name='jsDesc']")
	WebElement jsAuthorComment;
	
	@FindBy(xpath="//*[@name='helperDesc']")
	WebElement helperjsAuthorComment;
	
	@FindBy(xpath="//a[text()='Screen Object']")
	WebElement screenObjectTab;
	
	@FindBy(xpath="//a[text()='Page Variables']")
	WebElement pageVariablesTab;
	
	@FindBy(xpath="//span[text()='Screen Object']")
	WebElement screenObjectLink;
	
	@FindBy(xpath="//span[text()='Page Variables']")
	WebElement pageVariablesLink;
	
	@FindBy(xpath="//input[@name='objectName']")
	WebElement sourceObjectName;
	
	@FindBy(xpath="//select[@name='relationshipType']")
	WebElement relationshipType;
	
	@FindBy(xpath="//select[@name='numRecords']")
	WebElement expectedNumberOfRecords;
	
	@FindBy(css=".add-edit-filter")
	WebElement addFilterBtn;
	
	@FindBy(xpath="//div[@class='filter-button row'] //*[@class='emoji ']")
	WebElement filterResultsByIcon;
	
	@FindBy(xpath="//input[@placeholder='Filter By*']")
	WebElement filterBy;
	
	@FindBy(xpath="//input[@placeholder='Operator*']")
	WebElement operator;
	
	@FindBy(xpath="//input[@placeholder='Value Type*']")
	WebElement valueType;
	
	@FindBy(xpath="//input[@placeholder='Page Variables*']")
	WebElement pageVariables;
	
	@FindBy(xpath="//button[text()='Save Query']")
	WebElement saveQueryBtn;
	
	@FindBy(xpath="//button[text()='Create Screen Object']")
	WebElement createScreenObjectBtn;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath="//input[@name='parentObjName']")
	WebElement parentObjectName;
	
	@FindBy(css=".select__value-container")
	WebElement selectContainer;
	
	@FindBy(xpath="//*[@name='variableName']")
	WebElement pageVariableName;
	
	@FindBy(xpath="//*[text()='Is Page variable part of UI element?']/following-sibling::div //*[text()='Yes']")
	WebElement pvPartofUIElementYes;
	
	@FindBy(xpath="//*[text()='Is Page variable part of UI element?']/following-sibling::div //*[text()='No']")
	WebElement pvPartofUIElementNo;
	
	@FindBy(xpath="//*[@name='variableType']")
	WebElement pageVariableType;
	
	@FindBy(xpath="//*[text()='Add Page Variable']")
	WebElement addPageVariableBtn;
	
	@FindBy(css=".icon-edit-page-properties")
	WebElement editPageProp;
	
	@FindBy(xpath="//*[text()='Screen Object']/parent::span/parent::div/parent::form[@id='application-form'] //*[@class='edit-icon']")
	List<WebElement> screenObjEditIcons;
	
	@FindBy(xpath="//*[text()='Page Variables']/parent::span/parent::div/parent::form[@id='application-form'] //*[@class='edit-icon']")
	List<WebElement> pageVarEditIcons;
	
	@FindBy(xpath="//*[text()='Edit Screen Object']")
	WebElement editScreenObjBtn;
	
	@FindBy(xpath="//*[text()='Edit Page Variable']")
	WebElement editPageVarBtn;
	
	@FindBy(xpath="//select[@name='variablePurpose']")
	WebElement variablePurpose;
	
	@FindBy(xpath="//select[@name='variableType']")
	WebElement variableType;
	
	@FindBy(xpath="//*[text()='View all Pages']")
	WebElement viewAllPagesLink;
	
	@FindBy(xpath="//span[@class='icon edit-icon ml-2']")
	List<WebElement> pageEditIcons;
	
	@FindBy(css=".canvas-remove")
	List<WebElement> pageDeleteIcons;
	
	@FindBy(xpath="//div[@class='rt-tr-group']")
	List<WebElement> pageNamesList;

	@FindBy(xpath="//*[text()='Page Name']")
	WebElement pageNameHeader;
	
	@FindBy(css=".kreator-logo")
	WebElement homeBtn;
	
	@FindBy(xpath="//*[text()='Yes']")
	WebElement deletePageConfirmationBtn;
	
	@FindBy(xpath="//div[@class='search-results'] //li")
	List<WebElement> searchResultsList;
	
	@FindBy(xpath="//*[text()='Add a standard layout-page']")
	WebElement addAStandardLayoutPageBtn;
	
	@FindBy(xpath="//*[text()='Add a Figma Page']")
	WebElement addAFigmaPageBtn;
	
	@FindBy(xpath="//*[text()='Layout Page']")
	WebElement layoutPageModalHeader;
	
	@FindBy(xpath="//datalist[@id='src-object-name']/option")
	List<WebElement> objectNameList;
	
	@FindBy(xpath="//input[@name='standardPagelayoutName']")
	WebElement standardPagelayoutName;
	
	@FindBy(xpath="//input[@name='pageName']")
	WebElement kreatorPageName;
	
	@FindBy(xpath="//select[@name='numberOfColumns']")
	WebElement numberOfColumns;
	
	@FindBy(xpath="//*[text()='Fetch']")
	WebElement fetchBtn;
	
	@FindBy(xpath="(//div[@class='   row slds-form-element__row slds-wrap column-overflow'])[6] //label[@class='slds-order_1']")
	List<WebElement> fetchedColumns;
	
	@FindBy(xpath="//input[@name='screenName']")
	WebElement kreatorTemplateName;
	
	@FindBy(xpath="//input[@name='figmaPageId']")
	WebElement figmaPageID;
	
	@FindBy(xpath="//input[@name='figmaAccessToken']")
	WebElement figmaAccessToken;
	
	@FindBy(xpath="//*[contains(text(),'Synced Figma successfully!!')]")
	WebElement figmaFetchedMsg;
	
	
	
	/* Action Methods */
	
	public void addAFigmaPage(String pageID, String accessToken)
	{
		String TemplateName = "Figma "+generateRandomAlphanumeric(10);
		addAFigmaPageBtn.click();
		kreatorTemplateName.sendKeys(TemplateName);
		figmaPageID.sendKeys(pageID);
		figmaAccessToken.sendKeys(accessToken);
		fetchBtn.click();
		
		waitForElementInvisisble(loadingDots, 10);
				
	}
	
	
	public void addAStandardLayoutPage()
	{
		addAStandardLayoutPageBtn.click();
		Assert.assertEquals(layoutPageModalHeader.getText(), "Layout Page", "Layout Page Modal is not Displayed");
		sourceObjectName.sendKeys("Application__c");
		standardPagelayoutName.sendKeys("Application Layout");
		kreatorPageName.sendKeys("Page Layout "+generateRandomAlphanumeric(10));
		int columncount = generateRandomInteger(selectElementSize(numberOfColumns)-1);
		selectElementByIndex(numberOfColumns, columncount);
		fetchBtn.click();
		
		waitForElementInvisisble(loadingDots, 10);
		waitForElementInvisisble(loadingDots, 10);
		
		System.out.println("Column Count given is "+columncount);
//		editPageProp.click();
//		addChildScreenObject("Application_child__c","Application__c");
//		saveBtn.click();
//		editPageConfig();
		
		System.out.println("Fetched Column Count is "+fetchedColumns.size());
		
		Assert.assertEquals(columncount, fetchedColumns.size(), "number of columns fetched and number of columns given are not same");
		
//		String[] fetchedColumnData = new String[50];
//		int rowIndex = 5;
//		int k = -1;
//		
//		for(int i=0; i<10;i++)
//		{
//			rowIndex++;
//			List<WebElement> fetchedRowValue = 
//					driver.findElements(By.xpath("(//div[@class='   row slds-form-element__row slds-wrap column-overflow'])['"+rowIndex+"'] //label[@class='slds-order_1']"));
//			
//			for(int j=0;j<columncount; j++)
//			{
//				k++;
//				fetchedColumnData[k] = fetchedRowValue.get(j).getText();
//				
//				System.out.println(rowIndex+"-"+k+"-"+fetchedColumnData[k]);
//				
//				if(fetchedColumnData[k].equalsIgnoreCase("Owner ID"))
//				{
//					break;
//				}
//			}	
//		}
		
		
//		Actions actions = new Actions(driver);
		
		
	}
	
	public String SFConnection(String userName, String password, String URL, String token)
	{
		connectButton.click();
		SFUserName.sendKeys(userName);
		SFPassword.sendKeys(password);
		SFURL.sendKeys(URL);
		SFSecurityToken.sendKeys(token);
		SFLoginButton.click();
//		waitForElementInvisisble(loadingDots,15);
		waitForElementVisisble(toastMsg,5);
		String connectionMessage = toastMsg.getText();
		
		return connectionMessage;
	
	}
	
	public String addPageConfig()
	{
		addAPage.click();
		waitForElementVisisble(modalHeader,5);
		
		addPageProperties();
				
		addParentScreenObject("Application__c");
		addChildScreenObject("Application_child__c","Application__c");
		
		addPageVariables();
				
		saveBtn.click();
	
		waitForElementVisisble(pageSavedMsg,15);
		String savedMessage = pageSavedMsg.getText();
		
		return savedMessage;
		
	}
	
	public String editPageConfig()
	{
		editPageProp.click();
		waitForElementVisisble(modalHeader,5);
		
		editPageProperties();
		
		editScreenObject("Account","Contact");
		
		editPageVariables();
		
		saveBtn.click();
		
		waitForElementVisisble(pageSavedMsg,15);
		String savedMessage = pageSavedMsg.getText();
		
		return savedMessage;
		
	}
	
	public void editPageProperties()
	{
//		String pageName = generateRandomAlphanumeric(10);
//		name.sendKeys(pageName+" edited");
		htmlAuthorComment.clear();
		htmlAuthorComment.sendKeys("HTML "+generateRandomAlphanumeric(15)+" edited");
		jsAuthorComment.clear();
		jsAuthorComment.sendKeys("JS "+generateRandomAlphanumeric(15)+" edited");
		helperjsAuthorComment.clear();
		helperjsAuthorComment.sendKeys("HelperJS "+generateRandomAlphanumeric(15)+" edited");
	}
	
	public void editScreenObject(String parentObjName, String childObjName)
	{
		screenObjectTab.click();
		screenObjEditIcons.get(0).click();
		sourceObjectName.clear();
		sourceObjectName.sendKeys(parentObjName);
		editScreenObjBtn.click();
		
		screenObjEditIcons.get(1).click();
		sourceObjectName.clear();
		sourceObjectName.sendKeys(childObjName);
		selectContainer.click();
		driver.findElement(By.xpath("//*[text()='"+parentObjName+"']")).click();
		editScreenObjBtn.click();
		
	}
	
	public void editPageVariables()
	{
		pageVariablesTab.click();
		
		for(int i=0; i<pageVarEditIcons.size();i++)
		{
			pageVarEditIcons.get(i).click();
			pvPartofUIElementNo.click();
			selectElementByIndex(variablePurpose,generateRandomInteger(selectElementSize(variablePurpose)-1));
			selectElementByIndex(variableType,generateRandomInteger(selectElementSize(variableType)-1));
			editPageVarBtn.click();
		}
		
	}
	
	
	public void addPageProperties()
	{
		String pageName = generateRandomAlphanumeric(10);
		name.sendKeys(pageName);
		htmlAuthorComment.sendKeys("HTML "+generateRandomAlphanumeric(10));
		jsAuthorComment.sendKeys("JS "+generateRandomAlphanumeric(10));
		helperjsAuthorComment.sendKeys("HelperJS "+generateRandomAlphanumeric(10));
	
	}
	
	public void addParentScreenObject(String objectName)
	{
		screenObjectTab.click();
		screenObjectLink.click();
		sourceObjectName.sendKeys(objectName);
		selectElement(relationshipType,"Primary");
		selectElement(expectedNumberOfRecords,"1");
		addFilterBtn.click();
		filterResultsByIcon.click();
		filterBy.sendKeys("Id");
		operator.sendKeys("=");
		valueType.sendKeys("Page Variables");
		pageVariables.sendKeys("recordId");
		saveQueryBtn.click();
		createScreenObjectBtn.click();
	}
	
	public void addChildScreenObject(String childObjectName, String parentObjName)
	{
		screenObjectTab.click();
		screenObjectLink.click();
		sourceObjectName.sendKeys(childObjectName);
		selectElement(relationshipType,"Child");
		selectElement(expectedNumberOfRecords,"0 - many");
		addFilterBtn.click();
		filterResultsByIcon.click();
		filterBy.sendKeys("Id");
		operator.sendKeys("=");
		valueType.sendKeys("Page Variables");
		pageVariables.sendKeys("recordId");
		saveQueryBtn.click();
		selectContainer.click();
		driver.findElement(By.xpath("//*[text()='"+parentObjName+"']")).click();
		createScreenObjectBtn.click();
	}
	
	
	public void addPageVariables()
	{
		pageVariablesTab.click();
		pageVariablesLink.click();
		
		int size = 1;
		pageVariableName.sendKeys(generateRandomAlphanumeric(10));
		pvPartofUIElementYes.click();
		selectElementByIndex(pageVariableType,1);
		size = selectElementSize(pageVariableType);
		System.out.println(size);
		addPageVariableBtn.click();

		for(int i=2;i<size;i++)
		{
			pageVariablesLink.click();			
			pageVariableName.sendKeys(generateRandomAlphanumeric(10));
			pvPartofUIElementYes.click();
			selectElementByIndex(pageVariableType,i);
			size = selectElementSize(pageVariableType);
			addPageVariableBtn.click();
		}
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
	
	public String importSalesforceObjects()
	{
		importBtn.click();
		String modalName = modalTitle.getText();
		Assert.assertEquals(modalName, "Import Org Artifacts", "Modal Name Incorrect");
		salesforceObjects.click();
		
		for(int i=0;i<10;i++)
		{
			selectElementByIndex(availableContainerSFObj,generateRandomInteger(selectElementSize(availableContainerSFObj)));
			moveRightSFObj.click();
		}
		
		importBtnOnModal.click();
		
		waitForElementVisisble(notificationMsg,15);
		String salesforceObjimportMessage = notificationMsg.getText();
		
		return salesforceObjimportMessage;
		
	}
	
	public String importlightningComponents()
	{
		importBtn.click();
		String modalName = modalTitle.getText();
		Assert.assertEquals(modalName, "Import Org Artifacts", "Modal Name Incorrect");
		lightningComponents.click();
		
		for(int i=0;i<10;i++)
		{
			selectElementByIndex(availableContainerLightningComp,generateRandomInteger(selectElementSize(availableContainerLightningComp)));
			moveRightLightningComp.click();
		}
		
		importBtnOnModal.click();
		
		waitForElementVisisble(notificationMsg,15);
		String lightningCompimportMessage = notificationMsg.getText();
		
		return lightningCompimportMessage;
		
	}
	
	public void editPagefromPageList()
	{
		homeBtn.click();
		waitForElementInvisisble(loadingDots, 20);
		viewAllPagesLink.click();
//		System.out.println(pageNamesList.size());
//		pageNameHeader.click();
		
		int index = generateRandomInteger(pageNamesList.size())-1;
		
		Actions actions = new Actions(driver);
		String pageName = pageNamesList.get(index).getText();
		
		actions.moveToElement(pageEditIcons.get(index)).click().build().perform();
		waitForElementInvisisble(loadingDots, 20);
		String displayedPageName = displayedPageNameElement.getText();
//		System.out.println(pageName+"-"+displayedPageName);
		Assert.assertTrue(displayedPageName.contains(pageName), "Page Search is not successful");
		
	}
	
	public boolean deletePageFromList()
	{
		homeBtn.click();
		waitForElementInvisisble(loadingDots, 20);
		viewAllPagesLink.click();
		
		int index = generateRandomInteger(pageNamesList.size())-1;
		
		Actions actions = new Actions(driver);
		String pageName = pageNamesList.get(index).getText();
		
		actions.moveToElement(pageDeleteIcons.get(index)).click().build().perform();
		deletePageConfirmationBtn.click();
		
		pageNameForSearch.sendKeys(pageName);
		actions.moveToElement(searchResults);
		
		boolean pageExists = false;
		
		if(searchResultsList.size()==0)
		{
			pageExists = true;
		}
		
		else
		{
			for(int i=0;i<searchResultsList.size();i++)
			{
				String item = searchResultsList.get(i).getText();
				if(item.equalsIgnoreCase(pageName))
				{
					pageExists = true;
					break;
				}
				
			}
		}
		
		return pageExists;
		
	}
	
}
