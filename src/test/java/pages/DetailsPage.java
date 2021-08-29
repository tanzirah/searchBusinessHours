package pages;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import locators.detailsPageLoc;

public class DetailsPage implements detailsPageLoc{
	
	public DetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Runtime variables
	private String weekdayHours;
	
	//Start getters/setters
	@FindBy(xpath = DETAILS_PAGE_WORKSHOP_NAME)
	WebElement detailsPageWorkshopName; 
	
	public WebElement getDetailPageWorkshopName() {
		return detailsPageWorkshopName;
	}
	
	@FindBy(xpath = DETAILS_PAGE_WORKSHOP_HOURS_DROPDWON)
	WebElement detailsPageWorkshopHours;
	
	public WebElement getDetailsPageWorkshopHours() {
		return detailsPageWorkshopHours;
	}
	
	@FindBy(xpath = WORKSHOP_DAYS)
	List<WebElement> workshopDays;
	
	public List<WebElement> getWorkshopDays() {
		return workshopDays;
	}
	
	@FindBy(xpath = WORKSHOP_HOURS)
	List<WebElement> workshopHours;
	
	public List<WebElement> getWorkshopHours() {
		return workshopHours;
	}
	//End getters and setters

	
	public void verifyCorrectDetailsPage() throws Throwable{
		Assert.assertEquals(SearchPage.firstResultsTitle, getDetailPageWorkshopName().getText());
	}
	
	public void printBusinessHours() {
		System.out.println("\n-------------------------------------------- \n\nBUSINESS HOURS: \n");
//		System.out.println("double lined time: "+ getWorkshopHours().get(1).getText().replace("\n", ", "));
		for (int i = 0; i<getWorkshopDays().size(); i++) {
			
			System.out.println(getWorkshopDays().get(i).getText() + " " + getWorkshopHours().get(i).getText().replace("\n", ", ")+ "\n");
		}
		System.out.println("--------------------------------------------\n");
	}
	
}
