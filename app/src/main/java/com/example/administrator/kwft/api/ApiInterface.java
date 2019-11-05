package com.example.administrator.kwft.api;

import com.example.administrator.kwft.model.Account;
import com.example.administrator.kwft.model.Customer;
import com.example.administrator.kwft.model.Kwft;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {



    @FormUrlEncoded
    @POST("registerCustomer.php")
    Call<Kwft> createAccount(
            @Field("name") String name,
            @Field("account_type") String account_type,
            @Field("email") String email,
            @Field("phone_no") String  phone_no,
            @Field("id_number") int id_number,
            @Field("address") int address,
            @Field("location") String location
    );
    @FormUrlEncoded
    @POST("login.php")
    Call<Kwft> loginAccount(
            @Field("account_no") int account_no,
            @Field("pin") int pin
    );

    @POST("kwftaccountinfo.php")
    Call<List<Account>> getAccountName(
    );

    @POST("statement.php")
    Call<List<Account>> getStatement(
    );


    @FormUrlEncoded
    @POST("transaction.php")
    Call<Kwft> transaction(
            @Field("account_no") int account_no,
            @Field("amount") int amount,
            @Field("account_to") String account_to
    );

    @FormUrlEncoded
    @POST("setAccountNo.php")
    Call<Kwft> getBalance(
            @Field("account_no") int account_no
    );
    @FormUrlEncoded
    @POST("statement.php")
    Call<Account> Statement(
            @Field("account_no") int account_no
    );
    @FormUrlEncoded
    @POST("getPhoneNo.php")
    Call<Customer> getPhone(
            @Field("account_no") int account_no
    );

}
