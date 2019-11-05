package com.example.administrator.kwft.activity.Confirm_Mpesa_Details;

import android.support.annotation.NonNull;

import com.example.administrator.kwft.activity.login.LoginView;
import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Kwft;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfirmDetailsPresenter {
    private ConfirmView confirmView;
    public ConfirmDetailsPresenter(ConfirmView confirmView) {
        this.confirmView = confirmView;
    }
    void transaction(final int account_no,final int amount,final String account_to){
        confirmView.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Kwft> call = apiInterface.transaction(account_no,amount,account_to);
        call.enqueue(new Callback<Kwft>() {
            @Override
            public void onResponse(@NonNull Call<Kwft> call, @NonNull Response<Kwft> response) {
                confirmView.hideProgress();
                if(response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getSuccess();
                    if(success){
                        confirmView.onAddSuccess(response.body().getMessage());
                        // Toast.makeText(EditorActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        // finish();//back to main activity
                    } else{
                        confirmView.onAddError(response.body().getMessage());
                        //Toast.makeText(EditorActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        // if the error still exists
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Kwft> call, @NonNull Throwable t) {
                confirmView.hideProgress();
                confirmView.onAddError(t.getLocalizedMessage());
                //Toast.makeText(EditorActivity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                //finish();
            }
        });

    }
}
