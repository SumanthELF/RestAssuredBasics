package reqres;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class ToCaptureAllUsers {

	@Test
	public void getUsers() {
		
		  RestAssured 
		  //Pre condition 
		  	.given()
		  		.contentType(ContentType.JSON)
		  
		  //http method 
		  	.when() 
		  		.get("https://reqres.in/api/users?page=2")
		  
		  //response validation 
		  	.then()
		  		.statusCode(200)
		  		.log().all();		 
	}
}
