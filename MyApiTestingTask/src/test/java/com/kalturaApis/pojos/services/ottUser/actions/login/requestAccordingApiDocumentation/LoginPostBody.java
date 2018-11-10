
package com.kalturaApis.pojos.services.ottUser.actions.login.requestAccordingApiDocumentation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginPostBody {

    @SerializedName("partnerId")
    @Expose
    private Integer partnerId;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("extraParams")
    @Expose
    private ExtraParams extraParams;
    @SerializedName("udid")
    @Expose
    private String udid;

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ExtraParams getExtraParams() {
        return extraParams;
    }

    public void setExtraParams(ExtraParams extraParams) {
        this.extraParams = extraParams;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

}
