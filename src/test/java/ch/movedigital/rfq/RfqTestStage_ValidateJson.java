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
public class RfqTestStage_ValidateJson {

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
	public void test_1iepi4fkvphyq_getById1() {
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

	@Test
	public void test_1k1wqc78zrty9_getById1() {
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

	@Test
	public void test_1jy2phor90y90_searchRfqs() {
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
				.post("/api/app/rfq/search");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_1ibjuwt18t4rm_searchRfqs() {
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
				.filter(validationFilter)
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
	public void test_1hbd9brxzay40_validate() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.contentType("application/json")
				.body("{\"rfq\":{\"acceptedProviderTenantId\":null,\"adjustmentParentId\":null,\"conditionalCoupon\":false,\"connectedProviderTenantIds\":[2,3],\"coupon\":null,\"couponBarrier\":null,\"couponCap\":null,\"couponFloor\":null,\"couponFrequency\":\"QUARTERLY\",\"couponMemory\":\"NO\",\"couponObsFrequency\":\"BERMUDAN\",\"couponObsStyle\":\"CLOSING\",\"couponObsType\":\"SINGLE_UNDERLYING\",\"couponReferenceRate\":null,\"couponSpread\":null,\"couponStep\":null,\"couponStepFrequency\":null,\"couponType\":\"FIXED\",\"creationDateTime\":\"2021-11-12T07:58:45.704Z\",\"currency\":\"EUR\",\"deadline\":\"2021-11-20T07:59:37.520Z\",\"denomination\":1000,\"distributionType\":\"PRIVATE_PLACEMENT\",\"documentRequisites\":[{\"type\":\"TERMSHEET\",\"isEnglishLanguage\":true,\"isGermanLanguage\":false,\"isFrenchLanguage\":false,\"isSpanishLanguage\":false,\"isRussianLanguage\":false,\"isItalianLanguage\":false}],\"earlyRedemptionBarrierObservationType\":\"SINGLE_UNDERLYING\",\"earlyRedemptionBarrierRate\":100,\"earlyRedemptionExitRate\":null,\"earlyRedemptionFirstObservationTenor\":\"3m\",\"earlyRedemptionObservationFrequency\":\"QUARTERLY\",\"earlyRedemptionPriceRate\":100,\"earlyRedemptionStep\":null,\"earlyRedemptionType\":\"AUTOCALLABLE\",\"elaborationStatus\":\"PENDING\",\"executionDateTime\":null,\"fees\":[{\"id\":1,\"grossParentId\":null,\"splitParentId\":null,\"type\":\"CO_STRUCTURING_FEE\",\"amount\":1,\"status\":\"FIXED\",\"calculationType\":\"NOTIONAL_PERCENTAGE\",\"paymentDate\":null,\"isSplit\":false,\"isNew\":true}],\"finalFixingDate\":null,\"finalRepaymentDate\":null,\"fixingType\":\"CLOSING\",\"hasCustomTitle\":false,\"id\":null,\"initialFixingDate\":\"2021-11-12\",\"initiative\":\"9gag\",\"internalAssetClass\":\"EQUITY\",\"internalRmBusinessArea\":\"IWM_EUROPE\",\"isAdjustment\":false,\"isVariation\":false,\"issueDate\":null,\"issuePriceLevel\":null,\"issuePriceRate\":100,\"masterId\":null,\"nonConnectedProviderTenantIds\":[],\"notional\":1050000,\"offerings\":[],\"parentId\":null,\"productType\":\"ARC\",\"providerNote\":\"[{\\\"type\\\":\\\"PARAGRAPH\\\",\\\"children\\\":[{\\\"text\\\":\\\"Note\\\",\\\"bold\\\":true,\\\"italic\\\":true,\\\"underline\\\":true}]}]\",\"providerTenantIds\":[],\"quanto\":null,\"quotationType\":\"PERCENTAGE_PRICE\",\"requestDateTime\":null,\"requestType\":\"COMPETITION\",\"requesterFirstName\":null,\"requesterLastName\":null,\"requesterName\":\"\",\"requireIndicativeDocuments\":false,\"rmFullName\":\"Bobi Branson\",\"settlement\":\"PHYSICAL\",\"settlementLag\":\"5d\",\"solvingFor\":\"COUPON\",\"sspaCode\":1220,\"status\":\"DRAFT\",\"strikeRate\":80,\"submissionDateTime\":null,\"submitterFirstName\":\"Kostadin\",\"submitterLastName\":\"Terziev\",\"submitterName\":\"Kostadin Terziev\",\"subscriptionEndDate\":null,\"subscriptionStartDate\":null,\"sunshineId\":null,\"tenantId\":1,\"tenor\":\"1y\",\"title\":\"Autocallable RC on Adidas AG in EUR\",\"ukRelevant\":[],\"underlyingExposure\":\"SINGLE_UNDERLYING\",\"underlyings\":[{\"bbgTicker\":\"ADS GY\",\"commodityIndex\":\"False\",\"countryCode\":\"DE\",\"currency\":\"EUR\",\"description\":\"Adidas AG\",\"emergingMarket\":\"False\",\"exchangeCode\":\"GY\",\"indexReturnTypeId\":null,\"industry\":\"Textiles/Leather Goods\",\"initialFixingDate\":\"2021-11-12\",\"instrumentClass\":null,\"isin\":\"DE000A1EWWW0\",\"region\":\"Germany\",\"ric\":\"ADSGn.DE\",\"securityType\":\"Share\",\"shortName\":\"Adidas\",\"subClass\":null,\"tacs\":\"ADSGn.DE\",\"type\":\"EQUITY\",\"valor\":\"11730015\",\"weight\":100}],\"userId\":\"kostad20210803-122632-1\",\"variationParentId\":null,\"version\":0}}")
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
	public void test_vf98dye13580_validate() {
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

}
