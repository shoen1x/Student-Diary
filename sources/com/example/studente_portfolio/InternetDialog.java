package com.example.studente_portfolio;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.View;

public class InternetDialog {
    private Context context;

    public InternetDialog(Context context2) {
        this.context = context2;
    }

    public void showNoInternetDialog() {
        final Dialog dialog1 = new Dialog(this.context, R.style.df_dialog);
        dialog1.setContentView(R.layout.dialog_no_internet);
        dialog1.setCancelable(true);
        dialog1.setCanceledOnTouchOutside(true);
        dialog1.findViewById(R.id.btnSpinAndWinRedeem).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                dialog1.dismiss();
            }
        });
        dialog1.show();
    }

    public boolean getInternetStatus() {
        NetworkInfo activeNetwork = ((ConnectivityManager) this.context.getSystemService("connectivity")).getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
        if (!isConnected) {
            showNoInternetDialog();
        }
        return isConnected;
    }
}
