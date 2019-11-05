package com.example.administrator.kwft.activity.Account_info;

import android.support.annotation.NonNull;

import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Account;
import com.example.administrator.kwft.model.Kwft;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class  AccountPresenter {
    private AccountView accountView;

    public AccountPresenter(AccountView accountView) {
        this.accountView = accountView;
    }

    void statement() {
        accountView.showLoading();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<List<Account>> call = apiInterface.getStatement();
        call.enqueue(new Callback<List<Account>>() {
            @Override
            public void onResponse(@NonNull Call<List<Account>> call, @NonNull Response<List<Account>> response) {
                accountView.hideLoading();
                if (response.isSuccessful() && response.body() != null) {
                    accountView.onGetResult(response.body());

                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Account>> call, @NonNull Throwable t) {
                accountView.hideLoading();
                accountView.onErrorLoading(t.getLocalizedMessage());
            }
        });
    }
}
