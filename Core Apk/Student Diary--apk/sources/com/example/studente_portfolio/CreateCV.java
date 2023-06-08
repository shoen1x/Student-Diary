package com.example.studente_portfolio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import java.util.HashMap;
import java.util.Map;

public class CreateCV extends AppCompatActivity {
    private static final String TAG = "TAG";
    private FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    EditText resaddress;
    EditText rescompdesc;
    EditText rescompjobposition;
    EditText rescomplocation;
    EditText rescompname;
    EditText reseducdesc;
    EditText reseduclevel;
    EditText reseducname;
    EditText resemail;
    EditText reslanguages;
    EditText resname;
    EditText resphone;
    EditText resskills;
    Button savebtn;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_create_c_v);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        this.resname = (EditText) findViewById(R.id.resname);
        this.resemail = (EditText) findViewById(R.id.resEmail);
        this.resaddress = (EditText) findViewById(R.id.resAddr);
        this.resskills = (EditText) findViewById(R.id.resSkills);
        this.resphone = (EditText) findViewById(R.id.resPhone);
        this.reslanguages = (EditText) findViewById(R.id.resLanguage);
        this.rescompname = (EditText) findViewById(R.id.resCompname);
        this.rescomplocation = (EditText) findViewById(R.id.resLocation);
        this.rescompjobposition = (EditText) findViewById(R.id.resPosition);
        this.rescompdesc = (EditText) findViewById(R.id.resExpDesc);
        this.reseducname = (EditText) findViewById(R.id.resEducName);
        this.reseduclevel = (EditText) findViewById(R.id.resEduclvl);
        this.reseducdesc = (EditText) findViewById(R.id.resEduDesc);
        Button button = (Button) findViewById(R.id.resSave);
        this.savebtn = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CreateCV.this.onSaveButton();
                CreateCV.this.startActivity(new Intent(CreateCV.this, CreateCVPreview.class));
            }
        });
        this.fstore.collection("resume").document(this.user.getUid()).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                CreateCV.this.resaddress.setText(documentSnapshot.getString("address"));
                CreateCV.this.resskills.setText(documentSnapshot.getString("skills"));
                CreateCV.this.reslanguages.setText(documentSnapshot.getString("languages"));
                CreateCV.this.rescompname.setText(documentSnapshot.getString("compname"));
                CreateCV.this.rescomplocation.setText(documentSnapshot.getString("comploc"));
                CreateCV.this.rescompjobposition.setText(documentSnapshot.getString("compposition"));
                CreateCV.this.rescompdesc.setText(documentSnapshot.getString("compdesc"));
                CreateCV.this.reseducname.setText(documentSnapshot.getString("educname"));
                CreateCV.this.reseduclevel.setText(documentSnapshot.getString("educlvl"));
                CreateCV.this.reseducdesc.setText(documentSnapshot.getString("educdesc"));
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.fstore.collection("users").document(this.user.getUid()).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                CreateCV.this.resname.setText(documentSnapshot.getString("fullname"));
                CreateCV.this.resphone.setText(documentSnapshot.getString("phone"));
                CreateCV.this.resemail.setText(documentSnapshot.getString("email"));
            }
        });
    }

    public void onSaveButton() {
        this.userID = this.mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = this.fstore.collection("resume").document(this.userID);
        Map<String, Object> user2 = new HashMap<>();
        user2.put("fullname", this.resname.getText().toString());
        user2.put("address", this.resaddress.getText().toString());
        user2.put("skills", this.resskills.getText().toString());
        user2.put("email", this.resemail.getText().toString());
        user2.put("phone", this.resphone.getText().toString());
        user2.put("languages", this.reslanguages.getText().toString());
        user2.put("compname", this.rescompname.getText().toString());
        user2.put("comploc", this.rescomplocation.getText().toString());
        user2.put("compposition", this.rescompjobposition.getText().toString());
        user2.put("compdesc", this.rescompdesc.getText().toString());
        user2.put("educname", this.reseducname.getText().toString());
        user2.put("educlvl", this.reseduclevel.getText().toString());
        user2.put("educdesc", this.reseducdesc.getText().toString());
        documentReference.set(user2, SetOptions.merge()).addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void aVoid) {
                Log.d(CreateCV.TAG, "onsuccess: User profile is created for " + CreateCV.this.userID);
                CreateCV.this.startActivity(new Intent(CreateCV.this, CreateCVPreview.class));
                CreateCV.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception e) {
                Log.w(CreateCV.TAG, "Error adding document", e);
            }
        });
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }
}
