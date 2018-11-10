package com.kalturaApis.test;

import com.google.gson.Gson;
import com.kalturaApis.constants.KalturaApiServices;
import com.kalturaApis.helpers.services.OttUserHelper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class BaseTest {

    protected Gson gson = new Gson();
    protected SoftAssert softAssert = new SoftAssert();
    protected OttUserHelper ottUserHelper = new OttUserHelper();

    protected RequestSpecification getRequestSpecification() {
        System.out.println("set the specification content type to: " + KalturaApiServices.CONTENT_TYPE);
        return RestAssured.given().contentType(KalturaApiServices.CONTENT_TYPE);
    }

    protected String reportExpVsActual(String verificationSubject, String actualVal,String expectedVal){
        return "Verifying the following subject: '" + verificationSubject + "'. Actual value was: " + actualVal + ", Expected value was: " + expectedVal;
    }
    protected String reportExpVsActual(String verificationSubject, int actualVal,int expectedVal){
        return "Verifying the following subject: '" + verificationSubject + "'. Actual value was: " + actualVal + ", Expected value was: " + expectedVal;
    }

    @BeforeSuite
    protected void configure() {
        System.out.println("init RestAssured base URI to: " + KalturaApiServices.BASE_URI);
        RestAssured.baseURI = KalturaApiServices.BASE_URI;
        System.out.println("init RestAssured base path to: " + KalturaApiServices.BASE_PATH);
        RestAssured.basePath = KalturaApiServices.BASE_PATH;
    }

    protected String getBody(String resource){
        String body = "";
        try {
            body = new String(
                    Files.readAllBytes(
                            Paths.get(getClass().getClassLoader().getResource(
                                    resource)
                                    .toURI())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return body;
    }

    public Response getResponse(RequestSpecification requestSpecification, String endpoint, int
            status){
        Response response = requestSpecification.get(endpoint);
        Assert.assertEquals(response.getStatusCode(),status);
        response.then().log().all();
        return response;
    }

//    @AfterSuite
//    protected void afterSuite(){
//        System.out.println("base after suite ****");
//    }
//
//    @BeforeMethod
//    protected void beforeMethod(){
//        System.out.println("base before method ****");
//    }
//
//    @AfterMethod
//    protected void afterMethod(){
//        System.out.println("base after method ****");
//    }
//
//    @BeforeTest
//    protected void beforeTest(){
//        System.out.println("base before test ****");
//    }
//
//    @AfterTest
//    protected void afterTest(){
//        System.out.println("base after test ****");
//    }

}
