package assignjira_week2;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Attach_file extends Base_file {

	@Test(dependsOnMethods = "assignjira_week2.Create_ticket.iss1")
	public void attachfile()
	{
		File data = new File("./data/Coder.jpg");
		
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/3/issue/"+keys+"/attachments";
		RestAssured.authentication = RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "R33UfaHceWv64glaBnDDF6CA");
		Response attach = RestAssured
		.given()
		.header("Content-Type","multipart/form-data")
		.header("X-Atlassian-Token","no-check")
		.log().all()
		.multiPart(data)
		.post();
		
		System.out.println(attach.getStatusCode());
	}
}
