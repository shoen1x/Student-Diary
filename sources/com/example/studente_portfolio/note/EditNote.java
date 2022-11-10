package com.example.studente_portfolio.note;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.studente_portfolio.MainActivity;
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

public class EditNote extends AppCompatActivity {
    Intent data;
    EditText editNoteContent;
    EditText editNoteTitle;
    FirebaseFirestore fStore;
    ProgressBar spinner;
    FirebaseUser user;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_edit_note);
        setSupportActionBar((Toolbar) findViewById(R.id.notetoolbaredit));
        this.fStore = FirebaseFirestore.getInstance();
        this.spinner = (ProgressBar) findViewById(R.id.progressBar2);
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        this.data = getIntent();
        this.editNoteContent = (EditText) findViewById(R.id.editNoteContent);
        this.editNoteTitle = (EditText) findViewById(R.id.editNoteTitle);
        String noteTitle = this.data.getStringExtra("title");
        String noteContent = this.data.getStringExtra(FirebaseAnalytics.Param.CONTENT);
        this.editNoteTitle.setText(noteTitle);
        this.editNoteContent.setText(noteContent);
        ((FloatingActionButton) findViewById(R.id.saveEditedNote)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String nTitle = EditNote.this.editNoteTitle.getText().toString();
                String nContent = EditNote.this.editNoteContent.getText().toString();
                if (nTitle.isEmpty() || nContent.isEmpty()) {
                    Toast.makeText(EditNote.this, "Can not Save note with Empty Field.", 0).show();
                    return;
                }
                EditNote.this.spinner.setVisibility(0);
                DocumentReference docref = EditNote.this.fStore.collection("notes").document(EditNote.this.user.getUid()).collection("myNotes").document(EditNote.this.data.getStringExtra("noteId"));
                Map<String, Object> note = new HashMap<>();
                note.put("title", nTitle);
                note.put(FirebaseAnalytics.Param.CONTENT, nContent);
                docref.update(note).addOnSuccessListener(new OnSuccessListener<Void>() {
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(EditNote.this, "Note Saved.", 0).show();
                        EditNote.this.startActivity(new Intent(EditNote.this.getApplicationContext(), MainActivity.class));
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    public void onFailure(Exception e) {
                        Toast.makeText(EditNote.this, "Error, Try again.", 0).show();
                        EditNote.this.spinner.setVisibility(0);
                    }
                });
            }
        });
    }
}
