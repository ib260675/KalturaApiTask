package com.kalturaApis.helpers.services;

import com.kalturaApis.pojos.services.ottUser.actions.register.rquestAccordingExercise.RegisterPostBody;
import io.restassured.response.Response;

public class OttUserHelperResponse {
    private RegisterPostBody registerPostBody;

    public OttUserHelperResponse(RegisterPostBody registerPostBody) {
        this.registerPostBody = registerPostBody;
    }

    public RegisterPostBody getRegisterPostBody() {
        return registerPostBody;
    }

    public void setRegisterPostBody(RegisterPostBody registerPostBody) {
        this.registerPostBody = registerPostBody;
    }
}
