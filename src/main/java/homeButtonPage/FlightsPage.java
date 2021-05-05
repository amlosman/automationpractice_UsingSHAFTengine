package homeButtonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightsPage {

	private	WebDriver driver ; 
	//elements
	
	private By  flightsSearchElement = By.xpath("(//h2[@class='float-none'])[3]");
	
	///	Actions
	
	public FlightsPage(WebDriver driver) {
		this.driver = driver;
	}
	public String navigateToFlightlPage() {
		
		
		return driver.findElement(flightsSearchElement).getText();
	}

}
