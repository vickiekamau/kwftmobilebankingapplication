package com.example.administrator.kwft.activity.Balance;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.administrator.kwft.R;
import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Kwft;
import com.example.administrator.kwft.utils.PreferenceUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Balance extends AppCompatActivity {
     public TextView accType,bal,accno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        accType = findViewById(R.id.account_type);
        bal = findViewById(R.id.txt_amount);
        accno = findViewById(R.id.accNo);
        int acc = PreferenceUtils.getAccountNo(this);
        getBalance(acc);
    }

      public void getBalance(final int account_no){
       // balanceView.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Kwft> call = apiInterface.getBalance(account_no);
        call.enqueue(new Callback<Kwft>() {
            @Override
            public void onResponse(@NonNull Call<Kwft> call, @NonNull Response<Kwft> response) {
                // balanceView.hideProgress();
                Kwft kwft = response.body();
                if (kwft != null) {
                    if (kwft.getAccount_no() > 0) {
                        accno.setText(String.valueOf(kwft.getAccount_no()));
                        accType.setText(kwft.getAccount_type());
                        bal.setText(String.valueOf(kwft.getBalance()));
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Kwft> call, @NonNull Throwable t) {

            }
        });

    }
}
