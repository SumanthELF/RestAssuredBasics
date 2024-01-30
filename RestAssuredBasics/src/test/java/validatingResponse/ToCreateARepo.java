package validatingResponse;

import static org.hamcrest.Matchers.*;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;

public class ToCreateARepo {

	@Test
	public void createRepo() {
		
		Response res = given()
			.header("Authorization", "Bearer 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").contentType(ContentType.JSON)
			.body("{\r\n" + "\"name\":\"AGRR\",\r\n" 
						+ "\"description\":\"Bollywood Actor\",\r\n"
						+ "\"private\":true\r\n" + "}")
			
		.when()
			.post("https://api.github.com/user/repos");
		
		
	}
}
