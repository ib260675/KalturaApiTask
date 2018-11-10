
package com.kalturaApis.pojos.services.ottUser.actions.update.responses.validUpdateResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User_type {

    @SerializedName("objectType")
    @Expose
    private String objectType;
    @SerializedName("description")
    @Expose
    private String description;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
