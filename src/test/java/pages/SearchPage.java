package pages;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.PageFactory;

import steps.Hooks;
import locators.searchPageLoc;

public class SearchPage implements searchPageLoc{
	
	public SearchPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//Start getters and setters
	
	@FindBy(xpath = STUDIO_WORKSHOP_TAB)
	private WebElement studioWorkshopTab; 
	
	public WebElement getStudioWorkshopTab() {
		return studioWorkshopTab; 
	}
	
	@FindBy(xpath = STUDIO_ZIP_FIELD)
	private WebElement studioZipcodeField;
	
	public WebElement getStudioZipcodeField() {
		return studioZipcodeField;
	}
	
	@FindBy(xpath=STUDIO_SEARCH_ARROW)
	private WebElement studioSearchArrow;
	
	public WebElement getStudioSearchArrow() {
		return studioSearchArrow;
	}
	
	@FindBy(xpath = SEARCH_RESULT_DISTANCE)
	private List<WebElement> searchResultDistance;
	
	public List<WebElement> getSearchResultDisatnce(){
		return searchResultDistance;
	}
	
	@FindBy(xpath = SEARCH_RESULT_TITLE)
	private List<WebElement> searchResultTitle;
	
	public List<WebElement> getSearchResultTitle(){
		return searchResultTitle;
	}
	//End getters and setters
	
	//Start runtime variables
	public static String firstResultsTitle;
	//End runtime variables
	
	public void openVerifySearchPg() throws Throwable{
		Hooks.getDriver().navigate().to("https://www.weightwatchers.com/us/find-a-workshop/");
		Assert.assertEquals(Hooks.getDriver().getTitle().replaceAll("[^a-zA-Z0-9]", " "), 
				"Find WW Studios & Meetings Near You | WW USA".replaceAll("[^a-zA-Z0-9]", " "));
	}
	
	public void printResultTitleDistance() throws Throwable {
		firstResultsTitle = getSearchResultTitle().get(0).getText();
		System.out.println("\n First result title: "+ this.getSearchResultTitle().get(0).getText()+
				"\n\n First result distance: "+ this.getSearchResultDisatnce().get(0).getText()+"\n");
	}

}
