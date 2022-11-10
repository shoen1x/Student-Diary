package com.example.studente_portfolio;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.studente_portfolio.model.CheckAttd;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class CheckAttendance extends AppCompatActivity {
    private static final String TAG = "TAG";
    int absence = 0;
    String absencestr;
    int attend = 0;
    String attendstr;
    FirestoreRecyclerAdapter<CheckAttd, CheckAttendanceViewHolder> checkAttdAdapter;
    FirebaseFirestore fstore;
    FirebaseAuth mAuth;
    RecyclerView subjectLists;
    FirebaseUser user;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_check_attendance);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        ((Button) findViewById(R.id.chkattdcancelbtn)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckAttendance.this.finish();
            }
        });
        this.checkAttdAdapter = new FirestoreRecyclerAdapter<CheckAttd, CheckAttendanceViewHolder>(new FirestoreRecyclerOptions.Builder().setQuery(this.fstore.collection("subject").document(this.user.getUid()).collection("mySubject").document(this.user.getUid()).collection("checkattrib").orderBy("datecheck", Query.Direction.ASCENDING), CheckAttd.class).build()) {
            /* access modifiers changed from: protected */
            public void onBindViewHolder(CheckAttendanceViewHolder checkAttendanceViewHolder, int i, CheckAttd checkAttd) {
                checkAttendanceViewHolder.subName.setText(checkAttd.getSubName() + " | " + checkAttd.getDatecheck());
                if (checkAttd.getCheckrecord() == 1) {
                    checkAttendanceViewHolder.mCardView.setCardBackgroundColor(Color.parseColor("#008000"));
                    CheckAttendance.this.attend++;
                    CheckAttendance checkAttendance = CheckAttendance.this;
                    checkAttendance.attendstr = String.valueOf(checkAttendance.attend);
                    Log.i(CheckAttendance.TAG, "Attend : " + CheckAttendance.this.attend + CheckAttendance.this.attendstr);
                    ((TextView) CheckAttendance.this.findViewById(R.id.attdreportattend)).setText("Attend : " + CheckAttendance.this.attend + " Class(es)");
                } else if (checkAttd.getCheckrecord() == 0) {
                    checkAttendanceViewHolder.mCardView.setCardBackgroundColor(Color.parseColor("#FF0000"));
                    CheckAttendance.this.absence++;
                    CheckAttendance checkAttendance2 = CheckAttendance.this;
                    checkAttendance2.absencestr = String.valueOf(checkAttendance2.absence);
                    Log.i(CheckAttendance.TAG, "Absence : " + CheckAttendance.this.absence + CheckAttendance.this.absencestr);
                    ((TextView) CheckAttendance.this.findViewById(R.id.attdreportabsence)).setText("Absence : " + CheckAttendance.this.absence + " Class(es)");
                }
            }

            public CheckAttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new CheckAttendanceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.checkattendance_view_layout, parent, false));
            }
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.checkattdrecycle);
        this.subjectLists = recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        this.subjectLists.setAdapter(this.checkAttdAdapter);
    }

    public class CheckAttendanceViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView subName;
        View view;

        public CheckAttendanceViewHolder(View itemView) {
            super(itemView);
            this.subName = (TextView) itemView.findViewById(R.id.subviewname);
            this.mCardView = (CardView) itemView.findViewById(R.id.subCard);
            this.view = itemView;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.checkAttdAdapter.startListening();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        FirestoreRecyclerAdapter<CheckAttd, CheckAttendanceViewHolder> firestoreRecyclerAdapter = this.checkAttdAdapter;
        if (firestoreRecyclerAdapter != null) {
            firestoreRecyclerAdapter.stopListening();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }
}
