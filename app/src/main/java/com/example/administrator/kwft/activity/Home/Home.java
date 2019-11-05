package com.example.administrator.kwft.activity.Home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.activity.Account_info.AccountActivity;
import com.example.administrator.kwft.activity.Balance.Balance;
import com.example.administrator.kwft.activity.Confirm_Mpesa_Details.MobileMoney;
import com.example.administrator.kwft.activity.Withdraw.Withdraw;

public class Home extends AppCompatActivity {
    ImageView account,balance,transfer,mpesa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        account = (ImageView) findViewById(R.id.ic_account);
        balance = (ImageView) findViewById(R.id.ic_balance);
        transfer = (ImageView) findViewById(R.id.ic_transfer);
        mpesa = (ImageView) findViewById(R.id.ic_mpesa);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,AccountActivity.class));
            }
        });
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Withdraw.class));
            }
        });
        balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,Balance.class));
            }
        });
        mpesa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home.this,MobileMoney.class));
            }
        });
    }
}
