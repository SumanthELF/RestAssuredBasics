package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class ToUpdateUser {
	@Test
	public void createUser() {		
		//Pre condition
		given()
			.header("Content-Type","application/json")
			.body("{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"zion resident\"\r\n"
					+ "}")
		
		//Request type
		.when()
			.put("https://reqres.in/api/users/2")
			
		//Response validation	
		.then()
			.statusCode(200)
			.log().all();		
	}
}
