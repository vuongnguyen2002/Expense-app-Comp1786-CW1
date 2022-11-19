package com.example.myappfirst;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

public class LoadingAlert {
    Activity activity;
    AlertDialog dialog;
    LoadingAlert(Activity myActivity){
        activity =myActivity;
    }
    void startAlertdialog(){
        AlertDialog.Builder builder=new AlertDialog.Builder(activity);
        LayoutInflater inflater =activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.dialog,null));
        builder.setCancelable(true);
        dialog=builder.create();
        dialog.show();
    }
    void HiddenDialog(){
        dialog.dismiss();
    }
}
