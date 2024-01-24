package passingBodyInDifferentApproaches;

import org.testng.annotations.Test;

import pojo_classes.Create_User;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

public class ToCreateUserUsingPOJO {
	@Test
	public void createUser() throws FileNotFoundException {		
		
		Create_User data = new Create_User();
		data.setJob("Automation Engg");
		data.setName("Harsha");
		
		//Pre condition
		given()
			.header("Content-Type","application/json")
			.body(data)
		
		//Request type
		.when()
			.post("https://reqres.in/api/users")
			
		//Response validation	
		.then()
			.statusCode(201)
			.log().all();		
	}
}
