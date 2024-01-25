package settingParamerter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ToCaptureSingleUserWithPathParam {

	@Test
	public void getUserDetails() {
		
		baseURI = "https://reqres.in/";
		
		given()
			.pathParam("resourcePath1", "api")
			.pathParam("resourcePath2", "users")
			.pathParam("userId", "2")
			.log().all()
		.when()
			.get("{resourcePath1}/{resourcePath2}/{userId}")
		
		.then()
			.statusCode(200)
			.log().body();		
	}
}
