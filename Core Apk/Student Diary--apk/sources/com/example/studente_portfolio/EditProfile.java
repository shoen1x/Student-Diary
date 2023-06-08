package com.example.studente_portfolio;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.HashMap;
import java.util.Map;

public class EditProfile extends AppCompatActivity {
    private Uri filePath;
    FirebaseFirestore fstore;
    CircleImageView imageView;
    FirebaseAuth mAuth;
    Toolbar toolbar;
    FirebaseUser userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_edit_profile);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.userID = this.mAuth.getCurrentUser();
        this.imageView = (CircleImageView) findViewById(R.id.profile_image);
        onStart();
        ((ImageView) findViewById(R.id.changeimgbtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditProfile.this.imagechooser();
            }
        });
    }

    /* access modifiers changed from: private */
    public void imagechooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction("android.intent.action.GET_CONTENT");
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 438);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 438 && resultCode == -1 && data != null && data.getData() != null) {
            this.filePath = data.getData();
            uploadFile();
        }
    }

    public void onStart() {
        super.onStart();
        TextInputEditText fullname = (TextInputEditText) findViewById(R.id.fullnameinput);
        TextInputEditText email = (TextInputEditText) findViewById(R.id.emailinput);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.passwordchangeinput);
        DocumentReference documentReference = this.fstore.collection("users").document(this.userID.getUid());
        final TextInputEditText textInputEditText = (TextInputEditText) findViewById(R.id.usernameinput);
        final TextInputEditText textInputEditText2 = fullname;
        final TextInputEditText textInputEditText3 = email;
        final TextInputEditText textInputEditText4 = password;
        documentReference.addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                textInputEditText.setText(documentSnapshot.getString("fname"));
                textInputEditText2.setText(documentSnapshot.getString("fullname"));
                textInputEditText3.setText(documentSnapshot.getString("email"));
                textInputEditText4.setText(documentSnapshot.getString("pass"));
            }
        });
        final TextInputEditText textInputEditText5 = password;
        final TextInputEditText textInputEditText6 = fullname;
        final TextInputEditText textInputEditText7 = email;
        ((ImageButton) findViewById(R.id.saveeditprofile)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DocumentReference documentReference = EditProfile.this.fstore.collection("users").document(EditProfile.this.userID.getUid());
                Map<String, Object> user = new HashMap<>();
                user.put("fname", textInputEditText.getText().toString());
                user.put("pass", textInputEditText5.getText().toString());
                user.put("fullname", textInputEditText6.getText().toString());
                user.put("email", textInputEditText7.getText().toString());
                documentReference.update(user);
            }
        });
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://student-diary-7ce7d.appspot.com");
        storageReference.child("myICON:(" + this.userID.getUid() + ")").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri.toString()).into((ImageView) EditProfile.this.imageView);
            }
        });
        Toolbar toolbar2 = (Toolbar) findViewById(R.id.editprofiletoolbar);
        this.toolbar = toolbar2;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((CharSequence) null);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditProfile.this.startActivity(new Intent(EditProfile.this, SettingsActivity.class));
                EditProfile.this.finish();
            }
        });
    }

    private void uploadFile() {
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        if (this.filePath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();
            storageReference.child("myICON:(" + this.userID.getUid() + ")").putFile(this.filePath).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<UploadTask.TaskSnapshot>() {
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    progressDialog.dismiss();
                    Toast.makeText(EditProfile.this, "File Uploaded ", 1).show();
                }
            }).addOnFailureListener((OnFailureListener) new OnFailureListener() {
                public void onFailure(Exception exception) {
                    progressDialog.dismiss();
                    Toast.makeText(EditProfile.this, exception.getMessage(), 1).show();
                }
            }).addOnProgressListener((OnProgressListener) new OnProgressListener<UploadTask.TaskSnapshot>() {
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (((double) taskSnapshot.getBytesTransferred()) * 100.0d) / ((double) taskSnapshot.getTotalByteCount());
                    ProgressDialog progressDialog = progressDialog;
                    progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                }
            });
        }
    }
}
