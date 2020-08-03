package assignjira_week2;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CountofIssue {
	
	@Test
	public void issue() {
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search?jql=project=RA";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "R33UfaHceWv64glaBnDDF6CA");
		Response response = RestAssured.get();
		System.out.println(response.getStatusCode());
		
		JsonPath list = response.jsonPath();
		List<Object> l = list.getList("issues.key");
		System.out.println("The total issues = "+l.size());
		//System.out.println(l.get(45));
		//response.prettyPrint();

		
	}

}
