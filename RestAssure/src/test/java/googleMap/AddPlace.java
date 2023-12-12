package googleMap;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import payload.PayLoad;
public class AddPlace {
	@Test
	public void testCase1() {
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String responseJson = RestAssured.given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(PayLoad.addPlaceReturn()).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("status",Matchers.equalTo("OK")).body("scope", Matchers.equalTo("APP")).header("server", Matchers.equalTo("Apache/2.4.52 (Ubuntu)")).extract().asString();
				JsonPath js=new JsonPath(responseJson);
				String status =js.getString("status");
				String placeid = js.getString("place_id");
				System.out.println("status= "+status);
				System.out.println("place id= "+placeid);
				
				
				System.out.println("************Get Place*******************");
				RestAssured.given().log().all().queryParam("key", "qaclick123").queryParam("place_id",placeid).when().get("/maps/api/place/get/json").then().log().all().assertThat().statusCode(200);
				
				
				System.out.println("************Update Place*******************");
				RestAssured.given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body("{\r\n"
						+ "\"place_id\":\""+placeid+"\",\r\n"
						+ "\"address\":\"70  Hitech City, \",\r\n"
						+ "\"key\":\"qaclick123\"\r\n"
						+ "}\r\n"
						+ "").when().put("/maps/api/place/update/json").then().log().all().assertThat().statusCode(200);
				
				
				System.out.println("************Delete Place*******************");
				RestAssured.given().log().all().header("Content-Type","application/json").body("{ \"place_id\": \""+placeid+"\"}").when().delete("/maps/api/place/delete/json").then().log().all().assertThat().statusCode(200);
	}
}


