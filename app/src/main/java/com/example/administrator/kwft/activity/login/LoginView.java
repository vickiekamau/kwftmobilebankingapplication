package com.example.administrator.kwft.activity.login;

public interface LoginView {
    void showProgress();
    void hideProgress();
    void onAddSuccess(String message);
    void onAddError(String  message);
}
