package validatingResponse;

import static io.restassured.RestAssured.given;

import java.util.Random;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ToCaptureResponseData {

	@Test
	public void getUsers() {
		
		Response res = given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("https://reqres.in/api/users?page=2");	
		
		JSONObject responseBody = new JSONObject(res.asString());
		JSONArray users = responseBody.getJSONArray("data");
		
		boolean flag = false;
		
		for(int i=0; i<users.length(); i++) {
			JSONObject userDetails = (JSONObject) users.get(i);
			String username = userDetails.getString("first_name");
			if(username.equalsIgnoreCase("Michael")) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("Michael is present");
		}else
			System.out.println("Michael is not present");
	}
}
