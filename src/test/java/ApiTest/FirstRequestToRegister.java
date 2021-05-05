package ApiTest;

import java.util.Arrays;
import java.util.List;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.shaft.api.RestActions.ParametersType;
import com.shaft.api.RestActions.RequestType;
import com.shaft.driver.DriverFactory;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.http.ContentType;
@Epic("Web Api")
@Feature("PHPTRAVELS")
public class FirstRequestToRegister {
	String email;
	String  password;
  @Test
  public void userSignUp() {
	     Faker fakeData = new Faker();
	     email = fakeData.internet().emailAddress(); 
	     password = "123456";
	     String phone= fakeData.phoneNumber().toString();

	     String firtName = fakeData.name().firstName(); 

	     String lastName = fakeData.name().lastName(); 
	  
	  List<List<Object>>formPram = Arrays.asList(
			  Arrays.asList("firstname",firtName),
			  Arrays.asList("lastname",lastName),
			  Arrays.asList("phone",phone),
			  Arrays.asList("email",email),
			  Arrays.asList("password",password),
			  Arrays.asList("confirmpassword",password)
			  );	  
	  DriverFactory.getAPIDriver("https://www.phptravels.net/")
	  .buildNewRequest("account/signup", RequestType.POST)
	  .setContentType(ContentType.HTML)
	  .setTargetStatusCode(200)
	  .setParameters(formPram, ParametersType.FORM)
	  .performRequest();
	  
	  DriverFactory.getAPIDriver("https://www.phptravels.net/")
	  .buildNewRequest("account/logout/", RequestType.GET)
	  .setContentType(ContentType.HTML)
	  .setTargetStatusCode(200)
	  .performRequest();
      
  }
  @Test
  public void userSignin() {
	     
	  
	  List<List<Object>>formPram = Arrays.asList(
			  Arrays.asList("email",email),
			  Arrays.asList("password",password)
			 
			  );	  
	  DriverFactory.getAPIDriver("https://www.phptravels.net/")
	  .buildNewRequest("account/login", RequestType.POST)
	  .setContentType(ContentType.HTML)
	  .setTargetStatusCode(200)
	  .setParameters(formPram, ParametersType.FORM)
	  .performRequest();
	  
  }
  
}
