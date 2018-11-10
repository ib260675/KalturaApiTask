package com.kalturaApis.helpers.services;

import com.kalturaApis.pojos.services.ottUser.actions.register.responses.validRegisteringResponse.SuccessfulRegisteringResponse;
import com.kalturaApis.pojos.services.ottUser.actions.register.rquestAccordingExercise.RegisterPostBody;
import io.restassured.response.Response;

public class OttUserHelperResponse {
    private RegisterPostBody registerPostBody;
    private SuccessfulRegisteringResponse successfulRegisteringResponse;

    //constructor
    public OttUserHelperResponse(SuccessfulRegisteringResponse successfulRegisteringResponse, RegisterPostBody registerPostBody) {
        this.registerPostBody = registerPostBody;
        this.successfulRegisteringResponse = successfulRegisteringResponse;
    }

    public SuccessfulRegisteringResponse getSuccessfulRegisteringResponse() {
        return successfulRegisteringResponse;
    }

    public void setSuccessfulRegisteringResponse(SuccessfulRegisteringResponse successfulRegisteringResponse) {
        this.successfulRegisteringResponse = successfulRegisteringResponse;
    }

    public RegisterPostBody getRegisterPostBody() {
        return registerPostBody;
    }

    public void setRegisterPostBody(RegisterPostBody registerPostBody) {
        this.registerPostBody = registerPostBody;
    }
}
