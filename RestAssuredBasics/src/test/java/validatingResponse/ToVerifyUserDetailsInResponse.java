package validatingResponse;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ToVerifyUserDetailsInResponse {

	@Test
	public void getUsers() {
		
		given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.body("data[0].first_name", Matchers.equalTo("michael"));	
		
	}
}
