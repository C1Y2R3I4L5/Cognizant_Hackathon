package StepDefinition;

import java.io.IOException;

import BaseClass.baseClass;
import PageObject.homePage;
import PageObject.loginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class invalidLoginTesting {
	
	loginPage lp;
	homePage hp;

	@Given("Click the userLogin button")
	public void click_the_user_login_button() throws Exception {
	    hp = new homePage(baseClass.getDriver());
	    Thread.sleep(7000);
	    hp.pageLogin();
	}

	@When("Click the signIn button")
	public void click_on_sign_in_button() {
	  lp=new loginPage(baseClass.getDriver());
	  lp.pageSignin();
	}

	@When("Enter the email credentials")
	public void enter_the_email_credentials() {
	    lp.switchFrame();
	    lp.clickEmail();
	    lp.clickNext();
	}

	@Then("Print the error message")
	public void print_the_error_message() throws IOException {
	    lp.displayErrorMsg();
	}

}
