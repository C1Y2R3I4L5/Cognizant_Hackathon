package StepDefinition;

import java.io.IOException;

import BaseClass.baseClass;
import PageObject.usedCars;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class usedCarsTesting {
	
	usedCars uc;

	@Given("Hover on usedCars DropDown")
	public void hover_on_used_cars_drop_down() throws IOException {
	    uc= new usedCars(baseClass.getDriver());
	    uc.clickUsedCars();
	}

	@When("Click usedCars in CHENNAI")
	public void click_used_cars_in_chennai() {
		uc.clickChnCars();
	    
	}

	@When("Click Read More button")
	public void click_read_more_button() {
	    uc.readMore();
	}

	@Then("Print the information of Popular used cars")
	public void print_the_information_of_popular_used_cars() throws IOException {
	    uc.printTable();
	}

}
