package com.example.administrator.kwft.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {
    @Expose
    @SerializedName("cust_id") private int cust_id;
    @Expose
    @SerializedName("name") private String name;
    @Expose
    @SerializedName("account_type") private String account_type;
    @Expose
    @SerializedName("email") private String email;
    @Expose
    @SerializedName("phone_no") private String phone_no;
    @Expose
    @SerializedName("id_number") private int id_number;
    @Expose
    @SerializedName("address") private String address;
    @Expose
    @SerializedName("location") private String location;
    @Expose
    @SerializedName("account_no") private int account_no;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("message") private String message;



    public int getCust_id(){ return cust_id;}

    public void setCust_id(){ this.cust_id = cust_id;}

    public String getName(){ return name;}

    public void setName(){ this.name = name;}

    public String getAccount_type(){ return account_type;}

    public void setAccount_type(){ this.account_type = account_type;}

    public String getEmail(){ return email;}

    public void setEmail(){ this.email = email;}

    public String getPhone_no(){ return  phone_no;}

    public void setPhone_no(){ this.phone_no = phone_no;}

    public  int getId_number(){ return id_number;}

    public void setId_number(){ this.id_number = id_number;}

    public String getAddress(){ return address;}

    public void setAddress(){ this.address = address;}

    public String getLocation(){return location;}

    public void setLocation(){ this.location = location;}

    public  int getAccount_no(){ return account_no;}

    public void setAccount_no(){ this.account_no = account_no;}

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
