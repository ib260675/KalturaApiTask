
package com.kalturaApis.pojos.services.ottUser.actions.update.requestAccordingApiDocumentation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UpdatePostBody {

    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("id")
    @Expose
    private String id;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
