package PageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import BaseClass.baseClass;
import Utilities.excelData;

public class loginPage {

	WebDriver driver;
	
	public loginPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//div[@class='relative flex items-center justify-center cursor-pointer']")WebElement login;
	@FindBy(xpath="//div[@class='nsm7Bb-HzV7m-LgbsSe-Bz112c']") WebElement signin;
	@FindBy(xpath="//input[@type='email']")WebElement email;
	@FindBy(xpath="(//button[@type='button'])[3]") WebElement next;
	@FindBy(xpath="//div[@class='Ekjuhf Jj6Lae']") WebElement errorMsg;
	
//	public void pageLogin() {
//		login.click();
//	}
	
	public void pageSignin() {
		signin.click();
	}
	
	public void switchFrame() {
		Set<String> window = driver.getWindowHandles();
		List<String> HandleList = new ArrayList<String>(window);
		driver.switchTo().window(HandleList.get(1));
	}
	
	public void clickEmail() {
		email.sendKeys(baseClass.randomAlphaNumeric()+"@gmail.com");
	}
	
	public void clickNext() {
		next.click();
			
	}
	
	public void displayErrorMsg() throws IOException {
		String error = errorMsg.getText();
		System.out.println(error);
		
		excelData.setCellData(error,"GoogleLogin", 1, 0);;
	}
	
}
