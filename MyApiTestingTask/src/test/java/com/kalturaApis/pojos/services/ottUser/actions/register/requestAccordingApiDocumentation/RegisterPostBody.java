
package com.kalturaApis.pojos.services.ottUser.actions.register.requestAccordingApiDocumentation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterPostBody {

    @SerializedName("partnerId")
    @Expose
    private Integer partnerId;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("password")
    @Expose
    private String password;

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
