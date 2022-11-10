package com.example.studente_portfolio;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.applandeo.materialcalendarview.CalendarView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class schedule_add extends AppCompatActivity {
    private static final String TAG = "TAG";
    EditText eventaddtime;
    EditText eventdesctext;
    EditText eventnametext;
    /* access modifiers changed from: private */
    public FirebaseFirestore fstore;
    /* access modifiers changed from: private */
    public FirebaseAuth mAuth;
    SimpleDateFormat sdhh = new SimpleDateFormat("hh", Locale.getDefault());
    SimpleDateFormat sdmm = new SimpleDateFormat("mm", Locale.getDefault());
    SimpleDateFormat sdq = new SimpleDateFormat("dd", Locale.getDefault());
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_schedule_add);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = FirebaseAuth.getInstance().getCurrentUser();
        this.eventnametext = (EditText) findViewById(R.id.eventnametext);
        this.eventdesctext = (EditText) findViewById(R.id.eventdesctext);
        this.eventaddtime = (EditText) findViewById(R.id.eventaddtime);
        final CalendarView datePicker = (CalendarView) findViewById(R.id.adddate);
        ((Button) findViewById(R.id.eventsave)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                schedule_add schedule_add = schedule_add.this;
                schedule_add.userID = schedule_add.mAuth.getCurrentUser().getUid();
                DocumentReference documentReference = schedule_add.this.fstore.collection("Event").document(schedule_add.this.user.getUid()).collection("myEvent").document();
                Map<String, Object> user = new HashMap<>();
                user.put("eventname", schedule_add.this.eventnametext.getText().toString());
                user.put("eventdesc", schedule_add.this.eventdesctext.getText().toString());
                user.put("date", datePicker.getSelectedDate().getTime());
                user.put("dateevent", schedule_add.this.sdq.format(datePicker.getSelectedDate().getTime()));
                user.put("datetime", schedule_add.this.eventaddtime.getText().toString());
                user.put("datehh", schedule_add.this.sdhh.format(datePicker.getSelectedDate().getTime()));
                user.put("datemm", schedule_add.this.sdmm.format(datePicker.getSelectedDate().getTime()));
                documentReference.set(user);
                Intent returnIntent = new Intent();
                returnIntent.putExtra(ScheduleActivity.RESULT, new MyEventDay(datePicker.getSelectedDate(), R.drawable.addmore_ic, schedule_add.this.eventnametext.getText().toString()));
                Log.i(schedule_add.TAG, "Success !");
                schedule_add.this.setResult(-1, returnIntent);
                schedule_add.this.finish();
                Log.i("My Tag", "calendar getTime -----> " + datePicker.getSelectedDate().getTime());
            }
        });
    }
}
