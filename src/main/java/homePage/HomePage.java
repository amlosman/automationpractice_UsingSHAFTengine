package homePage;

import RegisterPages.RegisterPage;
import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import homeButtonPage.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	//var
	private	WebDriver driver ; 
		private	String navigateURL= "https://www.phptravels.net/home"; 
	//elements
	private	By myAccountBTN = By.linkText("MY ACCOUNT");
	private	By registerURL = By.linkText("Sign Up");
	private By hotel =  By.xpath("//a[@href='#hotels']");
	private By flights  = By.xpath("//a[@data-name='flights']");
	private By bouts = By.xpath("//a[@data-name='boats']");
	private By rentals = By.cssSelector("a[href='#rentals']");
	private By tours = By.xpath("//a[@href='#tours']");
	private By cars = By.xpath("//a[@href='#cars']");

   //actions
		
		public HomePage(WebDriver driver) {

	   	this.driver = driver;
	   }
	   public HomePage navigateHomePage() {
		   BrowserActions.navigateToURL(driver,navigateURL);
		   return this;
		}
	   public RegisterPage navigateToRegister() {
		   ElementActions.click(driver,myAccountBTN);
		   ElementActions.click(driver,registerURL);
		   return new RegisterPage(driver);
		
	}
	public HotelsPage clickOnHotel()
	{
		ElementActions.click(driver,hotel);

		return new HotelsPage(driver);
	}
	
	public CarsPage clickOnCars()
	{
		ElementActions.click(driver,cars);
		return new CarsPage(driver);
	}
	public FlightsPage clickOnFlight()
	{
		ElementActions.click(driver,flights);
	 return new FlightsPage(driver);
	}
	public RentalsPage clickOnRental()
	{
		ElementActions.click(driver,rentals);
	 return new RentalsPage(driver);
	}
	public ToursPage clickOnTours()
	{

		ElementActions.click(driver,tours);
		return new ToursPage(driver);
	}
	public BoutsPage clickOnBouts()
	{
		ElementActions.click(driver,bouts);
	 return new BoutsPage(driver);
	}
	
	
}
