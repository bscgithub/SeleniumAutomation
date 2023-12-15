package kreator.TestComponents;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import kreator.PageObjects.Dashboard;

public class DashboardRelated extends BaseTest{
	
	@Test
	public void LoginAndConnection() throws IOException
	{

		Dashboard dashboard = launchKreator();
		
		String salesforceObjimportMessage = dashboard.importSalesforceObjects();
		Assert.assertEquals(salesforceObjimportMessage, "Artifacts imported successfully from Salesforce Org: gc-kreator!", "Import Not Successful");
		
		String lightningCompimportMessage = dashboard.importlightningComponents();
		Assert.assertEquals(lightningCompimportMessage, "Artifacts imported successfully from Salesforce Org: gc-kreator!", "Import Not Successful");
		
		driver.close();
		
	}
	
	
	@Test
	public void AddAPage() throws IOException
	{
		Dashboard dashboard = launchKreator();
		
		String addPageSavedMsg = dashboard.addPageConfig();
		Assert.assertEquals(addPageSavedMsg, "Page saved successfully!!", "Page is not saved successfully");
		
		String editPageSavedMsg = dashboard.editPageConfig();
		Assert.assertEquals(editPageSavedMsg, "Page saved successfully!!", "Page is not saved successfully");
		
		driver.close();
		
	}
	
	@Test
	public void ViewAndSearchPages() throws IOException
	{
		String pageName = getPageNameForViewAndSearchPage();
		Dashboard dashboard = launchKreator();
		
		String displayedPageName = dashboard.searchPage(pageName);
		Assert.assertTrue(displayedPageName.contains(pageName), "Page Search is not successful");
		
		dashboard.editPagefromPageList();
		
		boolean deletedPageExists = dashboard.deletePageFromList();
		Assert.assertTrue(deletedPageExists, "Page is not Deleted Successfully");
		
		driver.close();
		
	}
	
	
	@Test
	public void PageLayout() throws IOException
	{
		Dashboard dashboard = launchKreator();
		dashboard.addAStandardLayoutPage();
	}
	
	
	@Test
	public void Figma() throws IOException
	{
		String figmaPageID = getFigmaPageID();
		String figmaAccessToken = getFigmaAccessToken();
		
		Dashboard dashboard = launchKreator();
		dashboard.addAFigmaPage(figmaPageID, figmaAccessToken);
		
	}
	
	
	@Test
	public void test() throws IOException
	{
		Dashboard dashboard = launchKreator();
		dashboard.addAStandardLayoutPage();
		
	}
	
	
	
	
	
	
//	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}
	

}
