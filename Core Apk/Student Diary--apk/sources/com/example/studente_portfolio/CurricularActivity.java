package com.example.studente_portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.studente_portfolio.model.Curriculum;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class CurricularActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    RecyclerView curriculumLists;
    /* access modifiers changed from: private */
    public FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    FirestoreRecyclerAdapter<Curriculum, CurriculumViewHolder> subAdapter;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_curricular);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = this.mAuth.getCurrentUser();
        Toolbar toolbarcuri = (Toolbar) findViewById(R.id.toolbarcuri);
        setSupportActionBar(toolbarcuri);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Curriculum Achievement");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbarcuri.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CurricularActivity.this.startActivity(new Intent(CurricularActivity.this.getApplicationContext(), HomeActivity.class));
                CurricularActivity.this.finish();
            }
        });
        ((Button) findViewById(R.id.addcurricular)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CurricularActivity.this.startActivity(new Intent(CurricularActivity.this, curricularAdd.class));
                CurricularActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
        this.subAdapter = new FirestoreRecyclerAdapter<Curriculum, CurriculumViewHolder>(new FirestoreRecyclerOptions.Builder().setQuery(this.fstore.collection("academic").document(this.user.getUid()).collection("myAcademic").orderBy("activname", Query.Direction.ASCENDING), Curriculum.class).build()) {
            /* access modifiers changed from: protected */
            public void onBindViewHolder(CurriculumViewHolder curriculumViewHolder, final int i, Curriculum curriculum) {
                curriculumViewHolder.subName.setText(curriculum.getActivName());
                curriculumViewHolder.subInfo.setText(curriculum.getActivAchiv());
                curriculumViewHolder.subinfo2.setText(curriculum.getActivDesc());
                ((ImageView) curriculumViewHolder.view.findViewById(R.id.activities_settings)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        final String docId = ((DocumentSnapshot) CurricularActivity.this.subAdapter.getSnapshots().getSnapshot(i)).getId();
                        PopupMenu menu = new PopupMenu(v.getContext(), v);
                        menu.setGravity(GravityCompat.END);
                        menu.getMenu().add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                CurricularActivity.this.fstore.collection("academic").document(CurricularActivity.this.user.getUid()).collection("myAcademic").document(docId).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    public void onSuccess(Void aVoid) {
                                        CurricularActivity.this.user.delete();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    public void onFailure(Exception e) {
                                        Toast.makeText(CurricularActivity.this, "Error in Deleting Activities.", 0).show();
                                    }
                                });
                                return false;
                            }
                        });
                        menu.show();
                    }
                });
            }

            public CurriculumViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new CurriculumViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activities_view_layout, parent, false));
            }
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.curriculumcycle);
        this.curriculumLists = recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        this.curriculumLists.setAdapter(this.subAdapter);
    }

    public class CurriculumViewHolder extends RecyclerView.ViewHolder {
        ImageView activities_settings;
        CardView mCardView;
        TextView subInfo;
        TextView subName;
        TextView subinfo2;
        View view;

        public CurriculumViewHolder(View itemView) {
            super(itemView);
            this.subName = (TextView) itemView.findViewById(R.id.subviewname);
            this.subInfo = (TextView) itemView.findViewById(R.id.subinfo);
            this.subinfo2 = (TextView) itemView.findViewById(R.id.subinfo2);
            this.activities_settings = (ImageView) itemView.findViewById(R.id.activities_settings);
            this.mCardView = (CardView) itemView.findViewById(R.id.subCard);
            this.view = itemView;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.subAdapter.startListening();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        FirestoreRecyclerAdapter<Curriculum, CurriculumViewHolder> firestoreRecyclerAdapter = this.subAdapter;
        if (firestoreRecyclerAdapter != null) {
            firestoreRecyclerAdapter.stopListening();
        }
    }
}
