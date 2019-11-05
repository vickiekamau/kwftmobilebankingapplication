package com.example.administrator.kwft.activity.login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.activity.Account_info.AccountView;
import com.example.administrator.kwft.activity.Home.Home;
import com.example.administrator.kwft.activity.Signup.Signup;
import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.utils.PreferenceUtils;

public class Login extends AppCompatActivity implements LoginView{

    private Button login,register;
    private EditText accountNo,pin;
    ProgressDialog progressDialog;
    LoginPresenter loginPresenter;
    ApiInterface apiInterface;
    private String account_name;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login =findViewById(R.id.login);
        accountNo =findViewById(R.id.accno);
        pin = findViewById(R.id.pin);
        register = findViewById(R.id.signup);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accLogin();

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Login.this,Signup.class));
            }
        });

        //progress Dialog
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Login Account...");

        loginPresenter = new LoginPresenter(this);

    }

    public void accLogin(){
        String account_no = accountNo.getText().toString().trim();
        String acc_pin = pin.getText().toString().trim();


         if(account_no.isEmpty()){
             accountNo.setError("Account Number is required");
             accountNo.requestFocus();
         }
         else if(acc_pin.isEmpty()){
             pin.setError("Pin is required");
             pin.requestFocus();
         }
         else {
             int acc_no = Integer.parseInt(account_no);
             int ac_pin = Integer.parseInt(acc_pin);
             loginPresenter.loginAccount(acc_no,ac_pin);
             PreferenceUtils.saveAccountNo(acc_no,this);
             PreferenceUtils.savePin(ac_pin,this);
         }

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
        Toast.makeText(Login.this,
                "Welcome "+message,
                Toast.LENGTH_SHORT).show();
                PreferenceUtils.saveAccountName(message,this);
                Log.w("The account name is:", message);
                accountNo.setText("");
                pin.setText("");
                startActivity(new Intent(Login.this,Home.class));

    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(Login.this,
                message,
                Toast.LENGTH_SHORT).show();
    }

}
