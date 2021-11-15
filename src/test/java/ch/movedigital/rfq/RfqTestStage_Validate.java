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
public class RfqTestStage_Validate {

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
	public void test_rl7v4ufdkoqd_getById1() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.pathParam("id", "b3862d18-1e9e-4c95-bde1-1bed93d89167")
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
	public void test_ubgv9c20xmqq_getById1() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.pathParam("id", "6c5ae537-01f5-408c-aa6e-a65cb32636ec")
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
	public void test_1jylmdnw05mci_searchRfqs() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.contentType("application/json")
				.body("{\"query\":\"b3862d18-1e9e-4c95-bde1-1bed93d89167\"}")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
//				.filter(validationFilter)
			.when()
				.post("/api/app/rfq/search");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_rhg1bse1lgza_searchRfqs() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
					.contentType("application/json")
					.body("{\"query\":\"6c5ae537-01f5-408c-aa6e-a65cb32636ec\"}")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
//				.filter(validationFilter)
			.when()
				.post("/api/app/rfq/search");
			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_1iv4bkgma48df_validate() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
				.filter(validationFilter)
			.when()
				.put("/api/app/rfq/validate");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_1hrs1okayh3z8_validate() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.contentType("application/json")
				.body("{\n" +
						"  \"rfq\": {\n" +
						"    \"acceptedProviderTenantId\": null ,\n" +
						"    \"adjustmentParentId\": null ,\n" +
						"    \"conditionalCoupon\": false ,\n" +
						"    \"connectedProviderTenantIds\": [\n" +
						"      2 ,\n" +
						"      3\n" +
						"    ] ,\n" +
						"    \"coupon\": null ,\n" +
						"    \"couponBarrier\": null ,\n" +
						"    \"couponCap\": null ,\n" +
						"    \"couponFloor\": null ,\n" +
						"    \"couponFrequency\": \"QUARTERLY\" ,\n" +
						"    \"couponMemory\": \"NO\" ,\n" +
						"    \"couponObsFrequency\": \"BERMUDAN\" ,\n" +
						"    \"couponObsStyle\": \"CLOSING\" ,\n" +
						"    \"couponObsType\": \"SINGLE_UNDERLYING\" ,\n" +
						"    \"couponReferenceRate\": null ,\n" +
						"    \"couponSpread\": null ,\n" +
						"    \"couponStep\": null ,\n" +
						"    \"couponStepFrequency\": null ,\n" +
						"    \"couponType\": \"FIXED\" ,\n" +
						"    \"creationDateTime\": \"2021-11-12T07:58:45.704Z\" ,\n" +
						"    \"currency\": \"EUR\" ,\n" +
						"    \"deadline\": \"2021-11-20T07:59:37.520Z\" ,\n" +
						"    \"denomination\": 1000 ,\n" +
						"    \"distributionType\": \"PRIVATE_PLACEMENT\" ,\n" +
						"    \"documentRequisites\": [\n" +
						"      {\n" +
						"        \"type\": \"TERMSHEET\" ,\n" +
						"        \"isEnglishLanguage\": true ,\n" +
						"        \"isGermanLanguage\": false ,\n" +
						"        \"isFrenchLanguage\": false ,\n" +
						"        \"isSpanishLanguage\": false ,\n" +
						"        \"isRussianLanguage\": false ,\n" +
						"        \"isItalianLanguage\": false\n" +
						"      }\n" +
						"    ] ,\n" +
						"    \"earlyRedemptionBarrierObservationType\": \"SINGLE_UNDERLYING\" ,\n" +
						"    \"earlyRedemptionBarrierRate\": 100 ,\n" +
						"    \"earlyRedemptionExitRate\": null ,\n" +
						"    \"earlyRedemptionFirstObservationTenor\": \"3m\" ,\n" +
						"    \"earlyRedemptionObservationFrequency\": \"QUARTERLY\" ,\n" +
						"    \"earlyRedemptionPriceRate\": 100 ,\n" +
						"    \"earlyRedemptionStep\": null ,\n" +
						"    \"earlyRedemptionType\": \"AUTOCALLABLE\" ,\n" +
						"    \"elaborationStatus\": \"PENDING\" ,\n" +
						"    \"executionDateTime\": null ,\n" +
						"    \"fees\": [\n" +
						"      {\n" +
						"        \"id\": 1 ,\n" +
						"        \"grossParentId\": null ,\n" +
						"        \"splitParentId\": null ,\n" +
						"        \"type\": \"CO_STRUCTURING_FEE\" ,\n" +
						"        \"amount\": 1 ,\n" +
						"        \"status\": \"FIXED\" ,\n" +
						"        \"calculationType\": \"NOTIONAL_PERCENTAGE\" ,\n" +
						"        \"paymentDate\": null ,\n" +
						"        \"isSplit\": false ,\n" +
						"        \"isNew\": true\n" +
						"      }\n" +
						"    ] ,\n" +
						"    \"finalFixingDate\": null ,\n" +
						"    \"finalRepaymentDate\": null ,\n" +
						"    \"fixingType\": \"CLOSING\" ,\n" +
						"    \"hasCustomTitle\": false ,\n" +
						"    \"id\": null ,\n" +
						"    \"initialFixingDate\": \"2021-11-12\" ,\n" +
						"    \"initiative\": \"9gag\" ,\n" +
						"    \"internalAssetClass\": \"EQUITY\" ,\n" +
						"    \"internalRmBusinessArea\": \"IWM_EUROPE\" ,\n" +
						"    \"isAdjustment\": false ,\n" +
						"    \"isVariation\": false ,\n" +
						"    \"issueDate\": null ,\n" +
						"    \"issuePriceLevel\": null ,\n" +
						"    \"issuePriceRate\": 100 ,\n" +
						"    \"masterId\": null ,\n" +
						"    \"nonConnectedProviderTenantIds\": [ ] ,\n" +
						"    \"notional\": 1050000 ,\n" +
						"    \"offerings\": [ ] ,\n" +
						"    \"parentId\": null ,\n" +
						"    \"productType\": \"ARC\" ,\n" +
						"    \"providerNote\": \"[{\\\"type\\\":\\\"PARAGRAPH\\\",\\\"children\\\":[{\\\"text\\\":\\\"Note\\\",\\\"bold\\\":true,\\\"italic\\\":true,\\\"underline\\\":true}]}]\" ,\n" +
						"    \"providerTenantIds\": [ ] ,\n" +
						"    \"quanto\": null ,\n" +
						"    \"quotationType\": \"PERCENTAGE_PRICE\" ,\n" +
						"    \"requestDateTime\": null ,\n" +
						"    \"requestType\": \"COMPETITION\" ,\n" +
						"    \"requesterFirstName\": null ,\n" +
						"    \"requesterLastName\": null ,\n" +
						"    \"requesterName\": \"\" ,\n" +
						"    \"requireIndicativeDocuments\": false ,\n" +
						"    \"rmFullName\": \"Bobi Branson\" ,\n" +
						"    \"settlement\": \"PHYSICAL\" ,\n" +
						"    \"settlementLag\": \"5d\" ,\n" +
						"    \"solvingFor\": \"COUPON\" ,\n" +
						"    \"sspaCode\": 1220 ,\n" +
						"    \"status\": \"DRAFT\" ,\n" +
						"    \"strikeRate\": 80 ,\n" +
						"    \"submissionDateTime\": null ,\n" +
						"    \"submitterFirstName\": \"Kostadin\" ,\n" +
						"    \"submitterLastName\": \"Terziev\" ,\n" +
						"    \"submitterName\": \"Kostadin Terziev\" ,\n" +
						"    \"subscriptionEndDate\": null ,\n" +
						"    \"subscriptionStartDate\": null ,\n" +
						"    \"sunshineId\": null ,\n" +
						"    \"tenantId\": 1 ,\n" +
						"    \"tenor\": \"1y\" ,\n" +
						"    \"title\": \"Autocallable RC on Adidas AG in EUR\" ,\n" +
						"    \"ukRelevant\": [ ] ,\n" +
						"    \"underlyingExposure\": \"SINGLE_UNDERLYING\" ,\n" +
						"    \"underlyings\": [\n" +
						"      {\n" +
						"        \"bbgTicker\": \"ADS GY\" ,\n" +
						"        \"commodityIndex\": \"False\" ,\n" +
						"        \"countryCode\": \"DE\" ,\n" +
						"        \"currency\": \"EUR\" ,\n" +
						"        \"description\": \"Adidas AG\" ,\n" +
						"        \"emergingMarket\": \"False\" ,\n" +
						"        \"exchangeCode\": \"GY\" ,\n" +
						"        \"indexReturnTypeId\": null ,\n" +
						"        \"industry\": \"Textiles/Leather Goods\" ,\n" +
						"        \"initialFixingDate\": \"2021-11-12\" ,\n" +
						"        \"instrumentClass\": null ,\n" +
						"        \"isin\": \"DE000A1EWWW0\" ,\n" +
						"        \"region\": \"Germany\" ,\n" +
						"        \"ric\": \"ADSGn.DE\" ,\n" +
						"        \"securityType\": \"Share\" ,\n" +
						"        \"shortName\": \"Adidas\" ,\n" +
						"        \"subClass\": null ,\n" +
						"        \"tacs\": \"ADSGn.DE\" ,\n" +
						"        \"type\": \"EQUITY\" ,\n" +
						"        \"valor\": \"11730015\" ,\n" +
						"        \"weight\": 100\n" +
						"      }\n" +
						"    ] ,\n" +
						"    \"userId\": \"kostad20210803-122632-1\" ,\n" +
						"    \"variationParentId\": null ,\n" +
						"    \"version\": 0\n" +
						"  }\n" +
						"}\n" +
						"\n")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
//				.filter(validationFilter)
			.when()
				.put("/api/app/rfq/validate");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

}
