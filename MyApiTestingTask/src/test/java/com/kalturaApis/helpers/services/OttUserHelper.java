package com.kalturaApis.helpers.services;

import com.kalturaApis.constants.KalturaApiServices;
import com.kalturaApis.constants.KalturaApiVerificationForAssertionMessages;
import com.kalturaApis.constants.KalturaObjectTypes;
import com.kalturaApis.pojos.services.ottUser.actions.register.responses.validRegisteringResponse.SuccessfulRegisteringResponse;
import com.kalturaApis.pojos.services.ottUser.actions.register.rquestAccordingExercise.RegisterPostBody;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class OttUserHelper extends BaseService{

    public OttUserHelper() {
    }

    public OttUserHelperResponse registerBasic(){
        RequestSpecification requestSpecification;
        Response resp;
        String thePostJson;
        String generatedAndExpectedUserName;
        String generatedAndExpectedExternalId;

        //init and configure the request specification
        requestSpecification = getRequestSpecification();

        //load template json of the relevant post request
        thePostJson = getBody(KalturaApiServices.OttUser.RequestBodysTemplates.Actions.Register.BASIC);
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
        resp = given().spec(requestSpecification).post(KalturaApiServices.OttUser.ActionsEndPoints.REGISTER);
        resp.then().log().all();

        //hard assert on status code
        Assert.assertTrue(
                resp.getStatusCode() == HttpStatus.SC_OK,
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.STATUS_CODE,
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
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.OBJECT_TYPE,
                        successfulRegisteringResponse.getResult().getObjectType(),
                        KalturaObjectTypes.KALTURA_OTT_USER)
        );
        //assert the userName is ok
        softAssert.assertTrue(
                successfulRegisteringResponse.getResult().getUsername().
                        equalsIgnoreCase(
                                generatedAndExpectedUserName),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.USER_NAME,
                        successfulRegisteringResponse.getResult().getUsername(),
                        generatedAndExpectedUserName)
        );
        //assert the externalid and external_id are ok
        softAssert.assertTrue(
                successfulRegisteringResponse.getResult().getExternalId().
                        equalsIgnoreCase(
                                generatedAndExpectedExternalId),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.EXTERNALID,
                        successfulRegisteringResponse.getResult().getExternalId(),
                        generatedAndExpectedExternalId)
        );
        softAssert.assertTrue(
                successfulRegisteringResponse.getResult().getExternal_id().
                        equalsIgnoreCase(
                                generatedAndExpectedExternalId),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.EXTERNAL_ID,
                        successfulRegisteringResponse.getResult().getExternal_id(),
                        generatedAndExpectedExternalId)
        );
        //verify register was ok
        softAssert.assertAll();

        return new OttUserHelperResponse(registerPostBody);
    }
}
