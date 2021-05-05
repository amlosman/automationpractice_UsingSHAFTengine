package homeButtonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HotelsPage {
	
	//var
	private	WebDriver driver ; 
	//elements
	
	private By  hotelSearchElement = By.xpath("(//h2[@class='float-none'])[3]");
	
	///	Actions
	public HotelsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public String navigateToHotelPage() {
		
		
		return driver.findElement(hotelSearchElement).getText();
	}

}
