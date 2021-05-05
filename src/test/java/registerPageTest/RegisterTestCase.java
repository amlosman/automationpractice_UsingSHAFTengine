package registerPageTest;

import java.io.File;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.shaft.driver.DriverFactory;
import com.shaft.validation.Assertions;

import homePage.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import utils.ExcelFileManage;
@Epic("Web GUI for regiser page")
@Feature("PHPTRAVELS")
public class RegisterTestCase {
	WebDriver driver;
	ExcelFileManage excel;
	Date date = new Date();
    String email = "test" + date.getTime() + "@test.com";

	@BeforeMethod
	public void setUp(){

		driver= DriverFactory.getDriver();
		driver.manage().window().maximize();
		excel = new ExcelFileManage(new File("src\\test\\resources\\Data\\testData.xlsx"));
		excel.switchToSheet("Sheet1");
	}

	
	@Test(description = "Validate The Sign Up feature")
    @Description("When I enter valid data in the sign up form And click the signup button, Then I should be signed up successfully And should be navigated to the user account page And I should see my user data and a Hi message with my first name and last name")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Sign Up")
    @TmsLink("Test_case")
    @Issue("Software_bug")
	public void TestByhappeSenario() {

		String Actual= new HomePage(driver).navigateHomePage().
				navigateToRegister().
				fillSignUpform(excel.getCellData("firstname", 2),
				excel.getCellData("lastname", 2), excel.getCellData("phone", 2),email,
				excel.getCellData("password", 2), excel.getCellData("confirmpassword", 2)).
				getMassegesignUpSecc();

		Assertions.assertEquals(Actual,"Hi, "+excel.getCellData("firstname", 2)+" "+excel.getCellData("lastname", 2));
	}

	@Test(description = "Validate The Sign Up feature")
    @Description("When I enter valid data in the sign up form And click the signup button, Then I shouldn't be signed up successfully And it should show The Email field must contain a valid email addres message")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Sign Up")
    @TmsLink("Test_case")
    @Issue("Software_bug")
	public void testByInvalidEmail() {

		String Actual = new HomePage(driver).navigateHomePage().navigateToRegister().fillSignUpform(excel.getCellData("firstname", 3),
				excel.getCellData("lastname", 3), excel.getCellData("phone", 3), excel.getCellData("email", 3),
				excel.getCellData("password", 3), excel.getCellData("confirmpassword", 3)).getAlertMassegeForEmail();
		
		Assertions.assertEquals(Actual, "The Email field must contain a valid email address.");

	}

	@Test(description = "Validate The Sign Up feature")
    @Description("When I enter valid data in the sign up form And click the signup button, Then I shouldn't be signed up successfully And it should show The Password field must be at least 6 characters in length message")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Sign Up")
    @TmsLink("Test_case")
    @Issue("Software_bug")

	public void TestByInvalidPassword() {

		String Actual = new HomePage(driver).navigateHomePage().navigateToRegister().fillSignUpform(excel.getCellData("firstname", 4),
				excel.getCellData("lastname", 4), excel.getCellData("phone", 4), excel.getCellData("email", 4),
				excel.getCellData("password", 4), excel.getCellData("confirmpassword", 4)).getAlertMassegeForPassword();
		Assertions.assertEquals(Actual,"The Password field must be at least 6 characters in length.");
	}

	@Test(description = "Validate The Sign Up feature")
    @Description("When I enter valid data in the sign up form And click the signup button, Then I shouldn't be signed up successfully And it should show Password not matching with confirm password message")
    @Severity(SeverityLevel.CRITICAL)
    @Story("Sign Up")
    @TmsLink("Test_case")
    @Issue("Software_bug")

	public void TestByInvalidConfirmPassword() {

		String Actual =new HomePage(driver).navigateHomePage().navigateToRegister().fillSignUpform(excel.getCellData("firstname", 5),
				excel.getCellData("lastname", 5), excel.getCellData("phone", 5), excel.getCellData("email", 5),
				excel.getCellData("password", 5), excel.getCellData("confirmpassword", 5)).getAlertMassegeForConfirmPassword();
		Assertions.assertEquals(Actual,"Password not matching with confirm password.");

	}
	
	@AfterMethod
	public void turn_down() {
		driver.quit();
	}

}
