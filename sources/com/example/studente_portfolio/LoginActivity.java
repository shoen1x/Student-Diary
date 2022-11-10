package com.example.studente_portfolio;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private final AppCompatActivity activity = this;
    AlertDialogManager alert = new AlertDialogManager();
    CheckBox checkBox;
    private FirebaseFirestore fstore;
    /* access modifiers changed from: private */
    public FirebaseAuth mAuth;
    ImageButton signin;
    Button signup;
    EditText txtemail;
    EditText txtpassword;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_login);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        if (new InternetDialog(this).getInternetStatus()) {
            Snackbar.make(findViewById(R.id.loginForm), (CharSequence) "Welcome to Student Diary", 0).show();
        } else {
            Snackbar snackbar = Snackbar.make(findViewById(R.id.loginForm), (CharSequence) "No internet connection!", 8000).setAction((CharSequence) "RETRY", (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    Intent i = LoginActivity.this.getBaseContext().getPackageManager().getLaunchIntentForPackage(LoginActivity.this.getBaseContext().getPackageName());
                    i.addFlags(67108864);
                    LoginActivity.this.startActivity(i);
                    LoginActivity.this.finish();
                }
            });
            View view = snackbar.getView();
            snackbar.show();
        }
        ((TextView) findViewById(R.id.resetpasswordtxt)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    LoginActivity.this.onResetPassword();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        onStart();
        onClickButtonListener();
    }

    public void onResetPassword() {
        final Dialog dialogReset = new Dialog(this, R.style.PauseDialog);
        dialogReset.setContentView(R.layout.activity_resetpassword_dialog);
        dialogReset.setCancelable(true);
        dialogReset.setCanceledOnTouchOutside(true);
        dialogReset.findViewById(R.id.btnresetpass).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                final EditText emailresettxt = (EditText) dialogReset.findViewById(R.id.emailresetedittxt);
                if (emailresettxt.getText().equals("")) {
                    Toast.makeText(LoginActivity.this, "Email Cannot be empty", 0).show();
                    return;
                }
                LoginActivity.this.mAuth.sendPasswordResetEmail(emailresettxt.getText().toString()).addOnSuccessListener(new OnSuccessListener<Void>() {
                    public void onSuccess(Void aVoid) {
                        Log.i(LoginActivity.TAG, "Successful Send email reset password for " + emailresettxt.getText().toString());
                    }
                });
                dialogReset.dismiss();
            }
        });
        dialogReset.show();
    }

    public void onStart() {
        super.onStart();
        this.txtemail = (EditText) findViewById(R.id.txtmatric);
        this.txtpassword = (EditText) findViewById(R.id.txtpassword);
        this.signin = (ImageButton) findViewById(R.id.signin);
        this.mAuth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            public void onAuthStateChanged(FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = LoginActivity.this.mAuth.getCurrentUser();
                if (mFirebaseUser == null) {
                    Log.d(LoginActivity.TAG, "onAuthStateChanged: Login Display Successfully | account null");
                } else if (LoginActivity.this.mAuth.getCurrentUser().isEmailVerified()) {
                    Log.d(LoginActivity.TAG, "onAuthStateChanged: Login Successfully" + mFirebaseUser.getDisplayName());
                    LoginActivity.this.startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {
                    Log.d(LoginActivity.TAG, "Email Not Verified, please verify your email first");
                }
            }
        });
        this.signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if (LoginActivity.this.txtemail.getText().toString().trim().length() <= 0 || LoginActivity.this.txtpassword.getText().toString().trim().length() <= 0) {
                    LoginActivity.this.alert.showAlertDialog(LoginActivity.this, "Login Failed.", "Please enter username and password", false);
                    LoginActivity.this.txtpassword.setText("");
                    return;
                }
                LoginActivity.this.mAuth.signInWithEmailAndPassword(LoginActivity.this.txtemail.getText().toString(), LoginActivity.this.txtpassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    public void onComplete(Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Snackbar.make(LoginActivity.this.findViewById(16908290), (CharSequence) "Error Fetching data, Please try again", 0).show();
                            LoginActivity.this.txtpassword.setText("");
                        } else if (LoginActivity.this.mAuth.getCurrentUser().isEmailVerified()) {
                            LoginActivity.this.startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                        } else {
                            Snackbar.make(LoginActivity.this.findViewById(16908290), (CharSequence) "Please verify your email first", 0).show();
                        }
                    }
                });
            }
        });
    }

    public void onClickButtonListener() {
        this.txtemail = (EditText) findViewById(R.id.email);
        this.txtpassword = (EditText) findViewById(R.id.password);
        this.checkBox = (CheckBox) findViewById(R.id.checkbox);
        this.signin = (ImageButton) findViewById(R.id.signin);
        this.signup = (Button) findViewById(R.id.signup);
        this.signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(LoginActivity.this, "Sign In Button Clicked", 1).show();
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                LoginActivity.this.finish();
            }
        });
        this.signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
                LoginActivity.this.finish();
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        finishAffinity();
        finish();
    }
}
