package passingBodyInDifferentApproaches;

import org.testng.annotations.Test;

import pojo_classes.Create_User;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;

public class ToCreateUserUsingExternalJSONFile {
	@Test
	public void createUser() throws FileNotFoundException {		
		
		//Approach 1
//		File ref = new File("./JSON files/CreateUSer.json");
		
		//Approach 2
		FileReader fr = new FileReader("./JSON files/CreateUSer.json");
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		//Pre condition
		given()
			.header("Content-Type","application/json")
			.body(data.toString())
		
		//Request type
		.when()
			.post("https://reqres.in/api/users")
			
		//Response validation	
		.then()
			.statusCode(201)
			.log().all();		
	}
}
