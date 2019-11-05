package com.example.administrator.kwft.activity.Confirm_Mpesa_Details;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Customer;
import com.example.administrator.kwft.model.Kwft;
import com.example.administrator.kwft.utils.PreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SendMyNumber extends AppCompatActivity {
    private TextView OtherNumber,phoneno;
    private EditText amount;
    private Button sendMoney;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_my_number);
        OtherNumber = findViewById(R.id.otherNo);
        amount = findViewById(R.id.amount);
        sendMoney = findViewById(R.id.bt_sendMoney);
        phoneno = findViewById(R.id.phoneNo);
        int acc = PreferenceUtils.getAccountNo(this);
        String accu = String.valueOf(acc);
        Log.w("Account Number 1:",accu);
        getPhoneNo(acc);
        OtherNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SendMyNumber.this,MobileMoney.class));
                finish();
            }
        });
        sendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setPhone();
                getAmount();
                startActivity(new Intent(SendMyNumber.this,ConfirmDetails.class));
                finish();
            }
        });


    }
    public void getPhoneNo(final int account_no){
        // balanceView.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Customer> call = apiInterface.getPhone(account_no);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(@NonNull Call<Customer> call, @NonNull Response<Customer> response) {
                // balanceView.hideProgress();
                Customer customer = response.body();
                if (customer != null) {
                    if (customer.getAccount_no() > 0) {
                        phoneno.setText(customer.getPhone_no());
                        String ac = String.valueOf(customer.getAccount_no());
                        Log.w("Account Number Is ",ac);
                        //accType.setText(kwft.getAccount_type());
                        //bal.setText(String.valueOf(kwft.getBalance()));
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Customer> call, @NonNull Throwable t) {

            }
        });

    }

    public String setPhone(){
        String phone = phoneno.getText().toString().trim();
        //int phoneNo = Integer.parseInt(phone);
        // String account = String.valueOf(phoneNo);
        PreferenceUtils.saveAccountTo(phone,this);
        Log.w("Account Number 2:",phone);
        return phone;
    }
    public int getAmount(){
        String cash = amount.getText().toString().trim();
        int amount = Integer.parseInt(cash);
        String account_amount = String.valueOf(amount);
        PreferenceUtils.saveAmount(amount,this);
        Log.w("Money:",account_amount);
        return amount;
    }
}
