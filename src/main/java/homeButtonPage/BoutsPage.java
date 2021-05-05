package homeButtonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BoutsPage {

	private	WebDriver driver ; 
	//elements
	
	private By  carsSearchElement = By.xpath("(//h2[@class='float-none'])[3]");
	
	///	Actions
	
	public BoutsPage(WebDriver driver) {
		this.driver = driver;
	}
	public String navigateToBoutsPage() {
		
		
		return driver.findElement(carsSearchElement).getText();
	}

}
