package com.example.administrator.kwft.activity.Signup;

public interface SignupView {
    void showProgress();
    void hideProgress();
    void onAddSuccess(String message);
    void onAddError(String  message);
}
