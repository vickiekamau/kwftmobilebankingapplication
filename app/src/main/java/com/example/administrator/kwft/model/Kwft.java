package com.example.administrator.kwft.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Kwft {
    @Expose
    @SerializedName("account_no") private int account_no;
    @Expose
    @SerializedName("account_name") private String account_name;
    @Expose
    @SerializedName("account_type") private String account_type;
    @Expose
    @SerializedName("phone_no") private String phone_no;
    @Expose
    @SerializedName("balance") private double balance;
    @Expose
    @SerializedName("success") private Boolean success;
    @Expose
    @SerializedName("message") private String message;


    public int getAccount_no() {
        return account_no;
    }

    public void setAccount_no(int account_no) {
        this.account_no = account_no;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public String getPhone_no(){ return phone_no;}

    public void setPhone_no(String phone_no){this.phone_no = phone_no;}

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

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
