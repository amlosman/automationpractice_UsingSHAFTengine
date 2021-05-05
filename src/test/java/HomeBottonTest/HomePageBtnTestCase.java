package HomeBottonTest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.validation.Assertions;

import homePage.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
@Epic("Web GUI for home page")
@Feature("PHPTRAVELS")
public class HomePageBtnTestCase {
	WebDriver driver;
	@BeforeClass
	public void beforclass() {
		driver= DriverFactory.getDriver();
		WebDriverManager.chromedriver().setup();
		driver.manage().window().maximize();
		
	}

	@Test
	public void TestHotelBtn() {
		String Actual = new HomePage(driver).navigateHomePage().clickOnHotel().navigateToHotelPage();
		
		Assertions.assertEquals(Actual,"Featured Rentals");
	}
	
	@Test
	public void TestFlightBtn() {
		String Actual = new HomePage(driver).navigateHomePage().clickOnFlight().navigateToFlightlPage();
		Assertions.assertEquals(Actual, "Featured Rentals");
	}
	
	@Test
	public void TestCarsbtn() {
		String Actual = new HomePage(driver).navigateHomePage().clickOnCars().navigateToCarsPage();
		Assertions.assertEquals(Actual, "Featured Rentals");
	}
	
	@Test
	public void TestBoutsBtn() {
		String Actual = new HomePage(driver).navigateHomePage().clickOnBouts().navigateToBoutsPage();
		Assertions.assertEquals(Actual, "Featured Rentals");
	}
	
	@Test
	public void TestToursBtn() {
		String Actual = new HomePage(driver).navigateHomePage().clickOnTours().navigateToToursPage();
		Assertions.assertEquals(Actual, "Featured Rentals");
	}
	@Test
	public void TestRentelsBtn() {
		String Actual = new HomePage(driver).navigateHomePage().clickOnRental().navigateToRentalPage();
		Assertions.assertEquals(Actual, "Featured Rentals");
	}
	@AfterClass
	public void turn_down() {
		driver.quit();
	}
}
