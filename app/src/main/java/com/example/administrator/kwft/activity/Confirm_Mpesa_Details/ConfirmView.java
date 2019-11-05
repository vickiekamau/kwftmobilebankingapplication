package com.example.administrator.kwft.activity.Confirm_Mpesa_Details;

public interface ConfirmView {
    void showProgress();
    void hideProgress();
    void onAddSuccess(String message);
    void onAddError(String  message);
}
