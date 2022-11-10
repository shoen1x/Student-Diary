package com.example.studente_portfolio;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.studente_portfolio.model.Subject;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

public class AcademicActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    FloatingActionButton floatbtn;
    private FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    TextView name;
    Spinner s;
    FirestoreRecyclerAdapter<Subject, SubjectViewHolder> subAdapter;
    RecyclerView subjectLists;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_academic);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = this.mAuth.getCurrentUser();
        toolbarfunction();
        spinner();
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.floatbtn);
        this.floatbtn = floatingActionButton;
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AcademicActivity.this.startActivity(new Intent(AcademicActivity.this, SubjectDialog.class));
                AcademicActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
        this.name = (TextView) findViewById(R.id.titlename);
        this.userID = this.mAuth.getCurrentUser().getUid();
        this.fstore.collection("users").document(this.userID).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                TextView textView = AcademicActivity.this.name;
                textView.setText(documentSnapshot.getString("fname") + ", " + documentSnapshot.getString("idmatric"));
            }
        });
        this.subAdapter = new FirestoreRecyclerAdapter<Subject, SubjectViewHolder>(new FirestoreRecyclerOptions.Builder().setQuery(this.fstore.collection("subject").document(this.user.getUid()).collection("mySubject").orderBy("subid", Query.Direction.ASCENDING), Subject.class).build()) {
            /* access modifiers changed from: protected */
            public void onBindViewHolder(SubjectViewHolder SubjectViewHolder, int i, Subject subject) {
                TextView textView = SubjectViewHolder.subName;
                textView.setText(subject.getSubname() + " | " + subject.getSubid());
                TextView textView2 = SubjectViewHolder.subInfo;
                textView2.setText("Lecturer : " + subject.getSublec() + ", Section: " + subject.getSubsec() + " | Credit Hour: " + subject.getSubcredit());
                String id = ((DocumentSnapshot) AcademicActivity.this.subAdapter.getSnapshots().getSnapshot(i)).getId();
            }

            public SubjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new SubjectViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.subject_view_layout, parent, false));
            }
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.subjectlist);
        this.subjectLists = recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.subjectLists.setAdapter(this.subAdapter);
    }

    public void spinner() {
        this.s = (Spinner) findViewById(R.id.academicspinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, 17367048, new String[]{"Semester 0", "Semester 1", "Semester 2", "Semester 3", "Semester 4", "Semester 5"});
        adapter.setDropDownViewResource(17367048);
        this.s.setAdapter(adapter);
    }

    public class SubjectViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView subInfo;
        TextView subName;
        View view;

        public SubjectViewHolder(View itemView) {
            super(itemView);
            this.subName = (TextView) itemView.findViewById(R.id.subviewname);
            this.subInfo = (TextView) itemView.findViewById(R.id.subinfo);
            this.mCardView = (CardView) itemView.findViewById(R.id.subCard);
            this.view = itemView;
        }
    }

    public void toolbarfunction() {
        Toolbar tbschedule = (Toolbar) findViewById(R.id.academictoolbar);
        setSupportActionBar(tbschedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Academic Subject");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tbschedule.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AcademicActivity.this.startActivity(new Intent(AcademicActivity.this.getApplicationContext(), HomeActivity.class));
                AcademicActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                AcademicActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.subAdapter.startListening();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        FirestoreRecyclerAdapter<Subject, SubjectViewHolder> firestoreRecyclerAdapter = this.subAdapter;
        if (firestoreRecyclerAdapter != null) {
            firestoreRecyclerAdapter.stopListening();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }
}
