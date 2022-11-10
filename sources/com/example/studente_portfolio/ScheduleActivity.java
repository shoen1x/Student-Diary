package com.example.studente_portfolio;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
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
import androidx.core.app.NotificationCompat;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.applandeo.materialcalendarview.CalendarView;
import com.applandeo.materialcalendarview.EventDay;
import com.example.studente_portfolio.model.Event;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class ScheduleActivity extends AppCompatActivity {
    private static final int NOTIFICATION_REMINDER_NIGHT = 1001;
    public static final String RESULT = "result";
    private static final String TAG = "TAG";
    Intent alarmIntent;
    AlarmManager alarmManager;
    /* access modifiers changed from: private */
    public FirebaseFirestore fstore;
    private FirebaseAuth mAuth;
    /* access modifiers changed from: private */
    public CalendarView mCalendarView;
    /* access modifiers changed from: private */
    public List<EventDay> mEventDays = new ArrayList();
    Boolean notification;
    PendingIntent pendingIntent;
    FirestoreRecyclerAdapter<Event, EventViewHolder> subAdapter;
    RecyclerView subjectLists;
    FirebaseUser user;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_schedule);
        toolbarfunction();
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = this.mAuth.getCurrentUser();
        this.mCalendarView = (CalendarView) findViewById(R.id.calendarsche);
        this.alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent(this, RevClass.class);
        this.alarmIntent = intent;
        this.pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 134217728);
        Intent intent2 = this.alarmIntent;
        intent2.setData(Uri.parse("custom://" + System.currentTimeMillis()));
        this.alarmManager.cancel(this.pendingIntent);
        final SimpleDateFormat sdq = new SimpleDateFormat("dd", Locale.getDefault());
        Calendar alarmStartTime = Calendar.getInstance();
        Calendar now = Calendar.getInstance();
        this.fstore.collection("users").document(this.user.getUid()).collection("settings").document(this.user.getUid()).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                ScheduleActivity.this.notification = Boolean.valueOf(Boolean.parseBoolean(documentSnapshot.getString("notification")));
            }
        });
        final Calendar calendar = alarmStartTime;
        final Calendar calendar2 = now;
        this.subAdapter = new FirestoreRecyclerAdapter<Event, EventViewHolder>(new FirestoreRecyclerOptions.Builder().setQuery(this.fstore.collection("Event").document(this.user.getUid()).collection("myEvent").orderBy("date", Query.Direction.ASCENDING), Event.class).build()) {
            /* access modifiers changed from: protected */
            public void onBindViewHolder(EventViewHolder eventViewHolder, final int i, Event event) {
                eventViewHolder.subName.setText(event.getEventName());
                eventViewHolder.subInfo.setText(event.getEventdesc());
                TextView textView = eventViewHolder.subinfo2;
                textView.setText(event.getDate() + " " + event.getDatetime());
                StringBuilder sb = new StringBuilder();
                sb.append("Date event: ");
                sb.append(event.getDate().toString());
                Log.d(ScheduleActivity.TAG, sb.toString());
                if (event.getDateevent().equals(sdq.format(calendar.getTime()))) {
                    if (ScheduleActivity.this.notification.equals(true)) {
                        if (calendar2.after(calendar)) {
                            Log.d("Hey", "Added a day");
                            calendar.add(5, 1);
                        }
                        ScheduleActivity.this.alarmManager.setRepeating(0, calendar.getTimeInMillis(), 43200000, ScheduleActivity.this.pendingIntent);
                        Log.d(ScheduleActivity.TAG, "Notification Enabled!");
                    } else {
                        Log.d(ScheduleActivity.TAG, "Notification Disabled!");
                    }
                }
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(5, Integer.parseInt(event.getDateevent()));
                Log.i(ScheduleActivity.TAG, "Calendar Intermission : " + calendar2.toString());
                ScheduleActivity.this.mEventDays.add(new EventDay(calendar2, (int) R.drawable.addmore_ic, Color.parseColor("#228B22")));
                ScheduleActivity.this.mCalendarView.setEvents(ScheduleActivity.this.mEventDays);
                ((ImageView) eventViewHolder.view.findViewById(R.id.schedule_settings)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        final String docId = ((DocumentSnapshot) ScheduleActivity.this.subAdapter.getSnapshots().getSnapshot(i)).getId();
                        PopupMenu menu = new PopupMenu(v.getContext(), v);
                        menu.setGravity(GravityCompat.END);
                        menu.getMenu().add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                ScheduleActivity.this.fstore.collection("Event").document(ScheduleActivity.this.user.getUid()).collection("myEvent").document(docId).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    public void onSuccess(Void aVoid) {
                                        ScheduleActivity.this.user.delete();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    public void onFailure(Exception e) {
                                        Toast.makeText(ScheduleActivity.this, "Error in Deleting Event.", 0).show();
                                    }
                                });
                                return false;
                            }
                        });
                        menu.show();
                    }
                });
            }

            public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new EventViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_view_layout, parent, false));
            }
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        this.subjectLists = recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        this.subjectLists.setAdapter(this.subAdapter);
    }

    public void toolbarfunction() {
        Toolbar tbschedule = (Toolbar) findViewById(R.id.tbschedule);
        setSupportActionBar(tbschedule);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle((CharSequence) "Reminder & Notification");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tbschedule.setNavigationOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ScheduleActivity.this.startActivity(new Intent(ScheduleActivity.this.getApplicationContext(), HomeActivity.class));
                ScheduleActivity.this.finish();
            }
        });
        ((Button) findViewById(R.id.addsche)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ScheduleActivity.this.addReminder();
            }
        });
    }

    /* access modifiers changed from: private */
    public void addReminder() {
        startActivity(new Intent(this, schedule_add.class));
    }

    public class EventViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        ImageView menuIcon;
        TextView subInfo;
        TextView subName;
        TextView subinfo2;
        View view;

        public EventViewHolder(View itemView) {
            super(itemView);
            this.subName = (TextView) itemView.findViewById(R.id.subviewname);
            this.subInfo = (TextView) itemView.findViewById(R.id.subinfo);
            this.subinfo2 = (TextView) itemView.findViewById(R.id.subinfo2);
            this.menuIcon = (ImageView) itemView.findViewById(R.id.schedule_settings);
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
        FirestoreRecyclerAdapter<Event, EventViewHolder> firestoreRecyclerAdapter = this.subAdapter;
        if (firestoreRecyclerAdapter != null) {
            firestoreRecyclerAdapter.stopListening();
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, HomeActivity.class));
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }
}
