
package com.kalturaApis.pojos.services.ottUser.actions.register.responses.validRegisteringResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SuccessfulRegisteringResponse {

    @SerializedName("executionTime")
    @Expose
    private Double executionTime;
    @SerializedName("result")
    @Expose
    private Result result;

    public Double getExecutionTime() {
        return executionTime;
    }

    public void setExecutionTime(Double executionTime) {
        this.executionTime = executionTime;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
