
package com.kalturaApis.pojos.services.ottUser.actions.update.responses.validUpdateResponse;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Result {

    @SerializedName("objectType")
    @Expose
    private String objectType;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("first_name")
    @Expose
    private String first_name;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("last_name")
    @Expose
    private String last_name;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private Country country;
    @SerializedName("countryId")
    @Expose
    private Integer countryId;
    @SerializedName("createDate")
    @Expose
    private Integer createDate;
    @SerializedName("dynamicData")
    @Expose
    private DynamicData dynamicData;
    @SerializedName("dynamic_data")
    @Expose
    private Dynamic_data dynamic_data;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("externalId")
    @Expose
    private String externalId;
    @SerializedName("external_id")
    @Expose
    private String external_id;
    @SerializedName("householdId")
    @Expose
    private Integer householdId;
    @SerializedName("household_id")
    @Expose
    private Integer household_id;
    @SerializedName("isHouseholdMaster")
    @Expose
    private Boolean isHouseholdMaster;
    @SerializedName("is_household_master")
    @Expose
    private Boolean is_household_master;
    @SerializedName("roleIds")
    @Expose
    private String roleIds;
    @SerializedName("suspensionState")
    @Expose
    private String suspensionState;
    @SerializedName("suspentionState")
    @Expose
    private String suspentionState;
    @SerializedName("suspention_state")
    @Expose
    private String suspention_state;
    @SerializedName("updateDate")
    @Expose
    private Integer updateDate;
    @SerializedName("userState")
    @Expose
    private String userState;
    @SerializedName("user_state")
    @Expose
    private String user_state;
    @SerializedName("userType")
    @Expose
    private UserType userType;
    @SerializedName("user_type")
    @Expose
    private User_type user_type;

    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public Integer getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Integer createDate) {
        this.createDate = createDate;
    }

    public DynamicData getDynamicData() {
        return dynamicData;
    }

    public void setDynamicData(DynamicData dynamicData) {
        this.dynamicData = dynamicData;
    }

    public Dynamic_data getDynamic_data() {
        return dynamic_data;
    }

    public void setDynamic_data(Dynamic_data dynamic_data) {
        this.dynamic_data = dynamic_data;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getExternal_id() {
        return external_id;
    }

    public void setExternal_id(String external_id) {
        this.external_id = external_id;
    }

    public Integer getHouseholdId() {
        return householdId;
    }

    public void setHouseholdId(Integer householdId) {
        this.householdId = householdId;
    }

    public Integer getHousehold_id() {
        return household_id;
    }

    public void setHousehold_id(Integer household_id) {
        this.household_id = household_id;
    }

    public Boolean getIsHouseholdMaster() {
        return isHouseholdMaster;
    }

    public void setIsHouseholdMaster(Boolean isHouseholdMaster) {
        this.isHouseholdMaster = isHouseholdMaster;
    }

    public Boolean getIs_household_master() {
        return is_household_master;
    }

    public void setIs_household_master(Boolean is_household_master) {
        this.is_household_master = is_household_master;
    }

    public String getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }

    public String getSuspensionState() {
        return suspensionState;
    }

    public void setSuspensionState(String suspensionState) {
        this.suspensionState = suspensionState;
    }

    public String getSuspentionState() {
        return suspentionState;
    }

    public void setSuspentionState(String suspentionState) {
        this.suspentionState = suspentionState;
    }

    public String getSuspention_state() {
        return suspention_state;
    }

    public void setSuspention_state(String suspention_state) {
        this.suspention_state = suspention_state;
    }

    public Integer getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Integer updateDate) {
        this.updateDate = updateDate;
    }

    public String getUserState() {
        return userState;
    }

    public void setUserState(String userState) {
        this.userState = userState;
    }

    public String getUser_state() {
        return user_state;
    }

    public void setUser_state(String user_state) {
        this.user_state = user_state;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public User_type getUser_type() {
        return user_type;
    }

    public void setUser_type(User_type user_type) {
        this.user_type = user_type;
    }

}
