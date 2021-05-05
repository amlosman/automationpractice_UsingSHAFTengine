package homeButtonPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ToursPage {
	//var
		private	WebDriver driver ; 
		//elements
		
		private By  touesSearchElement = By.xpath("(//h2[@class='float-none'])[3]");
		
		///	Actions
		public  ToursPage(WebDriver driver) {
		
			this.driver=driver;
		}

		public String navigateToToursPage() {
			
			
			return driver.findElement(touesSearchElement).getText();
		}

}
