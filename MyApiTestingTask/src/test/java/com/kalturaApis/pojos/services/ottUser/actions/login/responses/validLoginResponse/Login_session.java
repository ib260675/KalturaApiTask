
package com.kalturaApis.pojos.services.ottUser.actions.login.responses.validLoginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Login_session {

    @SerializedName("objectType")
    @Expose
    private String objectType;
    @SerializedName("ks")
    @Expose
    private String ks;
    @SerializedName("refreshToken")
    @Expose
    private String refreshToken;
    @SerializedName("refresh_token")
    @Expose
    private String refresh_token;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getKs() {
        return ks;
    }

    public void setKs(String ks) {
        this.ks = ks;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

}
