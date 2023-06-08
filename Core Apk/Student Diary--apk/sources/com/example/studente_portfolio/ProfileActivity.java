package com.example.studente_portfolio;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.SetOptions;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;
import de.hdodenhof.circleimageview.CircleImageView;
import java.util.HashMap;
import java.util.Map;
import jp.wasabeef.picasso.transformations.BlurTransformation;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    Button buttonsave;
    /* access modifiers changed from: private */
    public FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    ImageButton printbtn;
    TextView txtEmail;
    TextView txtFaculty;
    EditText txt_desc;
    TextView txtmatric;
    TextView txtname;
    FirebaseUser user;
    String userID;

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_profile);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.userID = this.mAuth.getCurrentUser().getUid();
        this.user = this.mAuth.getCurrentUser();
        Toolbar toolbar = (Toolbar) findViewById(R.id.profiletoolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((CharSequence) null);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileActivity.this.startActivity(new Intent(ProfileActivity.this, HomeActivity.class));
                ProfileActivity.this.finish();
                ProfileActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() != R.id.action_settings) {
                    return false;
                }
                ProfileActivity.this.startActivity(new Intent(ProfileActivity.this, SettingsActivity.class));
                ProfileActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                return false;
            }
        });
        ImageButton imageButton = (ImageButton) findViewById(R.id.print_btn);
        this.printbtn = imageButton;
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ProfileActivity.this.startActivity(new Intent(ProfileActivity.this, CreateCV.class));
                ProfileActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
        onStart();
    }

    public void onStart() {
        super.onStart();
        this.txtname = (TextView) findViewById(R.id.profile_name);
        this.txtmatric = (TextView) findViewById(R.id.profile_matric);
        this.txtEmail = (TextView) findViewById(R.id.profile_email);
        this.txtFaculty = (TextView) findViewById(R.id.profile_Faculty);
        this.txt_desc = (EditText) findViewById(R.id.tlt_description);
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://student-diary-7ce7d.appspot.com");
        StorageReference riversRef = storageReference.child("myICON:(" + this.user.getUid() + ")");
        final CircleImageView kecil = (CircleImageView) findViewById(R.id.profile_image);
        final ImageView besar = (ImageView) findViewById(R.id.headerp);
        final BlurTransformation transformation1 = new BlurTransformation(this);
        riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            public void onSuccess(Uri uri) {
                String imageURL = uri.toString();
                Picasso.get().load(imageURL).into((ImageView) kecil);
                Picasso.get().load(imageURL).transform((Transformation) transformation1).fit().into(besar);
            }
        });
        Button button = (Button) findViewById(R.id.buttonprofilesave);
        this.buttonsave = button;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                DocumentReference documentReference = ProfileActivity.this.fstore.collection("resume").document(ProfileActivity.this.userID);
                Map<String, Object> user = new HashMap<>();
                user.put("aboutme", ProfileActivity.this.txt_desc.getText().toString());
                Log.e(ProfileActivity.TAG, "About me : " + user.toString());
                documentReference.set(user, SetOptions.merge());
                Snackbar.make(ProfileActivity.this.findViewById(R.id.profileForm), (CharSequence) "Descriptions Added", 0).show();
            }
        });
        this.fstore.collection("users").document(this.user.getUid()).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                ProfileActivity.this.txtname.setText(documentSnapshot.getString("fullname"));
                ProfileActivity.this.txtmatric.setText(documentSnapshot.getString("idmatric"));
                ProfileActivity.this.txtEmail.setText(documentSnapshot.getString("email"));
                ProfileActivity.this.txtFaculty.setText(documentSnapshot.getString("faculty"));
            }
        });
        this.fstore.collection("resume").document(this.user.getUid()).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                ProfileActivity.this.txt_desc.setText(documentSnapshot.getString("aboutme"));
            }
        });
    }
}
