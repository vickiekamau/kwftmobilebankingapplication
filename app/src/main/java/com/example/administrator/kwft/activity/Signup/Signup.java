package com.example.administrator.kwft.activity.Signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.activity.Home.Home;
import com.example.administrator.kwft.activity.login.Login;

public class Signup extends AppCompatActivity implements SignupView {

    Button register;
    EditText idNo,accountName,email,phoneNo,address,location;
    AutoCompleteTextView accountType;
    ProgressDialog progressDialog;
    SignupPresenter signupPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        idNo = findViewById(R.id.idno);
        accountName = findViewById(R.id.accname);
        accountType = findViewById(R.id.acctype);
        email = findViewById(R.id.email);
        phoneNo = findViewById(R.id.phoneno);
        address = findViewById(R.id.address);
        location = findViewById(R.id.location);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Signup.this,android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.accounttype));
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        accountType.setAdapter(arrayAdapter);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering Customer......");


        signupPresenter = new SignupPresenter(this);

        register = findViewById(R.id.signup);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAcc();
            }
        });

    }
    public void createAcc() {
        String account_name = accountName.getText().toString().trim();
        String account_type = accountType.getText().toString().trim();
        String emailCust = email.getText().toString().trim();
        String phone = phoneNo.getText().toString().trim();
        String id = idNo.getText().toString().trim();
        String addressNo = address.getText().toString().trim();
        String locationCust = location.getText().toString().trim();

        if (account_name.isEmpty()) {
            accountName.setError("Enter Your Name");
            accountName.requestFocus();
        } else if (account_type.isEmpty()) {
            accountType.setError("Choose Type Of Account You Want");
            accountType.requestFocus();
        }
        else if (emailCust.isEmpty()) {
            email.setError("Enter Your Email Address");
            email.requestFocus();
        }else if (phone.isEmpty()) {
            phoneNo.setError("Enter Your Phone Number");
            phoneNo.requestFocus();
        }
        else   if (id.isEmpty()) {
            idNo.setError("Enter Your Id Number");
            idNo.requestFocus();
        }
        else if (addressNo.isEmpty()) {
            address.setError("Enter Your Address");
            address.requestFocus();
        }
        else if (locationCust.isEmpty()) {
            location.setError("Enter Your Residence Location");
            location.requestFocus();
        }
        else {
            int custId = Integer.parseInt(id);
            //int custPhone = Integer.parseInt(phone);
            //String no = String.valueOf(custPhone);
            Log.w("phone number:",phone);
            int custAddress = Integer.parseInt(addressNo);
            signupPresenter.createAccount(account_name, account_type,emailCust,phone,custId,custAddress,locationCust);
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
        Toast.makeText(Signup.this,
                message,
                Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Signup.this,Login.class));

    }

    @Override
    public void onAddError(String message) {
        Toast.makeText(Signup.this,
                message,
                Toast.LENGTH_SHORT).show();
    }
}
