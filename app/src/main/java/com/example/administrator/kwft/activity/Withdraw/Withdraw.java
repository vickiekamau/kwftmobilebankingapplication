package com.example.administrator.kwft.activity.Withdraw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.activity.Confirm_Mpesa_Details.MobileMoney;

public class Withdraw extends AppCompatActivity {
    ImageView mobileMoney;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_withdraw);
        mobileMoney = findViewById(R.id.ic_mobilePayments);
        mobileMoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Withdraw.this,MobileMoney.class));
                finish();
            }
        });
    }
}
