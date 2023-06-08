package com.example.studente_portfolio;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class curricularAdd extends AppCompatActivity {
    private static final String TAG = "TAG";
    TextInputEditText activachiv;
    TextInputEditText activdesc;
    TextInputEditText activname;
    Button buttonsavecuri;
    private FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_curricular_add);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        this.activname = (TextInputEditText) findViewById(R.id.activname);
        this.activachiv = (TextInputEditText) findViewById(R.id.activachiv);
        this.activdesc = (TextInputEditText) findViewById(R.id.activdesc);
        Button button = (Button) findViewById(R.id.activitiessave);
        this.buttonsavecuri = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                curricularAdd.this.starting();
            }
        });
    }

    public void starting() {
        if (this.activname == null && this.activachiv == null) {
            Snackbar.make(findViewById(16908290), (CharSequence) "Activities name or Achievement cannot be empty!", 0).show();
            return;
        }
        this.userID = this.mAuth.getCurrentUser().getUid();
        DocumentReference documentReference = this.fstore.collection("academic").document(this.user.getUid()).collection("myAcademic").document();
        Map<String, Object> user2 = new HashMap<>();
        user2.put("activname", this.activname.getText().toString());
        user2.put("activachiv", this.activachiv.getText().toString());
        user2.put("activdesc", this.activdesc.getText().toString());
        documentReference.set(user2).addOnSuccessListener(new OnSuccessListener<Void>() {
            public void onSuccess(Void aVoid) {
                Log.d(curricularAdd.TAG, "onsuccess: User profile is created for " + curricularAdd.this.userID);
                curricularAdd.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                curricularAdd.this.finish();
            }
        }).addOnFailureListener(new OnFailureListener() {
            public void onFailure(Exception e) {
                Log.w(curricularAdd.TAG, "Error adding document", e);
            }
        });
    }
}
