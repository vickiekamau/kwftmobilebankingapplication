package com.example.administrator.kwft.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {
    public PreferenceUtils(){

    }
    public static boolean saveAccountNo(int accountNo,Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(Constants.KEY_ACCOUNTNO, accountNo);
        prefsEditor.apply();
        return true;
    }
    public static int getAccountNo(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(Constants.KEY_ACCOUNTNO,0);

    }

    public static boolean saveAccountName(String account_name,Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(Constants.KEY_ACCOUNTNAME,account_name);
        prefsEditor.apply();
        return true;
    }
    public static String getAccountName(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Constants.KEY_ACCOUNTNAME,null);
    }
    public static boolean savePin(int pin,Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(Constants.KEY_PIN, pin);
        prefsEditor.apply();
        return true;
    }
    public static int getPin(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(Constants.KEY_PIN,0);
    }
    public static boolean saveAmount(int amount,Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putInt(Constants.KEY_AMOUNT,amount);
        prefsEditor.apply();
        return true;
    }
    public static int getAmount(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getInt(Constants.KEY_AMOUNT,0);
    }
    public static boolean saveAccountTo(String account_to,Context context) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(Constants.KEY_ACCOUNTTO, account_to);
        prefsEditor.apply();
        return true;
    }
    public static String getAccountTo(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Constants.KEY_ACCOUNTTO,null);

    }
    public static boolean savePhoneNo(String phone_no,Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor prefsEditor = sharedPreferences.edit();
        prefsEditor.putString(Constants.KEY_PHONENO,phone_no);
        prefsEditor.apply();
        return true;
    }
    public static String getPhoneNo(Context context){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPreferences.getString(Constants.KEY_PHONENO,null);
    }
}

