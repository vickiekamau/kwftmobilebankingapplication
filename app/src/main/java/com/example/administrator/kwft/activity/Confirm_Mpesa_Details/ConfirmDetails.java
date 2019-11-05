package com.example.administrator.kwft.activity.Confirm_Mpesa_Details;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.activity.Withdraw.Withdraw;
import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Kwft;
import com.example.administrator.kwft.utils.PreferenceUtils;

import java.util.List;

import retrofit2.Call;

public class ConfirmDetails extends AppCompatActivity implements ConfirmView {
    ConfirmDetailsPresenter confirmDetailsPresenter;
    MobileMoney mobileMoney;
    TextView phone,amount;
    Button proceed,cancel;
    ProgressDialog progressDialog;
    List<Kwft> kwft;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_details);
        phone = findViewById(R.id.phone);
        amount = findViewById(R.id.cash);
        proceed = findViewById(R.id.btn_proceed);
        cancel = findViewById(R.id.btn_cancel);
        //myNo = findViewById(R.id.myNo);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Processing Transaction...");

        mobileMoney = new MobileMoney();
        confirmDetailsPresenter = new ConfirmDetailsPresenter(this);
        int acc = PreferenceUtils.getAccountNo(this);
        int cash = PreferenceUtils.getAmount(this);
        String phoneNo = PreferenceUtils.getAccountTo(this);
        Log.w("Account Send To:",String.valueOf(phoneNo));
        Log.w("Amount Send To:",String.valueOf(cash));
        Log.w("From :",String.valueOf(acc));
        phone.setText(phoneNo);
        amount.setText(String.valueOf(cash));


        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               commitTransaction();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ConfirmDetails.this,Withdraw.class));
                finish();
            }
        });

     }

    public void commitTransaction(){
        int acc = PreferenceUtils.getAccountNo(this);
       int cash = PreferenceUtils.getAmount(this);
        String phoneNo = PreferenceUtils.getAccountTo(this);

        //float cash = 6000;
        //int phoneNo = 0720;
        String account = String.valueOf(acc);
        String cash_amount = String.valueOf(cash);
        String account_to = String.valueOf(phoneNo);
        Log.w("Account Number:",account);
        Log.w("Cash:",cash_amount);
        Log.w("Accounted To:",account_to);

       confirmDetailsPresenter.transaction(acc,cash,phoneNo);
    }

    @Override
    public void showProgress() {
      progressDialog.show();
    }

    @Override
    public void hideProgress() {
     progressDialog.hide();
    }

    @Override
    public void onAddSuccess(String message) {
        Toast.makeText(ConfirmDetails.this,
                message,
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(ConfirmDetails.this,Withdraw.class));
        finish();

    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(ConfirmDetails.this,
                message,
                Toast.LENGTH_SHORT).show();

        startActivity(new Intent(ConfirmDetails.this,Withdraw.class));
        finish();
    }

}
