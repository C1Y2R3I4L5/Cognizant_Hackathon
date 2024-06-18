package PageObject;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.excelData;

public class usedCars {

WebDriver driver;
Actions act;
	
	public usedCars(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
		act=new Actions(driver);
		
	}
	
	@FindBy(xpath="//li[@id='menuusedcars3']") WebElement usedCars;
	@FindBy(xpath="//li[@id='submenu_4usedcars']") WebElement chnCars;
	@FindBy(xpath="//span[@class='underline cursor-pointer']") WebElement readMore;
	@FindBy(xpath="//td") List<WebElement> table;
	
	public void clickUsedCars()  {
		act.moveToElement(usedCars).perform();
	}
	
	public void clickChnCars() {
		chnCars.click();
	}
	
	public void readMore() {
		readMore.click();
	}
	
	public void printTable() throws IOException {
		for(int i=0;i<table.size();i++) {
			
			//String values = table.get(i).getText();
			
			System.out.println(table.get(i).getText());
			
			excelData.setCellData(table.get(i).getText(),"UsedCars", i+1 , 0);
			
		}
		
		System.out.println();
	}
}
