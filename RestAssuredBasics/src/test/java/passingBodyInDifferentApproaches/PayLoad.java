package passingBodyInDifferentApproaches;

public class PayLoad {

	public static String updateUser() {
		return "{\r\n"
				+ "    \"name\": \"Karthik\",\r\n"
				+ "    \"job\": \"Devekoper\"\r\n"
				+ "}";
	}
	
	public static String createUser() {
		return "{\r\n"
				+ "    \"name\": \"Manoj\",\r\n"
				+ "    \"job\": \"Test Engg\"\r\n"
				+ "}";
	}
}
