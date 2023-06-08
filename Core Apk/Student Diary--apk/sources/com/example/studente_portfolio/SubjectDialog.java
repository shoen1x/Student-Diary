package com.example.studente_portfolio;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class SubjectDialog extends AppCompatActivity {
    private static final String TAG = "TAG";
    /* access modifiers changed from: private */
    public FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    Button savesubject;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.dialog_new_subject);
        onStart();
        Button button = (Button) findViewById(R.id.savesubject);
        this.savesubject = button;
        final TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.subjectname);
        final TextInputEditText textInputEditText2 = (TextInputEditText) findViewById(R.id.subjectid);
        final TextInputEditText textInputEditText3 = (TextInputEditText) findViewById(R.id.subjectsec);
        final TextInputEditText textInputEditText4 = (TextInputEditText) findViewById(R.id.lecturername);
        final Spinner spinner = (Spinner) findViewById(R.id.spinnersemester);
        AnonymousClass1 r8 = r0;
        final Spinner spinner2 = (Spinner) findViewById(R.id.spinnercredit);
        AnonymousClass1 r0 = new View.OnClickListener() {
            public void onClick(View v) {
                DocumentReference documentReference = SubjectDialog.this.fstore.collection("subject").document(SubjectDialog.this.user.getUid()).collection("mySubject").document();
                Map<String, Object> user = new HashMap<>();
                user.put("subname", textInputEditText.getText().toString());
                user.put("subid", textInputEditText2.getText().toString());
                user.put("subsec", textInputEditText3.getText().toString());
                user.put("sublec", textInputEditText4.getText().toString());
                user.put("subsem", spinner.getSelectedItem().toString());
                user.put("subcredit", spinner2.getSelectedItem().toString());
                user.put("checkrecord", 0);
                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    public void onSuccess(Void aVoid) {
                        Log.d(SubjectDialog.TAG, "onsuccess: User profile is created for " + SubjectDialog.this.userID);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    public void onFailure(Exception e) {
                        Log.w(SubjectDialog.TAG, "Error adding document", e);
                    }
                });
                SubjectDialog.this.finish();
            }
        };
        button.setOnClickListener(r8);
    }

    public void onStart() {
        super.onStart();
        getWindow().getDecorView().setSystemUiVisibility(5892);
        String[] arraycredit = {"0.75", "1", "1.5", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4"};
        ArrayAdapter<String> adaptersemeter = new ArrayAdapter<>(this, 17367048, new String[]{"Semester 0", "Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5"});
        adaptersemeter.setDropDownViewResource(17367049);
        ((Spinner) findViewById(R.id.spinnersemester)).setAdapter(adaptersemeter);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, 17367048, arraycredit);
        arrayAdapter.setDropDownViewResource(17367049);
        ((Spinner) findViewById(R.id.spinnercredit)).setAdapter(arrayAdapter);
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
