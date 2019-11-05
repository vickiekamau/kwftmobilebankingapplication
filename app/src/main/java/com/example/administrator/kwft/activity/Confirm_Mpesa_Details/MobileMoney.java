package com.example.administrator.kwft.activity.Confirm_Mpesa_Details;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.utils.PreferenceUtils;

public class MobileMoney extends AppCompatActivity {
     EditText phoneNumber,cash_amount;
     TextView myNumber;
     Button sendMoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_money);
        phoneNumber = findViewById(R.id.phoneNo);
        cash_amount = findViewById(R.id.amount);
        sendMoney = findViewById(R.id.bt_sendMoney);
        sendMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //phoneNo.setText("");
                //amount.setText("");
                getPhoneNo();
                getAmount();
                startActivity(new Intent(MobileMoney.this,ConfirmDetails.class));
                finish();

            }
        });
        myNumber = findViewById(R.id.myNo);
        myNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MobileMoney.this,SendMyNumber.class));
                finish();
            }
        });
    }

    public String getPhoneNo() {
        String phone = phoneNumber.getText().toString().trim();
        //int phoneNo = Integer.parseInt(phone);
       // String account = String.valueOf(phoneNo);
        PreferenceUtils.saveAccountTo(phone,this);
        Log.w("Account Number:",phone);
            return phone;
        }
    public int getAmount(){
        String cash = cash_amount.getText().toString().trim();
        int amount = Integer.parseInt(cash);
        String account_amount = String.valueOf(amount);
        PreferenceUtils.saveAmount(amount,this);
        Log.w("Money:",account_amount);
        return amount;
    }
}
