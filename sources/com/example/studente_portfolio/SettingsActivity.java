package com.example.studente_portfolio;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.HashMap;
import java.util.Map;

public class SettingsActivity extends AppCompatActivity {
    FirebaseFirestore fstore;
    Spinner language;
    FirebaseAuth mAuth;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_settings);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.userID = this.mAuth.getCurrentUser().getUid();
        spinner();
        ((ConstraintLayout) findViewById(R.id.editprofileconstraint)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SettingsActivity.this.startActivity(new Intent(SettingsActivity.this, EditProfile.class));
            }
        });
        ((ConstraintLayout) findViewById(R.id.changepasswordconstraint)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SettingsActivity.this.startActivity(new Intent(SettingsActivity.this, EditProfile.class));
            }
        });
        ((ConstraintLayout) findViewById(R.id.TellYourFriendconstraint)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent sharingIntent = new Intent("android.intent.action.SEND");
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra("android.intent.extra.SUBJECT", "Student Diary");
                sharingIntent.putExtra("android.intent.extra.TEXT", "Hey, Let's use this awesome Student Diary apps! https://google.com/student-diary");
                SettingsActivity.this.startActivity(Intent.createChooser(sharingIntent, "Share using"));
            }
        });
        final Switch notificationswitch = (Switch) findViewById(R.id.Notificationswitch);
        final Switch appnoswitch = (Switch) findViewById(R.id.appnoswitch);
        this.fstore.collection("users").document(this.userID).collection("settings").document(this.userID).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (documentSnapshot.getString("notification").equals("true")) {
                    notificationswitch.setChecked(true);
                    appnoswitch.setChecked(true);
                    return;
                }
                notificationswitch.setChecked(false);
                appnoswitch.setChecked(false);
            }
        });
        notificationswitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appnoswitch.setChecked(true);
                    DocumentReference documentReference = SettingsActivity.this.fstore.collection("users").document(SettingsActivity.this.userID).collection("settings").document(SettingsActivity.this.userID);
                    Map<String, Object> user = new HashMap<>();
                    user.put("notification", "true");
                    documentReference.set(user);
                    return;
                }
                appnoswitch.setChecked(false);
                DocumentReference documentReference2 = SettingsActivity.this.fstore.collection("users").document(SettingsActivity.this.userID).collection("settings").document(SettingsActivity.this.userID);
                Map<String, Object> user2 = new HashMap<>();
                user2.put("notification", "false");
                documentReference2.update(user2);
            }
        });
        onFunctionLogout();
    }

    public void onFunctionLogout() {
        ((TextView) findViewById(R.id.signoutsettings)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SettingsActivity.this.onLogout();
            }
        });
        ((ImageView) findViewById(R.id.logouticon)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SettingsActivity.this.onLogout();
            }
        });
    }

    public void spinner() {
        this.language = (Spinner) findViewById(R.id.languagespinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 17367048, new String[]{"English", "Bahasa Melayu", "Jawi"});
        adapter.setDropDownViewResource(17367048);
        this.language.setAdapter(adapter);
        this.language.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                if (!SettingsActivity.this.language.getSelectedItem().equals("English")) {
                    if (SettingsActivity.this.language.getSelectedItem().equals("Bahasa Melayu")) {
                        Snackbar.make(SettingsActivity.this.findViewById(R.id.settings_form), (CharSequence) "Coming Soon", 0).show();
                    } else {
                        Snackbar.make(SettingsActivity.this.findViewById(R.id.settings_form), (CharSequence) "Experimental Version | For Developer only", 0).show();
                    }
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    public void onLogout() {
        super.onStart();
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("Log Out?");
        alertdialog.setMessage("Are you Sure?");
        alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                SettingsActivity.this.mAuth.signOut();
                SettingsActivity.this.startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
            }
        });
        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog create = alertdialog.create();
        alertdialog.show();
    }
}
