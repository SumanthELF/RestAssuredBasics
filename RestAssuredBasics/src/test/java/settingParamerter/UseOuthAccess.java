package settingParamerter;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class UseOuthAccess {

	@Test
	public void getRepo() {
		RestAssured.given()
			.auth().oauth2("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")
			
		.when()
			.get("")
			
		.then()
			.log().all();
	}
}
