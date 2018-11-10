
package com.kalturaApis.pojos.services.ottUser.actions.register.requestAccordingApiDocumentation;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DynamicData {

    @SerializedName("item1")
    @Expose
    private Item1 item1;

    public Item1 getItem1() {
        return item1;
    }

    public void setItem1(Item1 item1) {
        this.item1 = item1;
    }

}
