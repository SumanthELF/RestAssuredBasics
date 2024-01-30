package passingBodyInDifferentApproaches;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;

public class ToUploadAFile {

	@Test
	public void addAnImage() {
		baseURI = "https://petstore.swagger.io/v2";
		
		File image1 = new File("C:\\Users\\user\\Downloads\\Exp Resume\\Neha Kushwaha_ 8 years_ Java+Selenium+Rest Assured.pdf");
		File image2 = new File("C:\\Users\\user\\Pictures\\DummyImage.png");
		
		//Pre condition
		given()
			.multiPart(image1)
			.multiPart(image2)
			
		
		//http method
		.when()
			.post("/pet/6704946383/uploadImage")
		
		//response
		.then()
			.log().all();
		
	}
}
