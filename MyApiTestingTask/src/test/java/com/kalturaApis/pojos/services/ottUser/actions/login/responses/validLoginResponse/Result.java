
package com.kalturaApis.pojos.services.ottUser.actions.login.responses.validLoginResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("objectType")
    @Expose
    private String objectType;
    @SerializedName("loginSession")
    @Expose
    private LoginSession loginSession;
    @SerializedName("login_session")
    @Expose
    private Login_session login_session;
    @SerializedName("user")
    @Expose
    private User user;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public LoginSession getLoginSession() {
        return loginSession;
    }

    public void setLoginSession(LoginSession loginSession) {
        this.loginSession = loginSession;
    }

    public Login_session getLogin_session() {
        return login_session;
    }

    public void setLogin_session(Login_session login_session) {
        this.login_session = login_session;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
