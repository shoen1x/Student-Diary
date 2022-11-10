package com.example.studente_portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SplashActivity extends AppCompatActivity {
    private static final int STORAGE_PERMISSION_CODE = 101;
    private FirebaseFirestore fstore;
    /* access modifiers changed from: private */
    public FirebaseAuth mAuth;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        getWindow().getDecorView().setSystemUiVisibility(5894);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                SplashActivity.this.checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", 101);
                ActivityCompat.requestPermissions(SplashActivity.this, new String[]{"android.permission.READ_EXTERNAL_STORAGE"}, 9);
                SplashActivity.this.updateUI(SplashActivity.this.mAuth.getCurrentUser());
            }
        }, 1);
    }

    public void updateUI(FirebaseUser account) {
        if (account != null) {
            startActivity(new Intent(this, HomeActivity.class));
        } else {
            startActivity(new Intent(this, GetStarted.class));
        }
    }

    public void checkPermission(String permission, int requestCode) {
        if (ContextCompat.checkSelfPermission(this, permission) == -1) {
            ActivityCompat.requestPermissions(this, new String[]{permission}, requestCode);
            return;
        }
        Toast.makeText(this, "Permission already granted", 0).show();
    }

    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != 101) {
            return;
        }
        if (grantResults.length <= 0 || grantResults[0] != 0) {
            Toast.makeText(this, "Storage Permission Denied", 0).show();
        } else {
            Toast.makeText(this, "Storage Permission Granted", 0).show();
        }
    }
}
