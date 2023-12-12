package pojoClasses;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;


public class AddplaceWithpojoclasses {
    @Test
	public void testCase1() {
    	RequestBody pj=new RequestBody();
		Location l=new Location();
		l.setLat(34.55);
		l.setLng(45);
		
		pj.setLocation(l);
		pj.setAccuracy(34);
		pj.setName("SKN Tech solutions");
		pj.setPhone_number("9972278770");
		pj.setAddress("Bangalore");
		List<String> li=new ArrayList<String>();
		li.add("office");
		li.add("constancy");
		pj.setTypes(li);
		pj.setWebsite("www.skntechsolution.com");
		pj.setLanguage("English");
		

    	
		RestAssured.baseURI="https://rahulshettyacademy.com";
		ResponseBody response = RestAssured.given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json").body(pj).when().post("/maps/api/place/add/json").then().log().all().assertThat().statusCode(200).body("status",Matchers.equalTo("OK")).body("scope", Matchers.equalTo("APP")).header("server", Matchers.equalTo("Apache/2.4.52 (Ubuntu)")).extract().as(ResponseBody.class);
		String place_id =response.getPlace_id();
		System.out.println("Place_id()"+place_id);
		
		
		
}
}
