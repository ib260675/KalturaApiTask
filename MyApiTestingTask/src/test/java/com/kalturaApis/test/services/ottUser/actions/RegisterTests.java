package com.kalturaApis.test.services.ottUser.actions;

import com.kalturaApis.constants.KalturaApiErrorMessages;
import com.kalturaApis.constants.KalturaApiServices;
import com.kalturaApis.constants.KalturaObjectTypes;
import com.kalturaApis.pojos.errors.ErrorResponse;
import com.kalturaApis.pojos.services.ottUser.actions.register.requestAccordingApiDocumentation.RegisterPostBody;
import com.kalturaApis.pojos.services.ottUser.actions.register.responses.validRegisteringResponse.SuccessfulRegisteringResponse;
import com.kalturaApis.test.BaseTest;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RegisterTests extends BaseTest {

    @BeforeTest
    protected void setup(){
    }

    @Test(description="basic straight farward register action with unique values where needed which expected to create new KalturaOTTUser.")
    public void validateBasicSuccessfulRegistering()
    {
        RequestSpecification requestSpecification;
        Response resp;
        String thePostJson;
        String generatedAndExpectedUserName;
        String generatedAndExpectedExternalId;

        //init and configure the request specification
        requestSpecification = getRequestSpecification();
        //load template json of the relevant post request
        thePostJson = getBody(KalturaApiServices.OttUser.RequestBodysTemplates.BASIC);
        //parse to object
        RegisterPostBody registerPostBody = gson.fromJson(thePostJson, RegisterPostBody.class);
        // override and set a unique new username
        generatedAndExpectedUserName = "irmi_" + System.nanoTime();
        registerPostBody.getUser().setUsername(generatedAndExpectedUserName);
        // override and set a unique new external ID
        generatedAndExpectedExternalId = "someExtID_" + System.nanoTime();
        registerPostBody.getUser().setExternalId(generatedAndExpectedExternalId);
        // parse back to json to supply the post body
        thePostJson = gson.toJson(registerPostBody);
        //set the prepared body into spec
        requestSpecification.body(thePostJson);
        //execute the post request and log results to console
        resp = given().spec(requestSpecification).post(KalturaApiServices.OttUser.EndPoints.REGISTER);
        resp.then().log().all();

        //hard assert on status code
        Assert.assertTrue(
                resp.getStatusCode() == HttpStatus.SC_OK,
                reportExpVsActual(
                        resp.getStatusCode(),
                        HttpStatus.SC_OK
                )
        );

        //deserialize the expected valid response
        SuccessfulRegisteringResponse successfulRegisteringResponse = resp.as(SuccessfulRegisteringResponse.class, ObjectMapperType.GSON);
        //assert the object type is ok
        softAssert.assertTrue(
                successfulRegisteringResponse.getResult().getObjectType().
                equalsIgnoreCase(
                KalturaObjectTypes.KALTURA_OTT_USER),
                reportExpVsActual(
                        successfulRegisteringResponse.getResult().getObjectType(),
                        KalturaObjectTypes.KALTURA_OTT_USER)
        );
        //assert the userName is ok
        softAssert.assertTrue(
                successfulRegisteringResponse.getResult().getUsername().
                        equalsIgnoreCase(
                                generatedAndExpectedUserName),
                reportExpVsActual(
                        successfulRegisteringResponse.getResult().getUsername(),
                        generatedAndExpectedUserName)
        );
        //assert the externalid and external_id are ok
        softAssert.assertTrue(
                successfulRegisteringResponse.getResult().getExternalId().
                        equalsIgnoreCase(
                                generatedAndExpectedExternalId),
                reportExpVsActual(
                        successfulRegisteringResponse.getResult().getExternalId(),
                        generatedAndExpectedExternalId)
        );
        softAssert.assertTrue(
                successfulRegisteringResponse.getResult().getExternal_id().
                        equalsIgnoreCase(
                                generatedAndExpectedExternalId),
                reportExpVsActual(
                        successfulRegisteringResponse.getResult().getExternal_id(),
                        generatedAndExpectedExternalId)
        );
        softAssert.assertAll();
    }

    @Test(description="basic straight farward register action with existing external ID")
    public void validateExternalIdAlreadyExistError()
    {
        RequestSpecification requestSpecification;
        Response resp;
        String thePostJson;

        //init and configure the request specification
        requestSpecification = getRequestSpecification();
        //load template json of the relevant post request
        thePostJson = getBody(KalturaApiServices.OttUser.RequestBodysTemplates.BASIC);
        //parse to object
        RegisterPostBody registerPostBody = gson.fromJson(thePostJson, RegisterPostBody.class);
        // set a new name
        registerPostBody.getUser().setUsername("irmi_" + System.nanoTime());
        // parse back to json to supply the post body
        thePostJson = gson.toJson(registerPostBody);
        //set the prepared body into spec
        requestSpecification.body(thePostJson);
        //execute the post request and log results to console
        resp = given().spec(requestSpecification).post(KalturaApiServices.OttUser.EndPoints.REGISTER);
        resp.then().log().all();

        //hard assert on status code
        Assert.assertTrue(
                resp.getStatusCode() == HttpStatus.SC_OK,
                reportExpVsActual(
                        resp.getStatusCode(),
                        HttpStatus.SC_OK
                )
        );

        //deserialize the error response
        ErrorResponse errorResponse = resp.as(ErrorResponse.class, ObjectMapperType.GSON);
        softAssert.assertTrue(
                errorResponse.getResult().getError().getMessage().
                        equalsIgnoreCase(
                                KalturaApiErrorMessages.EXTERNAL_ID_ALREADY_EXISTS),
                reportExpVsActual(
                        errorResponse.getResult().getError().getMessage(),
                        KalturaApiErrorMessages.EXTERNAL_ID_ALREADY_EXISTS)
        );
        softAssert.assertAll();
    }

    @Test(description="basic straight farward register action with existing username")
    public void validateUserNameAlreadyExistError()
    {
        RequestSpecification requestSpecification;
        Response resp;
        String thePostJson;

        //init and configure the request specification
        requestSpecification = getRequestSpecification();
        //load template json of the relevant post request
        thePostJson = getBody(KalturaApiServices.OttUser.RequestBodysTemplates.BASIC);
        //parse to object
        RegisterPostBody registerPostBody = gson.fromJson(thePostJson, RegisterPostBody.class);
        // override and set a unique new external ID
        registerPostBody.getUser().setExternalId("someExtID_" + System.nanoTime());
        // parse back to json to supply the post body
        thePostJson = gson.toJson(registerPostBody);
        //set the prepared body into spec
        requestSpecification.body(thePostJson);
        //execute the post request and log results to console
        resp = given().spec(requestSpecification).post(KalturaApiServices.OttUser.EndPoints.REGISTER);
        resp.then().log().all();

        //hard assert on status code
        Assert.assertTrue(
                resp.getStatusCode() == HttpStatus.SC_OK,
                reportExpVsActual(
                        resp.getStatusCode(),
                        HttpStatus.SC_OK
                )
        );

        //deserialize the error response
        ErrorResponse errorResponse = resp.as(ErrorResponse.class, ObjectMapperType.GSON);
        softAssert.assertTrue(
                errorResponse.getResult().getError().getMessage().
                        equalsIgnoreCase(
                                KalturaApiErrorMessages.USER_EXISTS),
                reportExpVsActual(
                        errorResponse.getResult().getError().getMessage(),
                        KalturaApiErrorMessages.USER_EXISTS)
        );
        softAssert.assertAll();
    }

    @AfterTest
    protected void tearDown(){
    }
}

