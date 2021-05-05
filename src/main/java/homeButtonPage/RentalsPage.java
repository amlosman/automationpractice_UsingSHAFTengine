package homeButtonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RentalsPage {
	
	
	private	WebDriver driver ; 
	//elements
	
	private By  rentalesSearchElement = By.xpath("(//h2[@class='float-none'])[3]");
	
	///	Actions
	
	public RentalsPage(WebDriver driver) {
		this.driver = driver;
	}
	public String navigateToRentalPage() {
		
		
		return driver.findElement(rentalesSearchElement).getText();
	}

	

}
