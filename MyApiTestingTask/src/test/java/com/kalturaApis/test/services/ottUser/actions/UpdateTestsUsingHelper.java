package com.kalturaApis.test.services.ottUser.actions;

import com.kalturaApis.constants.KalturaApiErrorMessages;
import com.kalturaApis.constants.KalturaApiServices;
import com.kalturaApis.constants.KalturaApiVerificationForAssertionMessages;
import com.kalturaApis.constants.KalturaObjectTypes;
import com.kalturaApis.helpers.services.OttUserHelperResponse;
import com.kalturaApis.pojos.errors.ErrorResponse;
import com.kalturaApis.pojos.services.ottUser.actions.login.requestAccordingApiDocumentation.LoginPostBody;
import com.kalturaApis.pojos.services.ottUser.actions.login.responses.validLoginResponse.SuccessfulLoginResponse;
import com.kalturaApis.pojos.services.ottUser.actions.update.requestAccordingApiDocumentation.UpdatePostBody;
import com.kalturaApis.pojos.services.ottUser.actions.update.responses.validUpdateResponse.SuccessfulUpdateResponse;
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

public class UpdateTestsUsingHelper extends BaseTest {

    @BeforeTest
    protected void setup(){
    }

    @Test(description="basic straight farward update action with unique values where needed which expected to update successfuly.")
    public void validateBasicSuccessfulUpdate()
    {
        RequestSpecification requestSpecification;
        Response resp;
        String thePostJson;
        OttUserHelperResponse ottUserHelperResponse;

        //init and configure the request specification
        requestSpecification = getRequestSpecification();

        // register with helper and extract the needed results.
        // (when using an helper we assume the action was already tested and we can use in 'execution' mode)
        ottUserHelperResponse = ottUserHelper.registerBasic();

        //from here handle the update request
        //###################################################
        //load template json of the relevant post request
        thePostJson = getBody(KalturaApiServices.OttUser.RequestBodysTemplates.Actions.Update.BASIC);
        //parse to object
        UpdatePostBody updatePostBody = gson.fromJson(thePostJson, UpdatePostBody.class);

        //update the username as was created in the registration
        updatePostBody.getUser().setUsername(ottUserHelperResponse.getSuccessfulRegisteringResponse().getResult().getUsername());
        //update the externalID
        updatePostBody.getUser().setExternalId(ottUserHelperResponse.getSuccessfulRegisteringResponse().getResult().getExternalId());
        updatePostBody.getUser().setFirstName("updatedName");
        //supply the id from the register response
        updatePostBody.setId(ottUserHelperResponse.getSuccessfulRegisteringResponse().getResult().getId());

        // parse back to json to supply the post body
        thePostJson = gson.toJson(updatePostBody);
        //set the prepared body into spec
        requestSpecification.body(thePostJson);
        //execute the post request and log results to console
        resp = given().spec(requestSpecification).post(KalturaApiServices.OttUser.ActionsEndPoints.UPDATE);
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
        SuccessfulUpdateResponse successfulUpdateResponse = resp.as(SuccessfulUpdateResponse.class, ObjectMapperType.GSON);
        //hard assert on verifying no error occured - added because seems like update did not work,
        // i get Service Forbidden error although supplied the correct id,
        // registered username and externalID and the updated first name I wanted to verify
        //deserialize the expected error response
        Assert.assertTrue(successfulUpdateResponse.getResult().getObjectType() != null,"The update process failed. " +
                "expected valid update response but got the following response:\n" +
                resp.asString()
        );

        //assert the object type is ok
        softAssert.assertTrue(
                successfulUpdateResponse.getResult().getObjectType().
                        equalsIgnoreCase(
                                KalturaObjectTypes.KALTURA_OTT_USER),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.OBJECT_TYPE,
                        successfulUpdateResponse.getResult().getObjectType(),
                        KalturaObjectTypes.KALTURA_OTT_USER)
        );
        //assert the updated first name is ok
        softAssert.assertTrue(
                successfulUpdateResponse.getResult().getFirst_name().
                        equalsIgnoreCase(
                                "updatedName"),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.USER_NAME,
                        successfulUpdateResponse.getResult().getUsername(),
                        "updatedName")
        );
        //verify register was ok
        softAssert.assertAll();
    }

    @Test(description="basic straight farward invalid update action with wrong id value that should result with Service Forbidden message.")
    public void validateBasicInvalidUpdateWithWrongIdInput()
    {
        RequestSpecification requestSpecification;
        Response resp;
        String thePostJson;
        OttUserHelperResponse ottUserHelperResponse;

        //init and configure the request specification
        requestSpecification = getRequestSpecification();

        // register with helper and extract the needed results.
        // (when using an helper we assume the action was already tested and we can use in 'execution' mode)
        ottUserHelperResponse = ottUserHelper.registerBasic();

        //from here handle the update request
        //###################################################
        //load template json of the relevant post request
        thePostJson = getBody(KalturaApiServices.OttUser.RequestBodysTemplates.Actions.Update.BASIC);
        //parse to object
        UpdatePostBody updatePostBody = gson.fromJson(thePostJson, UpdatePostBody.class);

        //update the first name and dont supply the id from the register request
        updatePostBody.getUser().setFirstName("updatedName");
        //supply wrong id for update request
        updatePostBody.setId("blablaID");

        // parse back to json to supply the post body
        thePostJson = gson.toJson(updatePostBody);
        //set the prepared body into spec
        requestSpecification.body(thePostJson);
        //execute the post request and log results to console
        resp = given().spec(requestSpecification).post(KalturaApiServices.OttUser.ActionsEndPoints.UPDATE);
        resp.then().log().all();

        //hard assert on status code
        Assert.assertTrue(
                resp.getStatusCode() == HttpStatus.SC_OK,
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.STATUS_CODE,
                        resp.getStatusCode(),
                        HttpStatus.SC_OK
                )
        );

        //deserialize the expected error response
        ErrorResponse errorResponse = resp.as(ErrorResponse.class, ObjectMapperType.GSON);
        softAssert.assertTrue(
                errorResponse.getResult().getError().getMessage().
                        equalsIgnoreCase(
                                KalturaApiErrorMessages.SERVICE_FORBIDDEN),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.ERROR_MESSAGE,
                        errorResponse.getResult().getError().getMessage(),
                        KalturaApiErrorMessages.SERVICE_FORBIDDEN)
        );
        softAssert.assertAll();
    }

    @AfterTest
    protected void tearDown(){
    }
}