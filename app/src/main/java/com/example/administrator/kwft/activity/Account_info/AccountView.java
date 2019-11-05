package com.example.administrator.kwft.activity.Account_info;

import com.example.administrator.kwft.model.Account;

import java.util.List;

public interface AccountView {
       void showLoading();
        void hideLoading();
        void onGetResult(List<Account> accounts);
        void onErrorLoading(String  message);


    }

