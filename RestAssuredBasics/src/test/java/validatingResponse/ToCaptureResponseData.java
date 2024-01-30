package validatingResponse;

import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ToCaptureResponseData {

	@Test
	public void getUsers() {
		
		Response res = given()
			.contentType(ContentType.JSON)
			
		.when()
			.get("https://reqres.in/api/users?page=2");	
		
		JSONObject responseBody = new JSONObject(res.asString());
		JSONArray users = responseBody.getJSONArray("data");
		
		JSONObject value = responseBody.getJSONObject("support");
		System.out.println(value.getString("url"));
		System.out.println(value.getString("text"));
		
//		boolean flag = false;
//		
//		for(int i=0; i<users.length(); i++) {
//			JSONObject userDetails = (JSONObject) users.get(i);
//			String username = userDetails.getString("first_name");
//			if(username.equalsIgnoreCase("Sumanth")) {
//				flag = true;
//				break;
//			}
//		}
//		if(flag) {
//			System.out.println("Sumanth is present");
//		}else
//			System.out.println("Sumanth is not present");
	}
}
