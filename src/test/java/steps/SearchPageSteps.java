package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;

import pages.SearchPage;

public class SearchPageSteps {

	
	public SearchPage searchPg = new SearchPage(Hooks.getDriver());
	
    @Given("^user is on the workshop search page$")
    public void user_is_on_the_workshop_search_page() throws Throwable {
    	searchPg.openVerifySearchPg();
    }
    
    @And("^user clicks on studio tab$")
    public void user_clicks_on_studio_tab() throws Throwable {
    	searchPg.getStudioWorkshopTab().click();
    	Thread.sleep(1000);
    }
    
    @When("^enters (.+) in the search field$")
    public void enters_in_the_search_field(String zipcode) throws Throwable {
    	searchPg.getStudioZipcodeField().sendKeys(zipcode);
       	Thread.sleep(2000);
    }
    
    @And("^clicks on go arrow$")
    public void clicks_on_go_arrow() throws Throwable {
    	searchPg.getStudioSearchArrow().click();
    	Thread.sleep(2000);
    }
    
    @Then("^page should load results for that (.+)$")
    public void page_should_load_results_for_that(String zipcode) throws Throwable {
    	//Removing special characters that may mess with any comparisons
    	Assert.assertTrue("Search results did not update as expected", Hooks.getDriver().getCurrentUrl().replaceAll("[^a-zA-Z0-9]", " ").contains(zipcode));
    	//Here the first result title and it's distance are accessed and printed
    	searchPg.printResultTitleDistance();
    }
        
    @When("^user clicks on first search result$")
    public void user_clicks_on_first_search_result() throws Throwable {
    	searchPg.getSearchResultTitle().get(0).click();
    	Thread.sleep(2000);
    }


}
