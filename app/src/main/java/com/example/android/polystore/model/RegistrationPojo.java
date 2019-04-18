package com.example.android.polystore.model;

public class RegistrationPojo {

    String email, password, store_name, register_date, user_name, confirm_password,
            first_name, last_name ,date_birth, mobile_number,area ,landmark ,address ,country,
            state, city,store_reg_name,store_reg_date;

    public RegistrationPojo(String email, String password, String store_name, String register_date, String user_name, String confirm_password, String first_name, String last_name, String date_birth, String mobile_number, String area, String landmark, String address, String country, String state, String city, String store_reg_name, String store_reg_date) {
        this.email = email;
        this.password = password;
        this.store_name = store_name;
        this.register_date = register_date;
        this.user_name = user_name;
        this.confirm_password = confirm_password;
        this.first_name = first_name;
        this.last_name = last_name;
        this.date_birth = date_birth;
        this.mobile_number = mobile_number;
        this.area = area;
        this.landmark = landmark;
        this.address = address;
        this.country = country;
        this.state = state;
        this.city = city;
        this.store_reg_name = store_reg_name;
        this.store_reg_date = store_reg_date;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getStore_name() {
        return store_name;
    }

    public String getRegister_date() {
        return register_date;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getDate_birth() {
        return date_birth;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public String getArea() {
        return area;
    }

    public String getLandmark() {
        return landmark;
    }

    public String getAddress() {
        return address;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStore_reg_name() {
        return store_reg_name;
    }

    public String getStore_reg_date() {
        return store_reg_date;
    }
}
