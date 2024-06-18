package PageObject;

import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.excelData;

public class upcomingBikes {
	
	WebDriver driver;
	WebDriverWait myWait;
	
	public upcomingBikes(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver,this);
		myWait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	@FindBy(xpath="//div[@class='relative']/select[@class='w-full rounded-md border p-2 defaultInput bg-white text-black outline-none  lg:min-w-full min-h-[48px] border-gray-300 px-4']")WebElement clickHonda; 
	@FindBy(xpath="//span[@id='loadmoreBtn']")WebElement loadMore;
	@FindBy(xpath="//div[@class='bg-gray-50 p-2 rounded-md']//div[@class='font-semibold text-sm']") List<WebElement> price;
	@FindBy(xpath="//div[@class='p-4 pt-2 max-w-full']//a")List<WebElement> bikeNames;
	@FindBy(xpath="//div[@class='bg-gray-50 p-2 rounded-md block']")List<WebElement> launchDate ;
	
	public void dropdownBtn() throws Exception{
		myWait.until(ExpectedConditions.visibilityOf(clickHonda));
		Select dropdown = new Select(clickHonda);
		dropdown.selectByVisibleText("Honda");
		Thread.sleep(4000);
	}
	
	public void clickLoadMore() throws Exception {
		myWait.until(ExpectedConditions.visibilityOf(loadMore));
		if(loadMore.isDisplayed()) {
			Thread.sleep(6000);
			loadMore.click();
		}
	}
	
	public void compareBikePrice() throws IOException {
		String[] bikeprice = new String[price.size()];
		
		
		for(int i=0;i<price.size();i++) {
			
			String finalPrice = price.get(i).getText();
			
			if(finalPrice.contains("-")) {
				String[] temp = new String[2];
				temp = finalPrice.split(" - ");
				String l = temp[1].replaceAll("[^0-9.]","");
//     			String s = l.replace("*","");
				bikeprice[i] = l;
				
				
			}
			
			else {
				String l = finalPrice.replaceAll("[^0-9.]","");
				//String s = l.replace("*","");
				bikeprice[i] = l;
				
			}
		}
		
		double[] doubleArray = new double[bikeprice.length];
		
		for(int i=0;i<bikeprice.length;i++) {
			doubleArray[i] = Double.parseDouble(bikeprice[i]);
		}
		
		int j=1;
		for(int i=0;i<bikeprice.length;i++) {
			if(doubleArray[i] < 4) {
				
				System.out.println("Bike Name : " + bikeNames.get(i).getText());
				System.out.println("Bike price : " + price.get(i).getText());
				System.out.println("Launch date : " + launchDate.get(i).getText());
				System.out.println(" ----------------------------------- ");
				
				excelData.setCellData(bikeNames.get(i).getText(),"Honda Bikes", j , 0);
				excelData.setCellData(price.get(i).getText(),"Honda Bikes", j , 1);
				excelData.setCellData(launchDate.get(i).getText(),"Honda Bikes", j , 2);
				
				j++;
			}
		}
		
		System.out.println();
	}
}
