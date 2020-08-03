package assignjira_week2;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Multiple_issue_file {
	@DataProvider(name = "123")
	public String[] create()
	{
		String[] data = new String[2];
		data[0] = "./data/Issue1.json";
		data[1] = "./data/Issue2.json";
		return data;
	}
	
	@Test(dataProvider = "123")
	public void iss(String file1)
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
		r.prettyPrint();
		
;
	
	
	}

}
