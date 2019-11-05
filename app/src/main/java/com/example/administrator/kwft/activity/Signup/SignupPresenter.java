package com.example.administrator.kwft.activity.Signup;

import android.support.annotation.NonNull;
import com.example.administrator.kwft.api.ApiClient;
import com.example.administrator.kwft.api.ApiInterface;
import com.example.administrator.kwft.model.Kwft;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupPresenter {
    private SignupView signupView;
    public SignupPresenter(SignupView signupView) {
        this.signupView = signupView;
    }
    void createAccount(final String name,final String account_type,final String email,final String phone_no,final int id_number,final int address,final String location){
        signupView.showProgress();
        ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class);
        Call<Kwft> call = apiInterface.createAccount(name,account_type,email,phone_no,id_number,address,location);
        call.enqueue(new Callback<Kwft>() {
            @Override
            public void onResponse(@NonNull Call<Kwft> call, @NonNull Response<Kwft> response) {
                signupView.hideProgress();
                if(response.isSuccessful() && response.body() != null){
                    Boolean success = response.body().getSuccess();
                    if(success){
                        signupView.onAddSuccess(response.body().getMessage());
                        // Toast.makeText(EditorActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        // finish();//back to main activity
                    } else{
                        signupView.onAddError(response.body().getMessage());
                        //Toast.makeText(EditorActivity.this,response.body().getMessage(),Toast.LENGTH_SHORT).show();
                        // if the error still exists
                    }
                }
            }

            @Override
            public void onFailure(@NonNull Call<Kwft> call, @NonNull Throwable t) {
                signupView.hideProgress();
                signupView.onAddError(t.getLocalizedMessage());
                //Toast.makeText(EditorActivity.this,t.getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                //finish();
            }
        });

    }
}
