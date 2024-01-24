package passingBodyInDifferentApproaches;

import org.testng.annotations.Test;

import pojo_classes.Create_User;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ToCreateUserUsingPOJO {
	@Test
	public void createUser(){		
		
		Create_User data = new Create_User("Harsha", "Jr QA");
		
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
