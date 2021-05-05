package RegisterPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {
	// var
	private WebDriver driver;
	private String fname;
	private String lname;
	
	
	// elements
	By firstname = By.name("firstname");
	By lastname = By.name("lastname");
	By phone = By.name("phone");
	By email = By.name("email");
	By password = By.name("password");
	By confirmpassword = By.name("confirmpassword");
	By SignupSeccElement = By.xpath("//h3[@class = 'text-align-left']");
	By registerBTN = By.xpath("//button[@class='signupbtn btn_full btn btn-success btn-block btn-lg']");
    By invaldEmail = By.xpath("//div[@class = 'alert alert-danger']");
    By invalidPassword = By.xpath("//div[@class = 'alert alert-danger']");
    By invalidComfiromPassword =  By.xpath("//div[@class = 'alert alert-danger']");		
    
    
    //constructor
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPage fillSignUpform(String firstnam, String lastnam, String phon, String emal, String pasw,
			String comfirmpasw) {

		fname = firstnam;
		lname = lastnam;
		driver.findElement(firstname).sendKeys(firstnam);
		driver.findElement(lastname).sendKeys(lastnam);
		driver.findElement(phone).sendKeys(phon);
		driver.findElement(email).sendKeys(emal);
		driver.findElement(password).sendKeys(pasw);
		driver.findElement(confirmpassword).sendKeys(comfirmpasw);
		driver.findElement(registerBTN).click();
		return this;
	}

	public String getAlertMassegeForEmail()
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(invaldEmail));

        driver.findElement(invaldEmail).isDisplayed();
       
		return driver.findElement(invaldEmail).getText();
		
	}
	public String getAlertMassegeForPassword()
	{
		WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(invalidPassword));

        driver.findElement(invalidPassword).isDisplayed();
       
		return driver.findElement(invalidPassword).getText();
		
	}
	public String getAlertMassegeForConfirmPassword()
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(invalidComfiromPassword));

        driver.findElement(invalidComfiromPassword).isDisplayed();
       

		return driver.findElement(invalidComfiromPassword).getText();
		
	}
	public String getMassegesignUpSecc() {
		
		
		WebDriverWait wait = new WebDriverWait(driver, 200);
        wait.until(ExpectedConditions.elementToBeClickable(SignupSeccElement));

           if( driver.findElement(SignupSeccElement).isDisplayed())
			return "Hi, "+fname+" "+lname;
           else
        	   return "Error";
			
			
	}

}
