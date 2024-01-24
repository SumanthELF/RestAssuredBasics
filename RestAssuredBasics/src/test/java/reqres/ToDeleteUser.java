package reqres;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class ToDeleteUser {
	@Test
	public void createUser() {		
		//Pre condition
		given()
			.header("Content-Type","application/json")
		
		//Request type
		.when()
			.delete("https://reqres.in/api/users/2")
			
		//Response validation	
		.then()
			.statusCode(204)
			.log().all();		
	}
}
