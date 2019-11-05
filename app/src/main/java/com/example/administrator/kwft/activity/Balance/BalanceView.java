package com.example.administrator.kwft.activity.Balance;

public interface BalanceView {
    void showProgress();
    void hideProgress();
    void onAddSuccess(String message);
    void onAddError(String  message);
}
