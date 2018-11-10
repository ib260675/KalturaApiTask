package com.kalturaApis.test.services.ottUser.actions;

import com.kalturaApis.constants.KalturaApiErrorMessages;
import com.kalturaApis.constants.KalturaApiServices;
import com.kalturaApis.constants.KalturaApiVerificationForAssertionMessages;
import com.kalturaApis.constants.KalturaObjectTypes;
import com.kalturaApis.helpers.services.OttUserHelperResponse;
import com.kalturaApis.pojos.errors.ErrorResponse;
import com.kalturaApis.pojos.services.ottUser.actions.login.requestAccordingApiDocumentation.LoginPostBody;
import com.kalturaApis.pojos.services.ottUser.actions.login.responses.validLoginResponse.SuccessfulLoginResponse;
import com.kalturaApis.pojos.services.ottUser.actions.register.rquestAccordingExercise.RegisterPostBody;
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

public class LoginTestsUsingHelper extends BaseTest {

    @BeforeTest
    protected void setup(){
    }

    @Test(description="basic straight farward login action with unique values where needed which expected to login successfuly.")
    public void validateBasicSuccessfulLogin()
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

        //from here handle the login
        //###################################################
        //load template json of the relevant post request
        thePostJson = getBody(KalturaApiServices.OttUser.RequestBodysTemplates.Actions.Login.BASIC);
        //parse to object
        LoginPostBody loginPostBody = gson.fromJson(thePostJson, LoginPostBody.class);
        // set the user and password created in the registration
        loginPostBody.setUsername(ottUserHelperResponse.getRegisterPostBody().getUser().getUsername());
        loginPostBody.setPassword(ottUserHelperResponse.getRegisterPostBody().getPassword());
        // parse back to json to supply the post body
        thePostJson = gson.toJson(loginPostBody);
        //set the prepared body into spec
        requestSpecification.body(thePostJson);
        //execute the post request and log results to console
        resp = given().spec(requestSpecification).post(KalturaApiServices.OttUser.ActionsEndPoints.LOGIN);
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
        SuccessfulLoginResponse successfulLoginResponse = resp.as(SuccessfulLoginResponse.class, ObjectMapperType.GSON);
        //assert the object type is ok
        softAssert.assertTrue(
                successfulLoginResponse.getResult().getObjectType().
                        equalsIgnoreCase(
                                KalturaObjectTypes.KALTURA_LOGIN_RESPONSE),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.OBJECT_TYPE,
                        successfulLoginResponse.getResult().getObjectType(),
                        KalturaObjectTypes.KALTURA_LOGIN_RESPONSE)
        );
        //assert the returned access token is not empty
        softAssert.assertTrue(!successfulLoginResponse.getResult().getLoginSession().getKs().isEmpty(),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.ACCESS_TOKEN,
                        successfulLoginResponse.getResult().getLoginSession().getKs(),
                        KalturaApiVerificationForAssertionMessages.NOT_EMPTY)
        );
        softAssert.assertAll();
    }

    @Test(description="basic straight farward negative login action with wrong password that is expected to fail.")
    public void validateLoginFailureWithWrongPassword()
    {
        RequestSpecification requestSpecification;
        Response resp;
        String thePostJson;
        OttUserHelperResponse ottUserHelperResponse;
//        String generatedAndExpectedUserName;

        //init and configure the request specification
        requestSpecification = getRequestSpecification();

        // register with helper and extract the needed results.
        // (when using an helper we assume the action was already tested and we can use in 'execution' mode)
        ottUserHelperResponse = ottUserHelper.registerBasic();

        //from here handle the login
        //###################################################
        //load template json of the relevant post request
        thePostJson = getBody(KalturaApiServices.OttUser.RequestBodysTemplates.Actions.Login.BASIC);
        //parse to object
        LoginPostBody loginPostBody = gson.fromJson(thePostJson, LoginPostBody.class);
        // set the user and password created in the registration
        loginPostBody.setUsername(ottUserHelperResponse.getRegisterPostBody().getUser().getUsername());
        //manupulate to wrong password!
        loginPostBody.setPassword("blablablu");
        // parse back to json to supply the post body
        thePostJson = gson.toJson(loginPostBody);
        //set the prepared body into spec
        requestSpecification.body(thePostJson);
        //execute the post request and log results to console
        resp = given().spec(requestSpecification).post(KalturaApiServices.OttUser.ActionsEndPoints.LOGIN);
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
                                KalturaApiErrorMessages.WRONG_USERNAME_OR_PASSWORD),
                reportExpVsActual(KalturaApiVerificationForAssertionMessages.ERROR_MESSAGE,
                        errorResponse.getResult().getError().getMessage(),
                        KalturaApiErrorMessages.WRONG_USERNAME_OR_PASSWORD)
        );
        softAssert.assertAll();
    }

    @AfterTest
    protected void tearDown(){
    }
}

