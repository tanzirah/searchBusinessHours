package steps;

import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.*;
import pages.DetailsPage;

public class DetailsPageSteps{

	
	public DetailsPage detailsPg = new DetailsPage(Hooks.getDriver());
	Actions actions = new Actions(Hooks.getDriver());
	  
	  @Then("^user should be redirected to workshop details page$")
	  public void user_should_be_redirected_to_workshop_details_page() throws Throwable {
	  	 detailsPg.verifyCorrectDetailsPage();
	  }
	
    @When("^user clicks on business hours$")
    public void user_clicks_on_business_hours() throws Throwable {
    	actions.moveToElement(detailsPg.getDetailsPageWorkshopHours());
    	detailsPg.getDetailsPageWorkshopHours().click();
    	Thread.sleep(2000);
    }
    
    @Then("^user should see all business hours for that studio$")
    public void user_should_see_all_business_hours_for_that_studio() throws Throwable {
    	detailsPg.printBusinessHours();
    }

}
