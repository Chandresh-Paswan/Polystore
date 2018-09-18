package model;

import com.google.gson.annotations.SerializedName;

public class Registration {

    @SerializedName("version")
    String version;

    @SerializedName("firstName")
    String first_name;

    @SerializedName("dateOfBirth")
    String dateOfBirth;

    @SerializedName("lastName")
    String last_name;

    @SerializedName("address")
    String address;

    @SerializedName("area")
    String area;

    @SerializedName("landmark")
    String landmark;

    @SerializedName("cityCode")
    String citycode;

    @SerializedName("stateCode")
    String statecode;

    @SerializedName("country")
    String country;

    @SerializedName("login")
    String username;

    @SerializedName("registrationDate")
    String registrationdate;

    @SerializedName("storeName")
    String store_name;

    @SerializedName("phoneNo")
    String phone_number;

    @SerializedName("active")
    boolean active;

    @SerializedName("email")
    String emial;

    @SerializedName("areaId")
    String area_id;

    @SerializedName("landmarkId")
    String landmark_id;

    @SerializedName("stateName")
    String state_name;


    @SerializedName("cityName")
    String city_name;

    @SerializedName("fileId")
    String file_id;

    @SerializedName("imagePath")
    String image_path;

    @SerializedName("password")
    String passwords;

    public Registration( String dateOfBirth,String passwords, String version, String first_name, String last_name, String address, String area, String landmark, String citycode, String statecode, String country, String username, String registrationdate, String store_name, String phone_number, boolean active, String emial, String area_id, String landmark_id, String state_name, String city_name, String file_id, String image_path) {
        this.passwords=passwords;
        this.version = version;
        this.dateOfBirth=dateOfBirth;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.area = area;
        this.landmark = landmark;
        this.citycode = citycode;
        this.statecode = statecode;
        this.country = country;
        this.username = username;
        this.registrationdate = registrationdate;
        this.store_name = store_name;
        this.phone_number = phone_number;
        this.active = active;
        this.emial = emial;
        this.area_id = area_id;
        this.landmark_id = landmark_id;
        this.state_name = state_name;
        this.city_name = city_name;
        this.file_id = file_id;
        this.image_path = image_path;
    }

     public String getDateBirth() {
        return dateOfBirth;
    }

    public void setDateBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

     public String getPassword() {
        return passwords;
    }

    public void setPasswords(String passwords) {
        this.passwords = passwords;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }

    public String getStatecode() {
        return statecode;
    }

    public void setStatecode(String statecode) {
        this.statecode = statecode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(String registrationdate) {
        this.registrationdate = registrationdate;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
    }

    public String getLandmark_id() {
        return landmark_id;
    }

    public void setLandmark_id(String landmark_id) {
        this.landmark_id = landmark_id;
    }

    public String getState_name() {
        return state_name;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }
}
