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
public class RfqTestStage_GetValidateElabSummaryPost {

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
	public void test_u87w5b691c9t_getById1() {
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
	public void test_s4p2ezds2hq0_getById1() {
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
	public void test_rl8e5gkkvy2h_searchRfqs() {
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
	public void test_1ji9zigwopf8m_searchRfqs() {
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
	public void test_s4p36vbqrgpy_validate() {
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
	public void test_1h7tpaaye0px4_validate() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.contentType("application/json")
				.body("{\"rfq\":{\"acceptedProviderTenantId\":null,\"adjustmentParentId\":null,\"barrierLevel1\":88,\"barrierLower\":null,\"barrierObsFrequency\":\"DAILY\",\"barrierObsStyle\":\"CONTINUOUS\",\"barrierObsType\":\"WORST_OF\",\"barrierRebate\":null,\"barrierUpper\":null,\"conditionalCoupon\":false,\"connectedProviderTenantIds\":[2,3],\"coupon\":35,\"couponBarrier\":null,\"couponCap\":null,\"couponFloor\":null,\"couponFrequency\":\"QUARTERLY\",\"couponMemory\":\"NO\",\"couponObsFrequency\":\"BERMUDAN\",\"couponObsStyle\":\"CLOSING\",\"couponObsType\":\"WORST_OF\",\"couponReferenceRate\":null,\"couponSpread\":null,\"couponStep\":null,\"couponStepFrequency\":null,\"couponType\":\"FIXED\",\"creationDateTime\":\"2021-11-12T13:39:30.634Z\",\"currency\":\"EUR\",\"deadline\":\"2022-04-05T12:41:16.553Z\",\"denomination\":1000,\"distributionType\":\"PRIVATE_PLACEMENT\",\"documentRequisites\":[{\"type\":\"TERMSHEET\",\"isEnglishLanguage\":true,\"isGermanLanguage\":false,\"isFrenchLanguage\":false,\"isSpanishLanguage\":false,\"isRussianLanguage\":false,\"isItalianLanguage\":false}],\"earlyRedemptionBarrierObservationType\":\"WORST_OF\",\"earlyRedemptionBarrierRate\":100,\"earlyRedemptionExitRate\":144,\"earlyRedemptionFirstObservationTenor\":\"3m\",\"earlyRedemptionObservationFrequency\":\"QUARTERLY\",\"earlyRedemptionPriceRate\":100,\"earlyRedemptionStep\":12,\"earlyRedemptionType\":\"AUTOCALLABLE\",\"elaborationStatus\":\"PENDING\",\"executionDateTime\":null,\"fees\":[{\"id\":1,\"grossParentId\":null,\"splitParentId\":null,\"type\":\"CO_STRUCTURING_FEE\",\"amount\":null,\"status\":\"FIXED\",\"calculationType\":\"NOTIONAL_PERCENTAGE\",\"paymentDate\":null,\"isSplit\":false,\"isNew\":true}],\"finalFixingDate\":null,\"finalRepaymentDate\":null,\"fixingType\":\"CLOSING\",\"hasCustomTitle\":false,\"id\":null,\"initialFixingDate\":\"2021-11-12\",\"initiative\":\"9gag\",\"internalAssetClass\":\"EQUITY\",\"internalRmBusinessArea\":\"IWM_EUROPE\",\"isAdjustment\":false,\"isVariation\":false,\"issueDate\":null,\"issuePriceLevel\":null,\"issuePriceRate\":100,\"masterId\":null,\"nonConnectedProviderTenantIds\":[],\"notional\":1444500,\"offerings\":[],\"parentId\":null,\"productType\":\"ABRC\",\"providerNote\":null,\"providerTenantIds\":[],\"quanto\":null,\"quotationType\":\"PERCENTAGE_PRICE\",\"requestDateTime\":null,\"requestType\":\"COMPETITION\",\"requesterFirstName\":null,\"requesterLastName\":null,\"requesterName\":\"\",\"requireIndicativeDocuments\":false,\"rmFullName\":\"Armin Traktor\",\"settlement\":\"PHYSICAL\",\"settlementLag\":\"5d\",\"solvingFor\":\"FEE_CO_STRUCTURING\",\"sspaCode\":1230,\"status\":\"DRAFT\",\"strikeRate\":140,\"submissionDateTime\":null,\"submitterFirstName\":\"Kostadin\",\"submitterLastName\":\"Terziev\",\"submitterName\":\"Kostadin Terziev\",\"subscriptionEndDate\":null,\"subscriptionStartDate\":null,\"sunshineId\":null,\"tenantId\":1,\"tenor\":\"2y\",\"title\":\"Autocallable BRC on Adidas AG/ Ageas in EUR\",\"ukRelevant\":[],\"underlyingExposure\":\"WORST_OF\",\"underlyings\":[{\"bbgTicker\":\"ADS GY\",\"type\":\"EQUITY\",\"exchangeCode\":\"GY\",\"instrumentClass\":null,\"countryCode\":\"DE\",\"currency\":\"EUR\",\"description\":\"Adidas AG\",\"shortName\":\"Adidas\",\"isin\":\"DE000A1EWWW0\",\"region\":\"Germany\",\"ric\":\"ADSGn.DE\",\"tacs\":\"ADSGn.DE\",\"securityType\":\"Share\",\"valor\":\"11730015\",\"commodityIndex\":\"False\",\"emergingMarket\":\"False\",\"subClass\":null,\"industry\":\"Textiles/Leather Goods\",\"indexReturnTypeId\":null,\"weight\":100,\"initialFixingDate\":\"2021-11-12\"},{\"bbgTicker\":\"AGS BB\",\"commodityIndex\":\"False\",\"countryCode\":\"BE\",\"currency\":\"EUR\",\"description\":\"Ageas\",\"emergingMarket\":\"False\",\"exchangeCode\":\"BB\",\"indexReturnTypeId\":null,\"industry\":\"Insurances\",\"initialFixingDate\":\"2021-11-12\",\"instrumentClass\":null,\"isin\":\"BE0974264930\",\"region\":\"Belgium\",\"ric\":\"AGES.BR\",\"securityType\":\"Share\",\"shortName\":\"Ageas\",\"subClass\":null,\"tacs\":null,\"type\":\"EQUITY\",\"valor\":\"18954172\",\"weight\":100}],\"userId\":\"kostad20210803-122632-1\",\"variationParentId\":null,\"version\":0}}")
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
	public void test_1jefhinzo44tf_requestNewElaboration() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.contentType("application/json")
				.body("{\"rfq\":{\"acceptedProviderTenantId\":null,\"adjustmentParentId\":null,\"barrierLevel1\":88,\"barrierLower\":null,\"barrierObsFrequency\":\"DAILY\",\"barrierObsStyle\":\"CONTINUOUS\",\"barrierObsType\":\"WORST_OF\",\"barrierRebate\":null,\"barrierUpper\":null,\"conditionalCoupon\":false,\"connectedProviderTenantIds\":[2,3],\"coupon\":35,\"couponBarrier\":null,\"couponCap\":null,\"couponFloor\":null,\"couponFrequency\":\"QUARTERLY\",\"couponMemory\":\"NO\",\"couponObsFrequency\":\"BERMUDAN\",\"couponObsStyle\":\"CLOSING\",\"couponObsType\":\"WORST_OF\",\"couponReferenceRate\":null,\"couponSpread\":null,\"couponStep\":null,\"couponStepFrequency\":null,\"couponType\":\"FIXED\",\"creationDateTime\":\"2021-11-12T13:39:30.634Z\",\"currency\":\"EUR\",\"deadline\":\"2022-04-05T12:41:16.553Z\",\"denomination\":1000,\"distributionType\":\"PRIVATE_PLACEMENT\",\"documentRequisites\":[{\"type\":\"TERMSHEET\",\"isEnglishLanguage\":true,\"isGermanLanguage\":false,\"isFrenchLanguage\":false,\"isSpanishLanguage\":false,\"isRussianLanguage\":false,\"isItalianLanguage\":false}],\"earlyRedemptionBarrierObservationType\":\"WORST_OF\",\"earlyRedemptionBarrierRate\":100,\"earlyRedemptionExitRate\":144,\"earlyRedemptionFirstObservationTenor\":\"3m\",\"earlyRedemptionObservationFrequency\":\"QUARTERLY\",\"earlyRedemptionPriceRate\":100,\"earlyRedemptionStep\":12,\"earlyRedemptionType\":\"AUTOCALLABLE\",\"elaborationStatus\":\"PENDING\",\"executionDateTime\":null,\"fees\":[{\"id\":1,\"grossParentId\":null,\"splitParentId\":null,\"type\":\"CO_STRUCTURING_FEE\",\"amount\":null,\"status\":\"FIXED\",\"calculationType\":\"NOTIONAL_PERCENTAGE\",\"paymentDate\":null,\"isSplit\":false,\"isNew\":true}],\"finalFixingDate\":null,\"finalRepaymentDate\":null,\"fixingType\":\"CLOSING\",\"hasCustomTitle\":false,\"id\":null,\"initialFixingDate\":\"2021-11-12\",\"initiative\":\"9gag\",\"internalAssetClass\":\"EQUITY\",\"internalRmBusinessArea\":\"IWM_EUROPE\",\"isAdjustment\":false,\"isVariation\":false,\"issueDate\":null,\"issuePriceLevel\":null,\"issuePriceRate\":100,\"masterId\":null,\"nonConnectedProviderTenantIds\":[],\"notional\":1444500,\"offerings\":[],\"parentId\":null,\"productType\":\"ABRC\",\"providerNote\":null,\"providerTenantIds\":[],\"quanto\":null,\"quotationType\":\"PERCENTAGE_PRICE\",\"requestDateTime\":null,\"requestType\":\"COMPETITION\",\"requesterFirstName\":null,\"requesterLastName\":null,\"requesterName\":\"\",\"requireIndicativeDocuments\":false,\"rmFullName\":\"Armin Traktor\",\"settlement\":\"PHYSICAL\",\"settlementLag\":\"5d\",\"solvingFor\":\"FEE_CO_STRUCTURING\",\"sspaCode\":1230,\"status\":\"DRAFT\",\"strikeRate\":140,\"submissionDateTime\":null,\"submitterFirstName\":\"Kostadin\",\"submitterLastName\":\"Terziev\",\"submitterName\":\"Kostadin Terziev\",\"subscriptionEndDate\":null,\"subscriptionStartDate\":null,\"sunshineId\":null,\"tenantId\":1,\"tenor\":\"2y\",\"title\":\"Autocallable BRC on Adidas AG/ Ageas in EUR\",\"ukRelevant\":[],\"underlyingExposure\":\"WORST_OF\",\"underlyings\":[{\"bbgTicker\":\"ADS GY\",\"type\":\"EQUITY\",\"exchangeCode\":\"GY\",\"instrumentClass\":null,\"countryCode\":\"DE\",\"currency\":\"EUR\",\"description\":\"Adidas AG\",\"shortName\":\"Adidas\",\"isin\":\"DE000A1EWWW0\",\"region\":\"Germany\",\"ric\":\"ADSGn.DE\",\"tacs\":\"ADSGn.DE\",\"securityType\":\"Share\",\"valor\":\"11730015\",\"commodityIndex\":\"False\",\"emergingMarket\":\"False\",\"subClass\":null,\"industry\":\"Textiles/Leather Goods\",\"indexReturnTypeId\":null,\"weight\":100,\"initialFixingDate\":\"2021-11-12\"},{\"bbgTicker\":\"AGS BB\",\"type\":\"EQUITY\",\"exchangeCode\":\"BB\",\"instrumentClass\":null,\"countryCode\":\"BE\",\"currency\":\"EUR\",\"description\":\"Ageas\",\"shortName\":\"Ageas\",\"isin\":\"BE0974264930\",\"region\":\"Belgium\",\"ric\":\"AGES.BR\",\"tacs\":null,\"securityType\":\"Share\",\"valor\":\"18954172\",\"commodityIndex\":\"False\",\"emergingMarket\":\"False\",\"subClass\":null,\"industry\":\"Insurances\",\"indexReturnTypeId\":null,\"weight\":100,\"initialFixingDate\":\"2021-11-12\"}],\"userId\":\"kostad20210803-122632-1\",\"variationParentId\":null,\"version\":0}}")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
				.filter(validationFilter)
			.when()
				.post("/api/app/rfq/requester/rfq/elaborations");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_rkzlopu3et0k_requestNewElaboration() {
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
				.post("/api/app/rfq/requester/rfq/elaborations");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_1jefhwiuu31wk_generateSummary2() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.contentType("application/json")
				.body("{\"rfq\":{\"acceptedProviderTenantId\":null,\"adjustmentParentId\":null,\"barrierLevel1\":88,\"barrierLower\":null,\"barrierObsFrequency\":\"DAILY\",\"barrierObsStyle\":\"CONTINUOUS\",\"barrierObsType\":\"WORST_OF\",\"barrierRebate\":null,\"barrierUpper\":null,\"conditionalCoupon\":false,\"connectedProviderTenantIds\":[2,3],\"coupon\":35,\"couponBarrier\":null,\"couponCap\":null,\"couponFloor\":null,\"couponFrequency\":\"QUARTERLY\",\"couponMemory\":\"NO\",\"couponObsFrequency\":\"BERMUDAN\",\"couponObsStyle\":\"CLOSING\",\"couponObsType\":\"WORST_OF\",\"couponReferenceRate\":null,\"couponSpread\":null,\"couponStep\":null,\"couponStepFrequency\":null,\"couponType\":\"FIXED\",\"creationDateTime\":\"2021-11-12T13:39:30.634Z\",\"currency\":\"EUR\",\"deadline\":\"2022-04-05T12:41:16.553Z\",\"denomination\":1000,\"distributionType\":\"PRIVATE_PLACEMENT\",\"documentRequisites\":[{\"type\":\"TERMSHEET\",\"isEnglishLanguage\":true,\"isGermanLanguage\":false,\"isFrenchLanguage\":false,\"isSpanishLanguage\":false,\"isRussianLanguage\":false,\"isItalianLanguage\":false}],\"earlyRedemptionBarrierObservationType\":\"WORST_OF\",\"earlyRedemptionBarrierRate\":100,\"earlyRedemptionExitRate\":144,\"earlyRedemptionFirstObservationTenor\":\"3m\",\"earlyRedemptionObservationFrequency\":\"QUARTERLY\",\"earlyRedemptionPriceRate\":100,\"earlyRedemptionStep\":12,\"earlyRedemptionType\":\"AUTOCALLABLE\",\"elaborationStatus\":\"FAILED\",\"executionDateTime\":null,\"fees\":[{\"id\":1,\"grossParentId\":null,\"splitParentId\":null,\"type\":\"CO_STRUCTURING_FEE\",\"amount\":null,\"status\":\"FIXED\",\"calculationType\":\"NOTIONAL_PERCENTAGE\",\"paymentDate\":\"2021-11-30\",\"isSplit\":false,\"isNew\":true}],\"finalFixingDate\":\"2023-11-13\",\"finalRepaymentDate\":\"2023-11-20\",\"fixingType\":\"CLOSING\",\"hasCustomTitle\":false,\"id\":\"e0d6d428-1e29-4297-a916-e8a65e0c5cfd\",\"initialFixingDate\":\"2021-11-12\",\"initiative\":\"9gag\",\"internalAssetClass\":\"EQUITY\",\"internalRmBusinessArea\":\"IWM_EUROPE\",\"isAdjustment\":false,\"isVariation\":false,\"issueDate\":\"2021-11-19\",\"issuePriceLevel\":null,\"issuePriceRate\":100,\"masterId\":\"21D929\",\"nonConnectedProviderTenantIds\":[],\"notional\":1444500,\"offerings\":[],\"parentId\":null,\"productType\":\"ABRC\",\"providerNote\":null,\"providerTenantIds\":[2,3],\"quanto\":null,\"quotationType\":\"PERCENTAGE_PRICE\",\"requestDateTime\":null,\"requestType\":\"COMPETITION\",\"requesterFirstName\":\"Kostadin\",\"requesterLastName\":\"Terziev\",\"requesterName\":\"Kostadin Terziev\",\"requireIndicativeDocuments\":false,\"rmFullName\":\"Armin Traktor\",\"settlement\":\"PHYSICAL\",\"settlementLag\":\"5d\",\"solvingFor\":\"FEE_CO_STRUCTURING\",\"sspaCode\":1230,\"status\":\"DRAFT\",\"strikeRate\":140,\"submissionDateTime\":null,\"submitterFirstName\":\"Kostadin\",\"submitterLastName\":\"Terziev\",\"submitterName\":\"Kostadin Terziev\",\"subscriptionEndDate\":null,\"subscriptionStartDate\":null,\"sunshineId\":null,\"tenantId\":1,\"tenor\":\"2y\",\"title\":\"Autocallable BRC on Adidas AG/ Ageas in EUR, Nov 23\",\"ukRelevant\":[],\"underlyingExposure\":\"WORST_OF\",\"underlyings\":[{\"bbgTicker\":\"ADS GY\",\"type\":\"EQUITY\",\"exchangeCode\":\"GY\",\"instrumentClass\":null,\"countryCode\":\"DE\",\"currency\":\"EUR\",\"description\":\"Adidas AG\",\"shortName\":\"Adidas\",\"isin\":\"DE000A1EWWW0\",\"region\":\"Germany\",\"ric\":\"ADSGn.DE\",\"tacs\":\"ADSGn.DE\",\"securityType\":\"Share\",\"valor\":\"11730015\",\"commodityIndex\":\"False\",\"emergingMarket\":\"False\",\"subClass\":null,\"industry\":\"Textiles/Leather Goods\",\"indexReturnTypeId\":null,\"weight\":100,\"initialFixingDate\":\"2021-11-12\"},{\"bbgTicker\":\"AGS BB\",\"type\":\"EQUITY\",\"exchangeCode\":\"BB\",\"instrumentClass\":null,\"countryCode\":\"BE\",\"currency\":\"EUR\",\"description\":\"Ageas\",\"shortName\":\"Ageas\",\"isin\":\"BE0974264930\",\"region\":\"Belgium\",\"ric\":\"AGES.BR\",\"tacs\":null,\"securityType\":\"Share\",\"valor\":\"18954172\",\"commodityIndex\":\"False\",\"emergingMarket\":\"False\",\"subClass\":null,\"industry\":\"Insurances\",\"indexReturnTypeId\":null,\"weight\":100,\"initialFixingDate\":\"2021-11-12\"}],\"userId\":\"kostad20210803-122632-1\",\"variationParentId\":null,\"version\":0}}")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
				.filter(validationFilter)
			.when()
				.post("/api/app/rfq/summary");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_uv6dy4ms9i5t_generateSummary2() {
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
				.post("/api/app/rfq/summary");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_rh8aqau7hirc_createRfq() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.queryParam("productType", "CBRC")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
				.filter(validationFilter)
			.when()
				.get("/api/app/rfq");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_skms79y60h9e_createRfq() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.queryParam("productType", "PRO_NOTE_WITH_TWIN_WIN_PARTICIPATION")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
				.filter(validationFilter)
			.when()
				.get("/api/app/rfq");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_ubj3y4y7blmh_update() {
		nominalOrFaultyTestCaseFilter.updateFaultyData(false, true, "none");
		statusCode5XXFilter.updateFaultyData(false, true, "none");

		try {
			Response response = RestAssured
			.given()
				.log().all()
				.contentType("application/json")
				.body("{\"rfq\":{\"acceptedProviderTenantId\":null,\"adjustmentParentId\":null,\"barrierLevel1\":88,\"barrierLower\":null,\"barrierObsFrequency\":\"DAILY\",\"barrierObsStyle\":\"CONTINUOUS\",\"barrierObsType\":\"WORST_OF\",\"barrierRebate\":null,\"barrierUpper\":null,\"conditionalCoupon\":false,\"connectedProviderTenantIds\":[2,3],\"coupon\":35,\"couponBarrier\":null,\"couponCap\":null,\"couponFloor\":null,\"couponFrequency\":\"QUARTERLY\",\"couponMemory\":\"NO\",\"couponObsFrequency\":\"BERMUDAN\",\"couponObsStyle\":\"CLOSING\",\"couponObsType\":\"WORST_OF\",\"couponReferenceRate\":null,\"couponSpread\":null,\"couponStep\":null,\"couponStepFrequency\":null,\"couponType\":\"FIXED\",\"creationDateTime\":\"2021-11-12T13:39:30.634Z\",\"currency\":\"EUR\",\"deadline\":\"2022-04-05T12:41:16.553Z\",\"denomination\":1000,\"distributionType\":\"PRIVATE_PLACEMENT\",\"documentRequisites\":[{\"type\":\"TERMSHEET\",\"isEnglishLanguage\":true,\"isGermanLanguage\":false,\"isFrenchLanguage\":false,\"isSpanishLanguage\":false,\"isRussianLanguage\":false,\"isItalianLanguage\":false}],\"earlyRedemptionBarrierObservationType\":\"WORST_OF\",\"earlyRedemptionBarrierRate\":100,\"earlyRedemptionExitRate\":144,\"earlyRedemptionFirstObservationTenor\":\"3m\",\"earlyRedemptionObservationFrequency\":\"QUARTERLY\",\"earlyRedemptionPriceRate\":100,\"earlyRedemptionStep\":12,\"earlyRedemptionType\":\"AUTOCALLABLE\",\"elaborationStatus\":\"FAILED\",\"executionDateTime\":null,\"fees\":[{\"id\":1,\"grossParentId\":null,\"splitParentId\":null,\"type\":\"CO_STRUCTURING_FEE\",\"amount\":null,\"status\":\"FIXED\",\"calculationType\":\"NOTIONAL_PERCENTAGE\",\"paymentDate\":\"2021-11-30\",\"isSplit\":false,\"isNew\":true}],\"finalFixingDate\":\"2023-11-13\",\"finalRepaymentDate\":\"2023-11-20\",\"fixingType\":\"CLOSING\",\"hasCustomTitle\":false,\"id\":\"e0d6d428-1e29-4297-a916-e8a65e0c5cfd\",\"initialFixingDate\":\"2021-11-12\",\"initiative\":\"9gag\",\"internalAssetClass\":\"EQUITY\",\"internalRmBusinessArea\":\"IWM_EUROPE\",\"isAdjustment\":false,\"isVariation\":false,\"issueDate\":\"2021-11-19\",\"issuePriceLevel\":null,\"issuePriceRate\":100,\"masterId\":\"21D929\",\"nonConnectedProviderTenantIds\":[],\"notional\":1444500,\"offerings\":[],\"parentId\":null,\"productType\":\"ABRC\",\"providerNote\":null,\"providerTenantIds\":[2,3],\"quanto\":null,\"quotationType\":\"PERCENTAGE_PRICE\",\"requestDateTime\":null,\"requestType\":\"COMPETITION\",\"requesterFirstName\":\"Kostadin\",\"requesterLastName\":\"Terziev\",\"requesterName\":\"Kostadin Terziev\",\"requireIndicativeDocuments\":false,\"rmFullName\":\"Armin Traktor\",\"settlement\":\"PHYSICAL\",\"settlementLag\":\"5d\",\"solvingFor\":\"FEE_CO_STRUCTURING\",\"sspaCode\":1230,\"status\":\"DRAFT\",\"strikeRate\":140,\"submissionDateTime\":null,\"submitterFirstName\":\"Kostadin\",\"submitterLastName\":\"Terziev\",\"submitterName\":\"Kostadin Terziev\",\"subscriptionEndDate\":null,\"subscriptionStartDate\":null,\"sunshineId\":null,\"tenantId\":1,\"tenor\":\"2y\",\"title\":\"Autocallable BRC on Adidas AG/ Ageas in EUR, Nov 23\",\"ukRelevant\":[],\"underlyingExposure\":\"WORST_OF\",\"underlyings\":[{\"bbgTicker\":\"ADS GY\",\"type\":\"EQUITY\",\"exchangeCode\":\"GY\",\"instrumentClass\":null,\"countryCode\":\"DE\",\"currency\":\"EUR\",\"description\":\"Adidas AG\",\"shortName\":\"Adidas\",\"isin\":\"DE000A1EWWW0\",\"region\":\"Germany\",\"ric\":\"ADSGn.DE\",\"tacs\":\"ADSGn.DE\",\"securityType\":\"Share\",\"valor\":\"11730015\",\"commodityIndex\":\"False\",\"emergingMarket\":\"False\",\"subClass\":null,\"industry\":\"Textiles/Leather Goods\",\"indexReturnTypeId\":null,\"weight\":100,\"initialFixingDate\":\"2021-11-12\"},{\"bbgTicker\":\"AGS BB\",\"type\":\"EQUITY\",\"exchangeCode\":\"BB\",\"instrumentClass\":null,\"countryCode\":\"BE\",\"currency\":\"EUR\",\"description\":\"Ageas\",\"shortName\":\"Ageas\",\"isin\":\"BE0974264930\",\"region\":\"Belgium\",\"ric\":\"AGES.BR\",\"tacs\":null,\"securityType\":\"Share\",\"valor\":\"18954172\",\"commodityIndex\":\"False\",\"emergingMarket\":\"False\",\"subClass\":null,\"industry\":\"Insurances\",\"indexReturnTypeId\":null,\"weight\":100,\"initialFixingDate\":\"2021-11-12\"}],\"userId\":\"kostad20210803-122632-1\",\"variationParentId\":null,\"version\":0},\"config\":{\"elements\":[{\"type\":\"SECTION\",\"key\":\"generalTermsSection\",\"readOnly\":true,\"label\":\"General Terms\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"RADIO\",\"key\":\"requestType\",\"readOnly\":false,\"label\":\"Request Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Indication\",\"value\":\"INDICATION\",\"order\":0,\"disabled\":false},{\"label\":\"Competition\",\"value\":\"COMPETITION\",\"order\":1,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"RADIO\",\"key\":\"solvingFor\",\"readOnly\":false,\"label\":\"Solving For\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Barrier\",\"value\":\"BARRIER\",\"order\":0,\"disabled\":false},{\"label\":\"Coupon p.a.\",\"value\":\"COUPON\",\"order\":1,\"disabled\":false},{\"label\":\"Coupon Barrier\",\"value\":\"COUPON_BARRIER\",\"order\":2,\"disabled\":false},{\"label\":\"Coupon Spread p.a.\",\"value\":\"COUPON_SPREAD\",\"order\":3,\"disabled\":false},{\"label\":\"Coupon Cap p.a.\",\"value\":\"COUPON_CAP\",\"order\":4,\"disabled\":false},{\"label\":\"Coupon Floor p.a.\",\"value\":\"COUPON_FLOOR\",\"order\":5,\"disabled\":false},{\"label\":\"Early Redemption Barrier Rate\",\"value\":\"EARLY_REDEMPTION_BARRIER_RATE\",\"order\":6,\"disabled\":false},{\"label\":\"Early Redemption Exit Rate p.a.\",\"value\":\"EARLY_REDEMPTION_EXIT_RATE\",\"order\":7,\"disabled\":false},{\"label\":\"SGC Gross Fee\",\"value\":\"FEE_SGC_GROSS\",\"order\":8,\"disabled\":false},{\"label\":\"Co-Structuring Fee\",\"value\":\"FEE_CO_STRUCTURING\",\"order\":9,\"disabled\":false},{\"label\":\"Issue Price\",\"value\":\"ISSUE_PRICE_RATE\",\"order\":10,\"disabled\":false},{\"label\":\"Strike\",\"value\":\"STRIKE\",\"order\":11,\"disabled\":false},{\"label\":\"Other\",\"value\":\"OTHER\",\"order\":12,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"RADIO\",\"key\":\"distributionType\",\"readOnly\":false,\"label\":\"Distribution Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Private Placement\",\"value\":\"PRIVATE_PLACEMENT\",\"order\":0,\"disabled\":false},{\"label\":\"Subscription\",\"value\":\"SUBSCRIPTION\",\"order\":1,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"RADIO\",\"key\":\"underlyingExposure\",\"readOnly\":false,\"label\":\"Underlying Exposure\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Best Of\",\"value\":\"BEST_OF\",\"order\":0,\"disabled\":false},{\"label\":\"Worst Of\",\"value\":\"WORST_OF\",\"order\":1,\"disabled\":false},{\"label\":\"Single Underlying\",\"value\":\"SINGLE_UNDERLYING\",\"order\":2,\"disabled\":false},{\"label\":\"Basket\",\"value\":\"BASKET\",\"order\":3,\"disabled\":false}],\"triggerValidation\":true}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"tradeFeaturesSection\",\"readOnly\":true,\"label\":\"Trade Features\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"TYPE_QUERY_SEARCH\",\"key\":\"underlyings\",\"readOnly\":false,\"label\":\"Underlyings\",\"validations\":{\"required\":true,\"size\":{\"min\":2,\"max\":100}},\"options\":[{\"label\":\"Index\",\"value\":\"INDEX\",\"order\":0,\"disabled\":false},{\"label\":\"Company\",\"value\":\"COMPANY\",\"order\":1,\"disabled\":false},{\"label\":\"Fund\",\"value\":\"FUND\",\"order\":2,\"disabled\":false},{\"label\":\"Bond\",\"value\":\"BOND\",\"order\":3,\"disabled\":false}],\"dataProvider\":{\"url\":\"/api/app/rfq/underlying/lookup\",\"queryParams\":{\"query\":\"string\",\"type\":\"string\"}},\"triggerValidation\":true},{\"type\":\"OPTION\",\"key\":\"settlement\",\"readOnly\":false,\"label\":\"Settlement\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Cash\",\"value\":\"CASH\",\"order\":0,\"disabled\":false},{\"label\":\"Physical\",\"value\":\"PHYSICAL\",\"order\":1,\"disabled\":false},{\"label\":\"Cash or Physical\",\"value\":\"CASH_PHYSICAL\",\"order\":2,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"OPTION\",\"key\":\"currency\",\"readOnly\":false,\"label\":\"Settlement Currency\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"USD\",\"value\":\"USD\",\"order\":0,\"disabled\":false},{\"label\":\"CHF\",\"value\":\"CHF\",\"order\":1,\"disabled\":false},{\"label\":\"EUR\",\"value\":\"EUR\",\"order\":2,\"disabled\":false},{\"label\":\"AED\",\"value\":\"AED\",\"order\":3,\"disabled\":false},{\"label\":\"AFN\",\"value\":\"AFN\",\"order\":4,\"disabled\":false},{\"label\":\"ALL\",\"value\":\"ALL\",\"order\":5,\"disabled\":false},{\"label\":\"AMD\",\"value\":\"AMD\",\"order\":6,\"disabled\":false},{\"label\":\"ANG\",\"value\":\"ANG\",\"order\":7,\"disabled\":false},{\"label\":\"AOA\",\"value\":\"AOA\",\"order\":8,\"disabled\":false},{\"label\":\"ARS\",\"value\":\"ARS\",\"order\":9,\"disabled\":false},{\"label\":\"AUD\",\"value\":\"AUD\",\"order\":10,\"disabled\":false},{\"label\":\"AWG\",\"value\":\"AWG\",\"order\":11,\"disabled\":false},{\"label\":\"AZN\",\"value\":\"AZN\",\"order\":12,\"disabled\":false},{\"label\":\"BAM\",\"value\":\"BAM\",\"order\":13,\"disabled\":false},{\"label\":\"BBD\",\"value\":\"BBD\",\"order\":14,\"disabled\":false},{\"label\":\"BDT\",\"value\":\"BDT\",\"order\":15,\"disabled\":false},{\"label\":\"BGN\",\"value\":\"BGN\",\"order\":16,\"disabled\":false},{\"label\":\"BHD\",\"value\":\"BHD\",\"order\":17,\"disabled\":false},{\"label\":\"BIF\",\"value\":\"BIF\",\"order\":18,\"disabled\":false},{\"label\":\"BMD\",\"value\":\"BMD\",\"order\":19,\"disabled\":false},{\"label\":\"BND\",\"value\":\"BND\",\"order\":20,\"disabled\":false},{\"label\":\"BOB\",\"value\":\"BOB\",\"order\":21,\"disabled\":false},{\"label\":\"BOV\",\"value\":\"BOV\",\"order\":22,\"disabled\":false},{\"label\":\"BRL\",\"value\":\"BRL\",\"order\":23,\"disabled\":false},{\"label\":\"BSD\",\"value\":\"BSD\",\"order\":24,\"disabled\":false},{\"label\":\"BTN\",\"value\":\"BTN\",\"order\":25,\"disabled\":false},{\"label\":\"BWP\",\"value\":\"BWP\",\"order\":26,\"disabled\":false},{\"label\":\"BYN\",\"value\":\"BYN\",\"order\":27,\"disabled\":false},{\"label\":\"BYR\",\"value\":\"BYR\",\"order\":28,\"disabled\":false},{\"label\":\"BZD\",\"value\":\"BZD\",\"order\":29,\"disabled\":false},{\"label\":\"CAD\",\"value\":\"CAD\",\"order\":30,\"disabled\":false},{\"label\":\"CDF\",\"value\":\"CDF\",\"order\":31,\"disabled\":false},{\"label\":\"CHE\",\"value\":\"CHE\",\"order\":32,\"disabled\":false},{\"label\":\"CHW\",\"value\":\"CHW\",\"order\":33,\"disabled\":false},{\"label\":\"CLF\",\"value\":\"CLF\",\"order\":34,\"disabled\":false},{\"label\":\"CLP\",\"value\":\"CLP\",\"order\":35,\"disabled\":false},{\"label\":\"CNH\",\"value\":\"CNH\",\"order\":36,\"disabled\":false},{\"label\":\"CNY\",\"value\":\"CNY\",\"order\":37,\"disabled\":false},{\"label\":\"COP\",\"value\":\"COP\",\"order\":38,\"disabled\":false},{\"label\":\"COU\",\"value\":\"COU\",\"order\":39,\"disabled\":false},{\"label\":\"CRC\",\"value\":\"CRC\",\"order\":40,\"disabled\":false},{\"label\":\"CUC\",\"value\":\"CUC\",\"order\":41,\"disabled\":false},{\"label\":\"CUP\",\"value\":\"CUP\",\"order\":42,\"disabled\":false},{\"label\":\"CVE\",\"value\":\"CVE\",\"order\":43,\"disabled\":false},{\"label\":\"CZK\",\"value\":\"CZK\",\"order\":44,\"disabled\":false},{\"label\":\"DJF\",\"value\":\"DJF\",\"order\":45,\"disabled\":false},{\"label\":\"DKK\",\"value\":\"DKK\",\"order\":46,\"disabled\":false},{\"label\":\"DOP\",\"value\":\"DOP\",\"order\":47,\"disabled\":false},{\"label\":\"DZD\",\"value\":\"DZD\",\"order\":48,\"disabled\":false},{\"label\":\"EEK\",\"value\":\"EEK\",\"order\":49,\"disabled\":false},{\"label\":\"EGP\",\"value\":\"EGP\",\"order\":50,\"disabled\":false},{\"label\":\"ERN\",\"value\":\"ERN\",\"order\":51,\"disabled\":false},{\"label\":\"ETB\",\"value\":\"ETB\",\"order\":52,\"disabled\":false},{\"label\":\"FJD\",\"value\":\"FJD\",\"order\":53,\"disabled\":false},{\"label\":\"FKP\",\"value\":\"FKP\",\"order\":54,\"disabled\":false},{\"label\":\"GBP\",\"value\":\"GBP\",\"order\":55,\"disabled\":false},{\"label\":\"GEL\",\"value\":\"GEL\",\"order\":56,\"disabled\":false},{\"label\":\"GHS\",\"value\":\"GHS\",\"order\":57,\"disabled\":false},{\"label\":\"GIP\",\"value\":\"GIP\",\"order\":58,\"disabled\":false},{\"label\":\"GMD\",\"value\":\"GMD\",\"order\":59,\"disabled\":false},{\"label\":\"GNF\",\"value\":\"GNF\",\"order\":60,\"disabled\":false},{\"label\":\"GTQ\",\"value\":\"GTQ\",\"order\":61,\"disabled\":false},{\"label\":\"GWP\",\"value\":\"GWP\",\"order\":62,\"disabled\":false},{\"label\":\"GYD\",\"value\":\"GYD\",\"order\":63,\"disabled\":false},{\"label\":\"HKD\",\"value\":\"HKD\",\"order\":64,\"disabled\":false},{\"label\":\"HNL\",\"value\":\"HNL\",\"order\":65,\"disabled\":false},{\"label\":\"HRK\",\"value\":\"HRK\",\"order\":66,\"disabled\":false},{\"label\":\"HTG\",\"value\":\"HTG\",\"order\":67,\"disabled\":false},{\"label\":\"HUF\",\"value\":\"HUF\",\"order\":68,\"disabled\":false},{\"label\":\"IDR\",\"value\":\"IDR\",\"order\":69,\"disabled\":false},{\"label\":\"ILS\",\"value\":\"ILS\",\"order\":70,\"disabled\":false},{\"label\":\"INR\",\"value\":\"INR\",\"order\":71,\"disabled\":false},{\"label\":\"IQD\",\"value\":\"IQD\",\"order\":72,\"disabled\":false},{\"label\":\"IRR\",\"value\":\"IRR\",\"order\":73,\"disabled\":false},{\"label\":\"ISK\",\"value\":\"ISK\",\"order\":74,\"disabled\":false},{\"label\":\"JMD\",\"value\":\"JMD\",\"order\":75,\"disabled\":false},{\"label\":\"JOD\",\"value\":\"JOD\",\"order\":76,\"disabled\":false},{\"label\":\"JPY\",\"value\":\"JPY\",\"order\":77,\"disabled\":false},{\"label\":\"KES\",\"value\":\"KES\",\"order\":78,\"disabled\":false},{\"label\":\"KGS\",\"value\":\"KGS\",\"order\":79,\"disabled\":false},{\"label\":\"KHR\",\"value\":\"KHR\",\"order\":80,\"disabled\":false},{\"label\":\"KMF\",\"value\":\"KMF\",\"order\":81,\"disabled\":false},{\"label\":\"KPW\",\"value\":\"KPW\",\"order\":82,\"disabled\":false},{\"label\":\"KRW\",\"value\":\"KRW\",\"order\":83,\"disabled\":false},{\"label\":\"KWD\",\"value\":\"KWD\",\"order\":84,\"disabled\":false},{\"label\":\"KYD\",\"value\":\"KYD\",\"order\":85,\"disabled\":false},{\"label\":\"KZT\",\"value\":\"KZT\",\"order\":86,\"disabled\":false},{\"label\":\"LAK\",\"value\":\"LAK\",\"order\":87,\"disabled\":false},{\"label\":\"LBP\",\"value\":\"LBP\",\"order\":88,\"disabled\":false},{\"label\":\"LKR\",\"value\":\"LKR\",\"order\":89,\"disabled\":false},{\"label\":\"LRD\",\"value\":\"LRD\",\"order\":90,\"disabled\":false},{\"label\":\"LSL\",\"value\":\"LSL\",\"order\":91,\"disabled\":false},{\"label\":\"LTL\",\"value\":\"LTL\",\"order\":92,\"disabled\":false},{\"label\":\"LVL\",\"value\":\"LVL\",\"order\":93,\"disabled\":false},{\"label\":\"LYD\",\"value\":\"LYD\",\"order\":94,\"disabled\":false},{\"label\":\"MAD\",\"value\":\"MAD\",\"order\":95,\"disabled\":false},{\"label\":\"MDL\",\"value\":\"MDL\",\"order\":96,\"disabled\":false},{\"label\":\"MGA\",\"value\":\"MGA\",\"order\":97,\"disabled\":false},{\"label\":\"MKD\",\"value\":\"MKD\",\"order\":98,\"disabled\":false},{\"label\":\"MMK\",\"value\":\"MMK\",\"order\":99,\"disabled\":false},{\"label\":\"MNT\",\"value\":\"MNT\",\"order\":100,\"disabled\":false},{\"label\":\"MOP\",\"value\":\"MOP\",\"order\":101,\"disabled\":false},{\"label\":\"MRO\",\"value\":\"MRO\",\"order\":102,\"disabled\":false},{\"label\":\"MUR\",\"value\":\"MUR\",\"order\":103,\"disabled\":false},{\"label\":\"MVR\",\"value\":\"MVR\",\"order\":104,\"disabled\":false},{\"label\":\"MWK\",\"value\":\"MWK\",\"order\":105,\"disabled\":false},{\"label\":\"MXN\",\"value\":\"MXN\",\"order\":106,\"disabled\":false},{\"label\":\"MXV\",\"value\":\"MXV\",\"order\":107,\"disabled\":false},{\"label\":\"MYR\",\"value\":\"MYR\",\"order\":108,\"disabled\":false},{\"label\":\"MZN\",\"value\":\"MZN\",\"order\":109,\"disabled\":false},{\"label\":\"NAD\",\"value\":\"NAD\",\"order\":110,\"disabled\":false},{\"label\":\"NGN\",\"value\":\"NGN\",\"order\":111,\"disabled\":false},{\"label\":\"NIO\",\"value\":\"NIO\",\"order\":112,\"disabled\":false},{\"label\":\"NOK\",\"value\":\"NOK\",\"order\":113,\"disabled\":false},{\"label\":\"NPR\",\"value\":\"NPR\",\"order\":114,\"disabled\":false},{\"label\":\"NZD\",\"value\":\"NZD\",\"order\":115,\"disabled\":false},{\"label\":\"OMR\",\"value\":\"OMR\",\"order\":116,\"disabled\":false},{\"label\":\"PAB\",\"value\":\"PAB\",\"order\":117,\"disabled\":false},{\"label\":\"PEN\",\"value\":\"PEN\",\"order\":118,\"disabled\":false},{\"label\":\"PGK\",\"value\":\"PGK\",\"order\":119,\"disabled\":false},{\"label\":\"PHP\",\"value\":\"PHP\",\"order\":120,\"disabled\":false},{\"label\":\"PKR\",\"value\":\"PKR\",\"order\":121,\"disabled\":false},{\"label\":\"PLN\",\"value\":\"PLN\",\"order\":122,\"disabled\":false},{\"label\":\"PYG\",\"value\":\"PYG\",\"order\":123,\"disabled\":false},{\"label\":\"QAR\",\"value\":\"QAR\",\"order\":124,\"disabled\":false},{\"label\":\"RON\",\"value\":\"RON\",\"order\":125,\"disabled\":false},{\"label\":\"RSD\",\"value\":\"RSD\",\"order\":126,\"disabled\":false},{\"label\":\"RUB\",\"value\":\"RUB\",\"order\":127,\"disabled\":false},{\"label\":\"RWF\",\"value\":\"RWF\",\"order\":128,\"disabled\":false},{\"label\":\"SAR\",\"value\":\"SAR\",\"order\":129,\"disabled\":false},{\"label\":\"SBD\",\"value\":\"SBD\",\"order\":130,\"disabled\":false},{\"label\":\"SCR\",\"value\":\"SCR\",\"order\":131,\"disabled\":false},{\"label\":\"SDG\",\"value\":\"SDG\",\"order\":132,\"disabled\":false},{\"label\":\"SEK\",\"value\":\"SEK\",\"order\":133,\"disabled\":false},{\"label\":\"SGD\",\"value\":\"SGD\",\"order\":134,\"disabled\":false},{\"label\":\"SHP\",\"value\":\"SHP\",\"order\":135,\"disabled\":false},{\"label\":\"SLL\",\"value\":\"SLL\",\"order\":136,\"disabled\":false},{\"label\":\"SOS\",\"value\":\"SOS\",\"order\":137,\"disabled\":false},{\"label\":\"SRD\",\"value\":\"SRD\",\"order\":138,\"disabled\":false},{\"label\":\"SSP\",\"value\":\"SSP\",\"order\":139,\"disabled\":false},{\"label\":\"STD\",\"value\":\"STD\",\"order\":140,\"disabled\":false},{\"label\":\"SVC\",\"value\":\"SVC\",\"order\":141,\"disabled\":false},{\"label\":\"SYP\",\"value\":\"SYP\",\"order\":142,\"disabled\":false},{\"label\":\"SZL\",\"value\":\"SZL\",\"order\":143,\"disabled\":false},{\"label\":\"THB\",\"value\":\"THB\",\"order\":144,\"disabled\":false},{\"label\":\"TJS\",\"value\":\"TJS\",\"order\":145,\"disabled\":false},{\"label\":\"TMT\",\"value\":\"TMT\",\"order\":146,\"disabled\":false},{\"label\":\"TND\",\"value\":\"TND\",\"order\":147,\"disabled\":false},{\"label\":\"TOP\",\"value\":\"TOP\",\"order\":148,\"disabled\":false},{\"label\":\"TRY\",\"value\":\"TRY\",\"order\":149,\"disabled\":false},{\"label\":\"TTD\",\"value\":\"TTD\",\"order\":150,\"disabled\":false},{\"label\":\"TWD\",\"value\":\"TWD\",\"order\":151,\"disabled\":false},{\"label\":\"TZS\",\"value\":\"TZS\",\"order\":152,\"disabled\":false},{\"label\":\"UAH\",\"value\":\"UAH\",\"order\":153,\"disabled\":false},{\"label\":\"UGX\",\"value\":\"UGX\",\"order\":154,\"disabled\":false},{\"label\":\"USN\",\"value\":\"USN\",\"order\":155,\"disabled\":false},{\"label\":\"USS\",\"value\":\"USS\",\"order\":156,\"disabled\":false},{\"label\":\"UYI\",\"value\":\"UYI\",\"order\":157,\"disabled\":false},{\"label\":\"UYU\",\"value\":\"UYU\",\"order\":158,\"disabled\":false},{\"label\":\"UZS\",\"value\":\"UZS\",\"order\":159,\"disabled\":false},{\"label\":\"VEF\",\"value\":\"VEF\",\"order\":160,\"disabled\":false},{\"label\":\"VND\",\"value\":\"VND\",\"order\":161,\"disabled\":false},{\"label\":\"VUV\",\"value\":\"VUV\",\"order\":162,\"disabled\":false},{\"label\":\"WST\",\"value\":\"WST\",\"order\":163,\"disabled\":false},{\"label\":\"XAF\",\"value\":\"XAF\",\"order\":164,\"disabled\":false},{\"label\":\"XAG\",\"value\":\"XAG\",\"order\":165,\"disabled\":false},{\"label\":\"XAU\",\"value\":\"XAU\",\"order\":166,\"disabled\":false},{\"label\":\"XBA\",\"value\":\"XBA\",\"order\":167,\"disabled\":false},{\"label\":\"XBB\",\"value\":\"XBB\",\"order\":168,\"disabled\":false},{\"label\":\"XBC\",\"value\":\"XBC\",\"order\":169,\"disabled\":false},{\"label\":\"XBD\",\"value\":\"XBD\",\"order\":170,\"disabled\":false},{\"label\":\"XCD\",\"value\":\"XCD\",\"order\":171,\"disabled\":false},{\"label\":\"XDR\",\"value\":\"XDR\",\"order\":172,\"disabled\":false},{\"label\":\"XFU\",\"value\":\"XFU\",\"order\":173,\"disabled\":false},{\"label\":\"XOF\",\"value\":\"XOF\",\"order\":174,\"disabled\":false},{\"label\":\"XPD\",\"value\":\"XPD\",\"order\":175,\"disabled\":false},{\"label\":\"XPF\",\"value\":\"XPF\",\"order\":176,\"disabled\":false},{\"label\":\"XPT\",\"value\":\"XPT\",\"order\":177,\"disabled\":false},{\"label\":\"XSU\",\"value\":\"XSU\",\"order\":178,\"disabled\":false},{\"label\":\"XUA\",\"value\":\"XUA\",\"order\":179,\"disabled\":false},{\"label\":\"YER\",\"value\":\"YER\",\"order\":180,\"disabled\":false},{\"label\":\"ZAR\",\"value\":\"ZAR\",\"order\":181,\"disabled\":false},{\"label\":\"ZMK\",\"value\":\"ZMK\",\"order\":182,\"disabled\":false},{\"label\":\"ZMW\",\"value\":\"ZMW\",\"order\":183,\"disabled\":false},{\"label\":\"ZWL\",\"value\":\"ZWL\",\"order\":184,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"PRECISION_NUMBER_SIX\",\"key\":\"notional\",\"readOnly\":false,\"label\":\"Notional\",\"validations\":{\"required\":true,\"max\":9.999999999999998E9,\"min\":0},\"triggerValidation\":false},{\"type\":\"BOOL_OPTION\",\"key\":\"quanto\",\"readOnly\":true,\"label\":\"Quanto\",\"triggerValidation\":false},{\"type\":\"DATA_LIST\",\"key\":\"tenor\",\"readOnly\":false,\"label\":\"Tenor\",\"validations\":{\"required\":true,\"pattern\":\"(^([0-9]{1,3})([dwmy])$)|(^([0-9]{1,3}\\\\.[0-9]{1,2})([y])$)\"},\"options\":[{\"label\":\"6m\",\"value\":\"6m\",\"order\":0,\"disabled\":false},{\"label\":\"9m\",\"value\":\"9m\",\"order\":1,\"disabled\":false},{\"label\":\"1y\",\"value\":\"1y\",\"order\":2,\"disabled\":false},{\"label\":\"2y\",\"value\":\"2y\",\"order\":3,\"disabled\":false},{\"label\":\"3y\",\"value\":\"3y\",\"order\":4,\"disabled\":false}],\"triggerValidation\":true}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"issueDetailsSection\",\"readOnly\":true,\"label\":\"Issue Details\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"DATE\",\"key\":\"initialFixingDate\",\"readOnly\":false,\"label\":\"Initial Fixing Date\",\"validations\":{\"required\":true},\"triggerValidation\":true},{\"type\":\"DATE\",\"key\":\"issueDate\",\"readOnly\":false,\"label\":\"Issue Date\",\"validations\":{\"required\":true},\"triggerValidation\":true},{\"type\":\"DATA_LIST\",\"key\":\"settlementLag\",\"readOnly\":false,\"label\":\"Settlement Lag\",\"validations\":{\"required\":true,\"pattern\":\"^[1-9][0-9]{0,2}[dwmy]$\"},\"options\":[{\"label\":\"5d\",\"value\":\"5d\",\"order\":0,\"disabled\":false},{\"label\":\"10d\",\"value\":\"10d\",\"order\":1,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"DATE\",\"key\":\"finalFixingDate\",\"readOnly\":false,\"label\":\"Final Fixing Date\",\"validations\":{\"required\":true},\"triggerValidation\":true},{\"type\":\"DATE\",\"key\":\"finalRepaymentDate\",\"readOnly\":false,\"label\":\"Final Repayment Date\",\"validations\":{\"required\":true},\"triggerValidation\":false},{\"type\":\"OPTION\",\"key\":\"fixingType\",\"readOnly\":false,\"label\":\"Fixing Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Closing\",\"value\":\"CLOSING\",\"order\":0,\"disabled\":false},{\"label\":\"Live Strike\",\"value\":\"LIVE_STRIKE\",\"order\":1,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"OPTION\",\"key\":\"quotationType\",\"readOnly\":false,\"label\":\"Quotation Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Units\",\"value\":\"UNIT_PRICE\",\"order\":0,\"disabled\":false},{\"label\":\"Percentage\",\"value\":\"PERCENTAGE_PRICE\",\"order\":1,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"issuePriceRate\",\"readOnly\":false,\"label\":\"Issue Price\",\"validations\":{\"required\":true,\"positive\":true,\"max\":100000000,\"min\":0},\"triggerValidation\":false},{\"type\":\"PRECISION_NUMBER_SIX\",\"key\":\"denomination\",\"readOnly\":false,\"label\":\"Denomination\",\"validations\":{\"required\":true,\"max\":100000000,\"min\":0},\"triggerValidation\":false}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"earlyRedemptionFeaturesSection\",\"readOnly\":true,\"label\":\"Early Redemption Features\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"OPTION\",\"key\":\"earlyRedemptionObservationFrequency\",\"readOnly\":false,\"label\":\"Obs. Frequency\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Daily\",\"value\":\"DAILY\",\"order\":0,\"disabled\":false},{\"label\":\"Weekly\",\"value\":\"WEEKLY\",\"order\":1,\"disabled\":false},{\"label\":\"Monthly\",\"value\":\"MONTHLY\",\"order\":2,\"disabled\":false},{\"label\":\"Bi-Monthly\",\"value\":\"BI_MONTHLY\",\"order\":3,\"disabled\":false},{\"label\":\"Quarterly\",\"value\":\"QUARTERLY\",\"order\":4,\"disabled\":false},{\"label\":\"Semi-annually\",\"value\":\"SEMI_ANNUALLY\",\"order\":5,\"disabled\":false},{\"label\":\"Annually\",\"value\":\"ANNUALLY\",\"order\":6,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"DATA_LIST\",\"key\":\"earlyRedemptionFirstObservationTenor\",\"readOnly\":false,\"label\":\"First Obs. Tenor\",\"validations\":{\"required\":true,\"pattern\":\"^[1-9][0-9]{0,2}[dwmy]$\"},\"options\":[{\"label\":\"1d\",\"value\":\"1d\",\"order\":0,\"disabled\":false},{\"label\":\"1w\",\"value\":\"1w\",\"order\":1,\"disabled\":false},{\"label\":\"1m\",\"value\":\"1m\",\"order\":2,\"disabled\":false},{\"label\":\"2m\",\"value\":\"2m\",\"order\":3,\"disabled\":false},{\"label\":\"3m\",\"value\":\"3m\",\"order\":4,\"disabled\":false},{\"label\":\"6m\",\"value\":\"6m\",\"order\":5,\"disabled\":false},{\"label\":\"1y\",\"value\":\"1y\",\"order\":6,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"OPTION\",\"key\":\"earlyRedemptionBarrierObservationType\",\"readOnly\":false,\"label\":\"Barrier Obs. Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Single Underlying\",\"value\":\"SINGLE_UNDERLYING\",\"order\":0,\"disabled\":true},{\"label\":\"Worst Of\",\"value\":\"WORST_OF\",\"order\":1,\"disabled\":false},{\"label\":\"Best Of\",\"value\":\"BEST_OF\",\"order\":2,\"disabled\":false},{\"label\":\"Basket\",\"value\":\"BASKET\",\"order\":3,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"earlyRedemptionBarrierRate\",\"readOnly\":false,\"label\":\"Trigger Barrier\",\"validations\":{\"required\":true,\"positive\":true,\"max\":100000000,\"min\":0},\"triggerValidation\":false},{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"earlyRedemptionStep\",\"readOnly\":false,\"label\":\"Step Up/Down\",\"validations\":{\"required\":false,\"max\":100,\"min\":-100},\"triggerValidation\":false},{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"earlyRedemptionExitRate\",\"readOnly\":false,\"label\":\"Exit Rate p.a.\",\"validations\":{\"required\":false,\"max\":100000000,\"min\":0},\"triggerValidation\":false}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"barrierSection\",\"readOnly\":true,\"label\":\"Barrier\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"barrierLevel1\",\"readOnly\":false,\"label\":\"Barrier\",\"validations\":{\"required\":true,\"positive\":true,\"max\":100000000,\"min\":0},\"triggerValidation\":false},{\"type\":\"OPTION\",\"key\":\"barrierObsType\",\"readOnly\":false,\"label\":\"Obs. Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Single Underlying\",\"value\":\"SINGLE_UNDERLYING\",\"order\":0,\"disabled\":true},{\"label\":\"Worst Of\",\"value\":\"WORST_OF\",\"order\":1,\"disabled\":false},{\"label\":\"Best Of\",\"value\":\"BEST_OF\",\"order\":2,\"disabled\":false},{\"label\":\"Basket\",\"value\":\"BASKET\",\"order\":3,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"OPTION\",\"key\":\"barrierObsFrequency\",\"readOnly\":false,\"label\":\"Obs. Frequency\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Daily\",\"value\":\"DAILY\",\"order\":0,\"disabled\":false},{\"label\":\"Bermudan\",\"value\":\"BERMUDAN\",\"order\":1,\"disabled\":false},{\"label\":\"European\",\"value\":\"EUROPEAN\",\"order\":2,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"OPTION\",\"key\":\"barrierObsStyle\",\"readOnly\":false,\"label\":\"Obs. Style\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Closing\",\"value\":\"CLOSING\",\"order\":0,\"disabled\":false},{\"label\":\"Continuous\",\"value\":\"CONTINUOUS\",\"order\":1,\"disabled\":false}],\"triggerValidation\":true}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"strikeSection\",\"readOnly\":true,\"label\":\"Strike\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"strikeRate\",\"readOnly\":false,\"label\":\"Strike\",\"validations\":{\"required\":true,\"positive\":true,\"max\":100000000,\"min\":0},\"triggerValidation\":false}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"couponSection\",\"readOnly\":true,\"label\":\"Coupon\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"OPTION\",\"key\":\"couponType\",\"readOnly\":false,\"label\":\"Coupon Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Fixed\",\"value\":\"FIXED\",\"order\":0,\"disabled\":false},{\"label\":\"Float\",\"value\":\"FLOAT\",\"order\":1,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"OPTION\",\"key\":\"couponFrequency\",\"readOnly\":false,\"label\":\"Coupon Frequency\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Monthly\",\"value\":\"MONTHLY\",\"order\":0,\"disabled\":false},{\"label\":\"Bi-Monthly\",\"value\":\"BI_MONTHLY\",\"order\":1,\"disabled\":false},{\"label\":\"Quarterly\",\"value\":\"QUARTERLY\",\"order\":2,\"disabled\":false},{\"label\":\"Semi-annually\",\"value\":\"SEMI_ANNUALLY\",\"order\":3,\"disabled\":false},{\"label\":\"Annually\",\"value\":\"ANNUALLY\",\"order\":4,\"disabled\":false},{\"label\":\"Bullet\",\"value\":\"BULLET\",\"order\":5,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"coupon\",\"readOnly\":false,\"label\":\"Coupon p.a.\",\"validations\":{\"required\":true,\"positive\":true,\"max\":100000000,\"min\":0},\"triggerValidation\":false},{\"type\":\"BOOL_OPTION\",\"key\":\"conditionalCoupon\",\"readOnly\":false,\"label\":\"Conditional Coupon\",\"validations\":{\"required\":true},\"triggerValidation\":true}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"feesSection\",\"readOnly\":true,\"label\":\"Fees\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"TABLE\",\"key\":\"fees\",\"readOnly\":false,\"label\":\"Fees\",\"triggerValidation\":true,\"hidden\":false,\"columnFields\":[{\"type\":\"OPTION\",\"key\":\"type\",\"readOnly\":true,\"label\":\"Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Co-Structuring Fee\",\"value\":\"CO_STRUCTURING_FEE\",\"order\":0,\"disabled\":false},{\"label\":\"SGC net\",\"value\":\"SGC_NET\",\"order\":1,\"disabled\":false},{\"label\":\"SGC gross\",\"value\":\"SGC_GROSS\",\"order\":2,\"disabled\":false},{\"label\":\"Subscription Fee\",\"value\":\"SUBSCRIPTION_FEE\",\"order\":3,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"amount\",\"readOnly\":true,\"label\":\"Amount\",\"validations\":{\"required\":false,\"max\":100000000,\"min\":0},\"triggerValidation\":false},{\"type\":\"DATE\",\"key\":\"paymentDate\",\"readOnly\":false,\"label\":\"Payment Date\",\"validations\":{\"required\":true},\"triggerValidation\":false},{\"type\":\"OPTION\",\"key\":\"status\",\"readOnly\":false,\"label\":\"Status\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Indicative\",\"value\":\"INDICATIVE\",\"order\":0,\"disabled\":false},{\"label\":\"Fixed\",\"value\":\"FIXED\",\"order\":1,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"OPTION\",\"key\":\"calculationType\",\"readOnly\":false,\"label\":\"Calculation Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"% of notional\",\"value\":\"NOTIONAL_PERCENTAGE\",\"order\":0,\"disabled\":false},{\"label\":\"% of issue price\",\"value\":\"ISSUE_PRICE_PERCENTAGE\",\"order\":1,\"disabled\":false},{\"label\":\"% of NAV\",\"value\":\"NAV_PERCENTAGE\",\"order\":2,\"disabled\":false}],\"triggerValidation\":false}],\"actions\":[\"ADD_ROW\"],\"rows\":{\"1\":{\"type\":\"TABLE_ROW\",\"key\":\"fees.1\",\"readOnly\":false,\"label\":\"fees.1\",\"triggerValidation\":true,\"hidden\":false,\"columnFields\":[{\"type\":\"OPTION\",\"key\":\"type\",\"readOnly\":true,\"label\":\"Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Co-Structuring Fee\",\"value\":\"CO_STRUCTURING_FEE\",\"order\":0,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"PRECISION_PERCENTAGE_SIX\",\"key\":\"amount\",\"readOnly\":true,\"label\":\"Amount\",\"validations\":{\"required\":false,\"max\":100000000,\"min\":0},\"triggerValidation\":false},{\"type\":\"DATE\",\"key\":\"paymentDate\",\"readOnly\":false,\"label\":\"Payment Date\",\"validations\":{\"required\":true},\"triggerValidation\":true},{\"type\":\"OPTION\",\"key\":\"status\",\"readOnly\":false,\"label\":\"Status\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Indicative\",\"value\":\"INDICATIVE\",\"order\":0,\"disabled\":false},{\"label\":\"Fixed\",\"value\":\"FIXED\",\"order\":1,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"OPTION\",\"key\":\"calculationType\",\"readOnly\":false,\"label\":\"Calculation Type\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"% of notional\",\"value\":\"NOTIONAL_PERCENTAGE\",\"order\":0,\"disabled\":false},{\"label\":\"% of issue price\",\"value\":\"ISSUE_PRICE_PERCENTAGE\",\"order\":1,\"disabled\":false},{\"label\":\"% of NAV\",\"value\":\"NAV_PERCENTAGE\",\"order\":2,\"disabled\":false}],\"triggerValidation\":true}],\"actions\":[]}}}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"quoteRequestSection\",\"readOnly\":true,\"label\":\"Quote Request\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"CHECKBOX_GROUP_GRID\",\"key\":\"connectedProviderTenantIds\",\"readOnly\":false,\"label\":\"Connected Providers\",\"validations\":{\"required\":false,\"size\":{\"min\":0}},\"options\":[{\"label\":\"CSIB\",\"value\":2,\"order\":0,\"disabled\":false},{\"label\":\"BNP\",\"value\":3,\"order\":1,\"disabled\":false},{\"label\":\"JP Morgan\",\"value\":4,\"order\":2,\"disabled\":false},{\"label\":\"Soci\u00E9t\u00E9 G\u00E9n\u00E9rale\",\"value\":5,\"order\":3,\"disabled\":false},{\"label\":\"Goldman Sachs\",\"value\":6,\"order\":4,\"disabled\":false},{\"label\":\"HSBC\",\"value\":7,\"order\":5,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"CHECKBOX_GROUP_GRID\",\"key\":\"nonConnectedProviderTenantIds\",\"readOnly\":false,\"label\":\"Other Providers\",\"validations\":{\"required\":false,\"size\":{\"min\":0}},\"options\":[{\"label\":\"Standard Chartered (NCP)\",\"value\":110,\"order\":0,\"disabled\":false}],\"triggerValidation\":true},{\"type\":\"DATETIME\",\"key\":\"deadline\",\"readOnly\":false,\"label\":\"Deadline\",\"validations\":{\"required\":true,\"future\":true},\"triggerValidation\":false},{\"type\":\"CHECKBOX_GROUP\",\"key\":\"ukRelevant\",\"readOnly\":false,\"label\":\"UK Relevant\",\"validations\":{\"required\":false,\"size\":{\"min\":0}},\"options\":[{\"label\":\"RnD Compliant Issuer\",\"value\":\"rndCompliantIssuer\",\"order\":0,\"disabled\":false},{\"label\":\"EIS Wrapper\",\"value\":\"eisWrapper\",\"order\":1,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"AUTOCOMPLETE\",\"key\":\"initiative\",\"readOnly\":false,\"label\":\"Initiatives\",\"autocompleteEndpoint\":\"/api/app/rfq/lookup/initiatives\",\"validations\":{\"required\":false},\"triggerValidation\":false},{\"type\":\"RICH_TEXTAREA\",\"key\":\"providerNote\",\"readOnly\":false,\"label\":\"Note to Providers\",\"validations\":{\"required\":false},\"triggerValidation\":false}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"documentsSection\",\"readOnly\":true,\"label\":\"Documents\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"TABLE\",\"key\":\"documentRequisites\",\"readOnly\":false,\"label\":\"Documents\",\"validations\":{\"uniqueKeys\":[\"type\"]},\"triggerValidation\":true,\"hidden\":false,\"columnFields\":[{\"type\":\"OPTION\",\"key\":\"type\",\"readOnly\":false,\"label\":\"Doc. Type\",\"validations\":{},\"options\":[{\"label\":\"KID\",\"value\":\"KID\",\"order\":0,\"disabled\":false},{\"label\":\"Termsheet\",\"value\":\"TERMSHEET\",\"order\":1,\"disabled\":false},{\"label\":\"BIB\",\"value\":\"BIB\",\"order\":2,\"disabled\":false},{\"label\":\"MifidTargetMarketDocument\",\"value\":\"TARGET_MARKET_DOCUMENT\",\"order\":3,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"CHECKBOX\",\"key\":\"isEnglishLanguage\",\"readOnly\":false,\"label\":\"English\",\"triggerValidation\":false},{\"type\":\"CHECKBOX\",\"key\":\"isGermanLanguage\",\"readOnly\":false,\"label\":\"German\",\"triggerValidation\":false},{\"type\":\"CHECKBOX\",\"key\":\"isFrenchLanguage\",\"readOnly\":false,\"label\":\"French\",\"triggerValidation\":false},{\"type\":\"CHECKBOX\",\"key\":\"isSpanishLanguage\",\"readOnly\":false,\"label\":\"Spanish\",\"triggerValidation\":false},{\"type\":\"CHECKBOX\",\"key\":\"isRussianLanguage\",\"readOnly\":false,\"label\":\"Russian\",\"triggerValidation\":false},{\"type\":\"CHECKBOX\",\"key\":\"isItalianLanguage\",\"readOnly\":false,\"label\":\"Italian\",\"triggerValidation\":false}],\"actions\":[\"ADD_ROW\",\"REMOVE_ROW\"],\"rows\":{}},{\"type\":\"CHECKBOX\",\"key\":\"requireIndicativeDocuments\",\"readOnly\":false,\"label\":\"Require Indicative Documents\",\"validations\":{\"required\":false},\"triggerValidation\":false}],\"triggerValidation\":false},{\"type\":\"SECTION\",\"key\":\"internalSection\",\"readOnly\":true,\"label\":\"Internal\",\"validations\":{\"required\":true},\"elements\":[{\"type\":\"OPTION\",\"key\":\"internalAssetClass\",\"readOnly\":false,\"label\":\"Asset Class\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"Equity\",\"value\":\"EQUITY\",\"order\":0,\"disabled\":false},{\"label\":\"Fixed Income\",\"value\":\"FIXED_INCOME\",\"order\":1,\"disabled\":false},{\"label\":\"FX\",\"value\":\"FX\",\"order\":2,\"disabled\":false},{\"label\":\"Commodity\",\"value\":\"COMMODITY\",\"order\":3,\"disabled\":false},{\"label\":\"Funds\",\"value\":\"FUNDS\",\"order\":4,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"AUTOCOMPLETE\",\"key\":\"rmFullName\",\"readOnly\":false,\"label\":\"RM Full Name\",\"autocompleteEndpoint\":\"/api/app/rfq/lookup/rmFullNames\",\"validations\":{\"required\":true},\"triggerValidation\":false},{\"type\":\"OPTION\",\"key\":\"internalRmBusinessArea\",\"readOnly\":false,\"label\":\"RM Business Area\",\"validations\":{\"required\":true},\"options\":[{\"label\":\"APAC ZH\",\"value\":\"APAC_ZH\",\"order\":0,\"disabled\":false},{\"label\":\"IWM Brazil\",\"value\":\"IWM_BRAZIL\",\"order\":1,\"disabled\":false},{\"label\":\"IWM Emerging Europe\",\"value\":\"IWM_EMERGING_EUROPE\",\"order\":2,\"disabled\":false},{\"label\":\"IWM Europe\",\"value\":\"IWM_EUROPE\",\"order\":3,\"disabled\":false},{\"label\":\"IWM LatAm\",\"value\":\"IWM_LAT_AM\",\"order\":4,\"disabled\":false},{\"label\":\"IWM Middle East and Africa\",\"value\":\"IWM_MIDDLE_EAST_AND_AFRICA\",\"order\":5,\"disabled\":false},{\"label\":\"IWM PBI\",\"value\":\"IWM_PBI\",\"order\":6,\"disabled\":false},{\"label\":\"SUB EAM\",\"value\":\"SUB_EAM\",\"order\":7,\"disabled\":false},{\"label\":\"SUB Premium Clients\",\"value\":\"SUB_PREMIUM_CLIENTS\",\"order\":8,\"disabled\":false},{\"label\":\"SUB WMC\",\"value\":\"SUB_WMC\",\"order\":9,\"disabled\":false},{\"label\":\"Various\",\"value\":\"VARIOUS\",\"order\":10,\"disabled\":false}],\"triggerValidation\":false},{\"type\":\"CHECKBOX_GROUP\",\"key\":\"offerings\",\"readOnly\":false,\"label\":\"Offerings\",\"validations\":{\"required\":false,\"size\":{\"min\":0}},\"options\":[{\"label\":\"Strategic Offering\",\"value\":\"internalStrategicOffering\",\"order\":0,\"disabled\":false},{\"label\":\"Masterlist\",\"value\":\"internalMasterlist\",\"order\":1,\"disabled\":false}],\"triggerValidation\":false}],\"triggerValidation\":false}],\"productType\":\"ABRC\",\"actions\":[{\"type\":\"WEB_ACTION\",\"key\":\"CANCEL\",\"label\":\"CANCEL\"},{\"type\":\"WEB_ACTION\",\"key\":\"CLOSE\",\"label\":\"CLOSE\"},{\"type\":\"WEB_ACTION\",\"key\":\"COPY\",\"label\":\"COPY\"},{\"type\":\"WEB_ACTION\",\"key\":\"EDIT_REQUEST\",\"label\":\"EDIT REQUEST\"},{\"type\":\"WEB_ACTION\",\"key\":\"REQUEST_DOCUMENT\",\"label\":\"REQUEST DOCUMENT\"},{\"type\":\"WEB_ACTION\",\"key\":\"RENAME_RFQ\",\"label\":\"RENAME RFQ\"},{\"type\":\"WEB_ACTION\",\"key\":\"SAVE_DRAFT\",\"label\":\"SAVE DRAFT\"},{\"type\":\"WEB_ACTION\",\"key\":\"SEND\",\"label\":\"SEND\"},{\"type\":\"WEB_ACTION\",\"key\":\"SEND_EXTERNAL_MESSAGE\",\"label\":\"SEND EXTERNAL MESSAGE\"}]},\"errors\":[{\"elementName\":\"elaboration\",\"errorMessage\":\"UNKNOWN_SYMBOL\",\"elementChildId\":null,\"elementChildField\":null}]}")
				.filter(allureFilter)
				.filter(statusCode5XXFilter)
				.filter(nominalOrFaultyTestCaseFilter)
				.filter(validationFilter)
			.when()
				.put("/api/app/rfq");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

	@Test
	public void test_toloo35d2bld_update() {
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
				.put("/api/app/rfq");

			response.then().log().all();
			System.out.println("Test passed.");
		} catch (RuntimeException ex) {
			System.err.println(ex.getMessage());
			fail(ex.getMessage());
		}
	}

}
