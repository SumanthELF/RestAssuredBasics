package settingParamerter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ToCaptureSingleUser {

	@Test
	public void getUserDetails() {
		
		baseURI = "https://reqres.in/";
		
		given()
		
		.when()
			.get("/api/users/2")
		
		.then()
			.statusCode(200)
			.log().body();
		
		given()
			
		.when()
			.get("/api/users/3")
			
		.then()
			.log().body();
		
		
	}
}
