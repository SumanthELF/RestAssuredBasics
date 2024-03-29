package requestChaining;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class PetStore {

	long petId ;
	
	@Test
	public void createAPet() {
		
		Random random = new Random();
		int rand = random.nextInt(1000);
		
		File ref = new File("./src/test/resources/petStore/createPet.json");
		
		Response res = given()
			.contentType(ContentType.JSON)
			.body(ref)
		.when()
			.post("https://petstore.swagger.io/v2/pet");
		
		petId = res.jsonPath().get("id");
		
		long timeTaken = res.timeIn(TimeUnit.MILLISECONDS);
		System.out.println(timeTaken);
		res.then().time(Matchers.lessThan(2000L),TimeUnit.MILLISECONDS);
	}
	
	@Test()
	public void getPetDetails() {
		given()
			.pathParam("id", petId)
		.when()
			.get("https://petstore.swagger.io/v2/pet/{id}")
			
		.then()
			.log().all();
	}
}
