package com.kalturaApis.helpers.services;

import com.google.gson.Gson;
import com.kalturaApis.constants.KalturaApiServices;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public abstract class BaseService {

    protected Gson gson = new Gson();
    protected SoftAssert softAssert = new SoftAssert();

    protected RequestSpecification getRequestSpecification() {
        System.out.println("set the specification content type to: " + KalturaApiServices.CONTENT_TYPE);
        return RestAssured.given().contentType(KalturaApiServices.CONTENT_TYPE);
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

    protected String reportExpVsActual(String verificationSubject, String actualVal,String expectedVal){
        return "Verifying the following subject: '" + verificationSubject + "'. Actual value was: " + actualVal + ", Expected value was: " + expectedVal;
    }
    protected String reportExpVsActual(String verificationSubject, int actualVal,int expectedVal){
        return "Verifying the following subject: '" + verificationSubject + "'. Actual value was: " + actualVal + ", Expected value was: " + expectedVal;
    }
}
