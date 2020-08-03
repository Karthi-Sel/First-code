package assignjira_week2;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Create_ticket extends Base_file {

@DataProvider(name = "1234")
		public String[] create()
		{
			String[] data = new String[1];
			data[0] = "./data/2Issue.json";
			return data;
		}
		
		@Test(dataProvider = "1234")
		public void iss1(String file1)
		{
			RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
			RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "R33UfaHceWv64glaBnDDF6CA");
			
			File issue= new File(file1);
			
			Response r = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.body(issue)
					.post();
			System.out.println(r.statusCode());
			keys = r.jsonPath().get("key");
			System.out.println(keys);
			
	}
}
