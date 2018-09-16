package com.example.android.polystore;

/**
 * Created by chandresh on 3/25/18.
 */

public class ProducerSetter {

    private String store_name,registration_date, mobile_number;
    int image;

    public ProducerSetter() {
    }

    public ProducerSetter(String store_name,String registration_date, String mobile_number, int image) {
        this.store_name = store_name;
        this.mobile_number = mobile_number;
        this.registration_date=registration_date;
        this.image=image;
    }

    public String getStore_name(){
        return store_name;
    }

    public void setTitle(String storename) {
        this.store_name = storename;
    }

    public String getRegistration_date(){
        return registration_date;
    }

    public void setRegistration_date(String registration_date) {
        this.registration_date = registration_date;
    }

    public String getMobile_number() {
        return mobile_number;
    }

    public void setMobile_number(String mobile) {
        this.mobile_number = mobile;
    }

    public void setImage(int proimage){
        this.image=proimage;
    }

    public int getImage(){
        return image;
    }
}
