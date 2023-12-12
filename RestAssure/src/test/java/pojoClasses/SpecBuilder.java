package pojoClasses;

import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import payload.PayLoad;

public class SpecBuilder {
	
	RequestSpecification givenbody;
	Response whenbody;
	@Test
	public void testCase1() throws Throwable{
		
		PrintStream log=new PrintStream(new FileOutputStream("LogFile.txt"));
		RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
        .addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
        .addFilter(RequestLoggingFilter.logRequestTo(log))
        .addFilter(ResponseLoggingFilter.logResponseTo(log))
        .build();
		
		ResponseSpecification res = new ResponseSpecBuilder().expectStatusCode(200)
                .expectContentType(ContentType.JSON).expectHeader("server", "Apache/2.4.52 (Ubuntu)").build();
		
		 givenbody = RestAssured.given().log().headers().spec(req).body(PayLoad. addPlaceReturn());
		 whenbody = givenbody.when().post("/maps/api/place/add/json");
		whenbody.then().log().headers().spec(res);
	}




}
