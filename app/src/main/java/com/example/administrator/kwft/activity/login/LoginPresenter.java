package com.example.administrator.kwft.activity.login;

import android.support.annotation.NonNull;

import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Kwft;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter {
    private LoginView loginView;
    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
    }
    void loginAccount(final int account_no,final int pin){
        loginView.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Kwft> call = apiInterface.loginAccount(account_no,pin);
        call.enqueue(new Callback<Kwft>() {
            @Override
            public void onResponse(@NonNull Call<Kwft> call, @NonNull Response<Kwft> response) {
                loginView.hideProgress();
                if(response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getSuccess();
                    if(success){
                        loginView.onAddSuccess(response.body().getMessage());
                        // Toast.makeText(EditorActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        // finish();//back to main activity
                    } else{
                        loginView.onAddError(response.body().getMessage());
                        //Toast.makeText(EditorActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        // if the error still exists
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Kwft> call, @NonNull Throwable t) {
                loginView.hideProgress();
                loginView.onAddError(t.getLocalizedMessage());
                //Toast.makeText(EditorActivity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                //finish();
            }
        });

    }
}
