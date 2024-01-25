package settingParamerter;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class ToCaptureSingleUserWithPathParamAndQueryParam {

	@Test
	public void getUserDetails() {
		
		baseURI = "https://reqres.in/";
		
		given()
			.pathParam("resourcePath1", "api")
			.pathParam("resourcePath2", "users")
			.queryParam("page", "1")
			.log().all()
		.when()
			.get("{resourcePath1}/{resourcePath2}")
		
		.then()
			.statusCode(200)
			.log().body();		
	}
}
