package com.example.studente_portfolio;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.studente_portfolio.model.Subject;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AttendanceActivity extends AppCompatActivity {
    private static final String TAG = "TAG";
    TextView datedd;
    TextView datemm;
    FirebaseFirestore fstore;
    FirebaseAuth mAuth;
    String month;
    FirestoreRecyclerAdapter<Subject, AttendanceViewHolder> subAdapter;
    RecyclerView subjectLists;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_attendance);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        toolbarfunction();
        this.datedd = (TextView) findViewById(R.id.datedd);
        this.datemm = (TextView) findViewById(R.id.datemm);
        this.datedd.setText(getDateDay());
        if (getDateMonth().equals("01")) {
            this.month = "Jan";
        } else if (getDateMonth().equals("02")) {
            this.month = "Feb";
        } else if (getDateMonth().equals("03")) {
            this.month = "Mar";
        } else if (getDateMonth().equals("04")) {
            this.month = "Apr";
        } else if (getDateMonth().equals("05")) {
            this.month = "May";
        } else if (getDateMonth().equals("06")) {
            this.month = "Jun";
        } else if (getDateMonth().equals("07")) {
            this.month = "Jul";
        } else if (getDateMonth().equals("08")) {
            this.month = "Aug";
        } else if (getDateMonth().equals("09")) {
            this.month = "Sep";
        } else if (getDateMonth().equals("10")) {
            this.month = "Oct";
        } else if (getDateMonth().equals("11")) {
            this.month = "Nov";
        } else {
            this.month = "Dec";
        }
        this.datemm.setText(this.month);
        ((Button) findViewById(R.id.checkattendance)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttendanceActivity.this.startActivity(new Intent(AttendanceActivity.this, CheckAttendance.class));
            }
        });
        this.subAdapter = new FirestoreRecyclerAdapter<Subject, AttendanceViewHolder>(new FirestoreRecyclerOptions.Builder().setQuery(this.fstore.collection("subject").document(this.user.getUid()).collection("mySubject").orderBy("subid", Query.Direction.ASCENDING), Subject.class).build()) {
            /* access modifiers changed from: protected */
            public void onBindViewHolder(final AttendanceViewHolder attendanceViewHolder, int i, final Subject subject) {
                attendanceViewHolder.subName.setText(subject.getSubname());
                attendanceViewHolder.subInfo.setText(subject.getSubid());
                attendanceViewHolder.selectbtn.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(AttendanceActivity.this);
                        builder1.setMessage((CharSequence) "Submit new attendance for subject " + subject.getSubname() + " | " + attendanceViewHolder.checkbtn.getText());
                        builder1.setCancelable(true);
                        builder1.setPositiveButton((CharSequence) "Yes", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM", Locale.getDefault());
                                Date date = new Date();
                                DocumentReference dctref = AttendanceActivity.this.fstore.collection("subject").document(AttendanceActivity.this.user.getUid()).collection("mySubject").document(AttendanceActivity.this.user.getUid()).collection("checkattrib").document();
                                attendanceViewHolder.selectbtn.setBackgroundColor(Color.parseColor("#008000"));
                                attendanceViewHolder.selectbtn.setText("Submitted!");
                                attendanceViewHolder.checkbtn.setVisibility(4);
                                Map<String, Object> user = new HashMap<>();
                                user.put("subName", subject.getSubname());
                                if (attendanceViewHolder.checkbtn.isChecked()) {
                                    user.put("checkrecord", 1);
                                } else {
                                    user.put("checkrecord", 0);
                                }
                                user.put("datecheck", dateFormat.format(date));
                                dctref.set(user);
                                dialog.cancel();
                            }
                        });
                        builder1.setNegativeButton((CharSequence) "No", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                        builder1.create().show();
                    }
                });
            }

            public AttendanceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new AttendanceViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.attendance_view_layout, parent, false));
            }
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.subjectlistattendance);
        this.subjectLists = recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        this.subjectLists.setAdapter(this.subAdapter);
    }

    public class AttendanceViewHolder extends RecyclerView.ViewHolder {
        ToggleButton checkbtn;
        CardView mCardView;
        Button selectbtn;
        TextView subInfo;
        TextView subName;
        View view;

        public AttendanceViewHolder(View itemView) {
            super(itemView);
            this.subName = (TextView) itemView.findViewById(R.id.subviewname);
            this.subInfo = (TextView) itemView.findViewById(R.id.subinfo);
            this.selectbtn = (Button) itemView.findViewById(R.id.selectbtn);
            this.checkbtn = (ToggleButton) itemView.findViewById(R.id.checkbtn);
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
        FirestoreRecyclerAdapter<Subject, AttendanceViewHolder> firestoreRecyclerAdapter = this.subAdapter;
        if (firestoreRecyclerAdapter != null) {
            firestoreRecyclerAdapter.stopListening();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }

    private String getDateDay() {
        return new SimpleDateFormat("dd", Locale.getDefault()).format(new Date());
    }

    private String getDateMonth() {
        return new SimpleDateFormat("MM", Locale.getDefault()).format(new Date());
    }

    public void toolbarfunction() {
        Toolbar tbschedule = (Toolbar) findViewById(R.id.attendancetoolbar);
        setSupportActionBar(tbschedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Attendance");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tbschedule.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                AttendanceActivity.this.startActivity(new Intent(AttendanceActivity.this.getApplicationContext(), HomeActivity.class));
                AttendanceActivity.this.finish();
            }
        });
    }
}
