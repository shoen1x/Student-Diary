package com.example.studente_portfolio.note;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.studente_portfolio.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.HashMap;
import java.util.Map;

public class AddNote extends AppCompatActivity {
    FirebaseFirestore fStore;
    EditText noteContent;
    EditText noteTitle;
    ProgressBar progressBarSave;
    FirebaseUser user;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_add_note);
        setSupportActionBar((Toolbar) findViewById(R.id.noteToolbarAdd));
        this.fStore = FirebaseFirestore.getInstance();
        this.noteContent = (EditText) findViewById(R.id.addNoteContent);
        this.noteTitle = (EditText) findViewById(R.id.addNoteTitle);
        this.progressBarSave = (ProgressBar) findViewById(R.id.progressBar);
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String nTitle = AddNote.this.noteTitle.getText().toString();
                String nContent = AddNote.this.noteContent.getText().toString();
                if (nTitle.isEmpty() || nContent.isEmpty()) {
                    Toast.makeText(AddNote.this, "Can not Save note with Empty Field.", 0).show();
                    return;
                }
                AddNote.this.progressBarSave.setVisibility(0);
                DocumentReference docref = AddNote.this.fStore.collection("notes").document(AddNote.this.user.getUid()).collection("myNotes").document();
                Map<String, Object> note = new HashMap<>();
                note.put("title", nTitle);
                note.put(FirebaseAnalytics.Param.CONTENT, nContent);
                docref.set(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(AddNote.this, "Note Added.", 0).show();
                        AddNote.this.onBackPressed();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    public void onFailure(Exception e) {
                        Toast.makeText(AddNote.this, "Error, Try again.", 0).show();
                        AddNote.this.progressBarSave.setVisibility(0);
                    }
                });
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.close_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.close) {
            Toast.makeText(this, "Not Saved.", 0).show();
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
