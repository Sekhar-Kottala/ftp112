package com.hexaware.FTP112.integration.controller;
import com.hexaware.FTP112.integration.model.Vendor;
import com.hexaware.FTP112.integration.util.CommonUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import org.junit.Test;
import static org.junit.Assert.*;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import static com.jayway.restassured.RestAssured.given;

public class VendorRestTest {
	@Test
	public void testVendorList() throws URISyntaxException {
	given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/vendors/1")).then().assertThat().statusCode(200);
	}

	@Test
	public void testVendorListById() throws URISyntaxException {
	given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/vendors/1/orders")).then().assertThat().statusCode(200);
	}
	@Test
	public void testVendorpendingList() throws URISyntaxException {
	given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/vendors/1/pending")).then().assertThat().statusCode(200);
	}
	@Test
	public void testGstcalculate() throws URISyntaxException {
	given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/vendors/3/1/gst")).then().assertThat().statusCode(200);
	}
	@Test
	public void testGstcalculateInvalid() throws URISyntaxException {
	given().when().accept(ContentType.JSON)
		.get(CommonUtil.getURI("/api/vendors/13/1/gst")).then().assertThat().statusCode(400);
	}
	@Test
	public void testVendorValidAuthentication() throws URISyntaxException {
	given().when().contentType(ContentType.JSON).body("{\"venId\":\"1\",\"venPassword\":\"hari22\"}")
		.post(CommonUtil.getURI("/api/vendors/Auth")).then().assertThat().statusCode(200);
	}

	@Test
	public void testVendorInValidAuthentication() throws URISyntaxException {
	given().when().contentType(ContentType.JSON).body("{\"venId\":\"1\",\"venPassword\":\"hggdfh\"}")
		.post(CommonUtil.getURI("/api/vendors/Auth")).then().assertThat().statusCode(400);
	}
		

}
