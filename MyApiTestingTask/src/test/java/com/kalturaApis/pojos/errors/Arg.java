
package com.kalturaApis.pojos.errors;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Arg {

    @SerializedName("objectType")
    @Expose
    private String objectType;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("value")
    @Expose
    private String value;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
