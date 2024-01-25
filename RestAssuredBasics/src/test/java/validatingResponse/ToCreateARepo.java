package validatingResponse;

import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class ToCreateARepo {

	@Test
	public void createRepo() {
		given()
			.header("Authorization","Bearer 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")
			.contentType(ContentType.JSON)
			.body("{\r\n"
					+ "\"name\":\"AGRR\",\r\n"
					+ "\"description\":\"Bollywood Actor\",\r\n"
					+ "\"private\":true\r\n"
					+ "}")
		.when()
			.post("https://api.github.com/user/repos")
		.then()
			.header("Content-Type", "application/json; charset=utf-8")
			.header("Location", "https://api.github.com/repos/ArchanaGowdaa/AGRR")
			.body("name", equalTo("AGRR"))
			.statusCode(201)
			.time(lessThan(2000L), TimeUnit.MILLISECONDS);
		
	}
}
