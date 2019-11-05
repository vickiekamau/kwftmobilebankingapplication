package com.example.administrator.kwft.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Account {
        @Expose
        @SerializedName("transaction_id") private int transaction_id;
        @Expose
        @SerializedName("time_stamp") private String time_stamp;
        @Expose
        @SerializedName("account_no") private int account_no;
        @Expose
        @SerializedName("account_to") private String account_to;
        @Expose
        @SerializedName("amount") private float amount;
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

        public int getTransactionId() {
            return transaction_id;
        }

        public void setTransactionid(int transaction_id) {
            this.transaction_id = transaction_id;
        }

        public String getAccountTo() {
            return account_to;
        }

        public void setAccountTo(String account_to) {
            this.account_to = account_to;
        }

        public float getAmount() {
            return amount;
        }

        public void setAmount(float amount) {
            this.amount = amount;
        }

        public String getTimeStamp() {return  time_stamp;}

        public void setTimeStamp(String time_stamp){this.time_stamp = time_stamp;}

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


