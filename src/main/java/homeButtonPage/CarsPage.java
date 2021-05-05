package homeButtonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CarsPage {

	private	WebDriver driver ; 
	//elements
	
	private By  carsSearchElement = By.xpath("(//h2[@class='float-none'])[3]");
	
	///	Actions
	
	public CarsPage(WebDriver driver) {
		this.driver = driver;
	}
	public String navigateToCarsPage() {
		
		
		return driver.findElement(carsSearchElement).getText();
	}

}
