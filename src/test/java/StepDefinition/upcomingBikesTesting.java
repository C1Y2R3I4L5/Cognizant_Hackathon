package StepDefinition;

import java.io.IOException;

import BaseClass.baseClass;
import PageObject.homePage;
import PageObject.upcomingBikes;
import Utilities.excelData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class upcomingBikesTesting {
	
	homePage h;
	upcomingBikes ub;
	
//	@Given("click on Maybe Later")
//	public void click_on_maybe_later() {
//	    
//	    h.maybeLater();
//	}

	@Given("Hover on Bikes DropDown")
	public void hover_on_bikes_drop_down() throws IOException {
		h=new homePage(baseClass.getDriver());
	    h.clickBikes();
	    excelData.createExcelFile();
	}

	@When("Click on Upcoming Bikes")
	public void click_on_upcoming_bikes() {
	    h.clickUpcomingBike();
	}

	@When("Select Honda Bikes from select brand DropDown and click LoadMore")
	public void select_honda_bikes_from_select_brand_drop_down_and_click_load_more() throws Exception {
	    ub=new upcomingBikes(baseClass.getDriver());
	    
	    ub.dropdownBtn();
	    ub.clickLoadMore();
	}

	@Then("Print the Honda Bikes price under fourLakhs")
	public void print_the_honda_bikes_price_under_four_lakhs() throws IOException {
	    ub.compareBikePrice();
	}



}
