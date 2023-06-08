package com.example.studente_portfolio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.net.HttpHeaders;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    private final AppCompatActivity activity = this;
    TextView agree;
    AlertDialogManager alert = new AlertDialogManager();
    CheckBox checkBox;
    EditText confirmpassword;
    EditText email;
    EditText faculty;
    /* access modifiers changed from: private */
    public FirebaseFirestore fstore;
    EditText idmatric;
    /* access modifiers changed from: private */
    public FirebaseAuth mAuth;
    EditText name;
    EditText password;
    EditText phonenum;
    Button submit;
    Toolbar toolbar;
    private FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_signup);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.notetoolbardetails);
        this.toolbar = toolbar2;
        toolbar2.setNavigationIcon((int) R.drawable.ic_arrow_back_black_24dp);
        onCreate();
        onStart();
        EditText idmatric2 = (EditText) findViewById(R.id.idmatric);
        EditText faculty2 = (EditText) findViewById(R.id.faculty);
        EditText email2 = (EditText) findViewById(R.id.email);
        EditText password2 = (EditText) findViewById(R.id.password);
        EditText confirmpassword2 = (EditText) findViewById(R.id.confirmpassword);
        EditText name2 = (EditText) findViewById(R.id.name);
        EditText phonenum2 = (EditText) findViewById(R.id.phonenum);
        if (this.mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            finish();
        }
        final EditText editText = name2;
        final EditText editText2 = idmatric2;
        final EditText editText3 = faculty2;
        final EditText editText4 = password2;
        final EditText editText5 = confirmpassword2;
        final EditText editText6 = phonenum2;
        AnonymousClass1 r10 = r0;
        final EditText editText7 = email2;
        EditText editText8 = idmatric2;
        Button submitbtn = (Button) findViewById(R.id.submitbtn);
        final CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkbox);
        AnonymousClass1 r0 = new View.OnClickListener() {
            public void onClick(View arg0) {
                if (editText.getText().toString().trim().equals("")) {
                    editText.setError("Enter your username");
                }
                if (editText2.getText().toString().trim().equals("")) {
                    editText2.setError("Enter your Unique Matric ID, ex:CC00001");
                }
                if (editText3.getText().toString().trim().equals("")) {
                    editText3.setError("Enter your faculty ex: FKOM");
                }
                if (editText4.getText().toString().trim().equals("")) {
                    editText4.setError("Enter your password between 9-12, one uppercase and symbol");
                }
                if (editText5.getText().toString().trim().equals("")) {
                    editText5.setError("Password not match!");
                }
                if (editText6.getText().toString().trim().equals("")) {
                    editText6.setError("Enter your Phone number");
                }
                if (editText7.getText().toString().trim().equals("")) {
                    editText7.setError("Enter your email, ex: david12@gmail.com");
                }
                if (editText2.getText().toString().trim().equals("") || editText3.getText().toString().trim().equals("") || editText7.getText().toString().trim().equals("") || editText4.getText().toString().trim().equals("") || editText5.getText().toString().trim().equals("") || editText.getText().toString().trim().equals("") || editText6.getText().toString().trim().equals("")) {
                    Toast.makeText(SignUpActivity.this.getApplicationContext(), "Please fulfill all the information", 1).show();
                } else if (checkBox2.isChecked()) {
                    SignUpActivity.this.mAuth.createUserWithEmailAndPassword(editText7.getText().toString(), editText4.getText().toString()).addOnCompleteListener((Activity) SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                        public void onComplete(Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignUpActivity.this.getApplicationContext(), "Unsuccessful Process, please try again!", 1).show();
                                return;
                            }
                            Toast.makeText(SignUpActivity.this.getApplicationContext(), "Successfully created", 1).show();
                            SignUpActivity.this.userID = SignUpActivity.this.mAuth.getCurrentUser().getUid();
                            DocumentReference documentReference = SignUpActivity.this.fstore.collection("users").document(SignUpActivity.this.userID);
                            Map<String, Object> user = new HashMap<>();
                            user.put("idmatric", editText2.getText().toString());
                            user.put("fname", editText.getText().toString());
                            user.put("fullname", "");
                            user.put("pass", editText4.getText().toString());
                            user.put("phone", editText6.getText().toString());
                            user.put("email", editText7.getText().toString());
                            user.put("faculty", editText3.getText().toString());
                            documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                public void onSuccess(Void aVoid) {
                                    Log.d(SignUpActivity.TAG, "onsuccess: User profile is created for " + SignUpActivity.this.userID);
                                    SignUpActivity.this.sendVerificationEmail();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                public void onFailure(Exception e) {
                                    Log.w(SignUpActivity.TAG, "Error adding document", e);
                                }
                            });
                        }
                    });
                } else {
                    Toast.makeText(SignUpActivity.this.getApplicationContext(), "Check Terms and conditions", 1).show();
                }
            }
        };
        submitbtn.setOnClickListener(r10);
    }

    /* access modifiers changed from: private */
    public void sendVerificationEmail() {
        FirebaseAuth.getInstance().getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
            public void onComplete(Task<Void> task) {
                if (task.isSuccessful()) {
                    FirebaseAuth.getInstance().signOut();
                    SignUpActivity.this.startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                    SignUpActivity.this.finish();
                    return;
                }
                SignUpActivity.this.overridePendingTransition(0, 0);
                SignUpActivity.this.finish();
                SignUpActivity.this.overridePendingTransition(0, 0);
                SignUpActivity signUpActivity = SignUpActivity.this;
                signUpActivity.startActivity(signUpActivity.getIntent());
            }
        });
    }

    public void onCreate() {
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.notetoolbardetails);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SignUpActivity.this.startActivity(new Intent(SignUpActivity.this.getApplicationContext(), LoginActivity.class));
                SignUpActivity.this.finish();
            }
        });
    }

    public void onButtonShowPopupWindowClick(View view) {
        startActivity(new Intent(getApplicationContext(), agreement.class));
    }

    public void onBackPressed() {
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle(HttpHeaders.WARNING);
        alertdialog.setMessage("Are you sure to cancel the sign up process?");
        alertdialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                SignUpActivity.this.startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
                SignUpActivity.this.finish();
            }
        });
        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog create = alertdialog.create();
        alertdialog.show();
    }

    private void emptyInputEditText() {
        this.name.setText((CharSequence) null);
        this.email.setText((CharSequence) null);
        this.password.setText((CharSequence) null);
        this.confirmpassword.setText((CharSequence) null);
        this.faculty.setText((CharSequence) null);
        this.phonenum.setText((CharSequence) null);
        this.idmatric.setText((CharSequence) null);
    }
}
