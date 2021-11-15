package ch.movedigital.rfq;

import io.restassured.http.ContentType;
import org.junit.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.FixMethodOrder;
import static org.junit.Assert.fail;
import com.fasterxml.jackson.databind.ObjectMapper;
import static org.junit.Assert.assertTrue;
import org.junit.runners.MethodSorters;
import io.qameta.allure.restassured.AllureRestAssured;
import es.us.isa.restest.testcases.restassured.filters.StatusCode5XXFilter;
import es.us.isa.restest.testcases.restassured.filters.NominalOrFaultyTestCaseFilter;
import es.us.isa.restest.testcases.restassured.filters.StatefulFilter;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import es.us.isa.restest.testcases.restassured.filters.ResponseValidationFilter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RfqTest_GetRFQ {

	private static final String OAI_JSON_URL = "src/test/resources/Move/rfq-test-reduced.yaml";
	private static final StatusCode5XXFilter statusCode5XXFilter = new StatusCode5XXFilter();
	private static final NominalOrFaultyTestCaseFilter nominalOrFaultyTestCaseFilter = new NominalOrFaultyTestCaseFilter();
	private static final ResponseValidationFilter validationFilter = new ResponseValidationFilter(OAI_JSON_URL);
	private static final AllureRestAssured allureFilter = new AllureRestAssured();

	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "http://nexus.stage.amana.vpn/";
		Map<String, String> userLogin = new HashMap<>();
		userLogin.put("username", "kostadin.terziev@movedigital.ch");
		userLogin.put("password", "Nos56438");

		Response resp = RestAssured.given()
				.contentType(ContentType.JSON)
				.body(userLogin)
				.when()
				.post("/api/public/user/login")
				.then()
				.statusCode(200)
				.extract()
				.response();

		RestAssured.sessionId = resp.getHeaders().asList()
				.stream()
				.filter(h -> h.getName().equalsIgnoreCase("set-cookie"))
				.findFirst()
				.get()
				.getValue()
				.substring(11);

	}

	@Test
	public void test_ubrdrx8tz6lt_getById1() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.pathParam("id", "8550db51-c8a8-48fa-9b56-1a4ef0e9c186")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
//				.filter(validationFilter)
			.when()
				.get("/api/app/rfq/{id}");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_1hrubx1uhihbk_getById1() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.pathParam("id", "8550db51-c8a8-48fa-9b56-1a4ef0e9c186")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
				.filter(validationFilter)
			.when()
				.get("/api/app/rfq/{id}");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

}
