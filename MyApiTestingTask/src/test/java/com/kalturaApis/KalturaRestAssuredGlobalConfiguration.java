package com.kalturaApis;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

public class KalturaRestAssuredGlobalConfiguration {
    @BeforeSuite(alwaysRun = true)
    public void configure() {
        RestAssured.baseURI = "https://rest-eus1.ott.kaltura.com";
        RestAssured.basePath = "/restful_v5_0/api_v3";
    }

    public RequestSpecification getRequestSpecification() {
//        RestAssured.baseURI = "https://rest-eus1.ott.kaltura.com";
//        RestAssured.basePath = "/restful_v5_0/api_v3";
        return RestAssured.given().contentType("application/json\n");
    }

}
