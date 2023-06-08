package com.example.studente_portfolio;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.NotificationCompat;
import androidx.core.view.PointerIconCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.studente_portfolio.model.Note;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;

public class HomeActivity extends AppCompatActivity {
    private final AppCompatActivity activity = this;
    String email;
    String fname;
    FirebaseFirestore fstore;
    FirebaseAuth mAuth;
    FirestoreRecyclerAdapter<Note, NoteViewHolder> noteAdapter;
    RecyclerView noteLists;
    private NotificationManager notifManager;
    TextView txtMain;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_home);
        this.mAuth = FirebaseAuth.getInstance();
        this.fstore = FirebaseFirestore.getInstance();
        this.user = this.mAuth.getCurrentUser();
        onClick();
        onClickListener();
        this.txtMain = (TextView) findViewById(R.id.txtMain);
        this.userID = this.mAuth.getCurrentUser().getUid();
        this.fstore.collection("users").document(this.userID).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                if (documentSnapshot.getString("fullname").equals("")) {
                    TextView textView = HomeActivity.this.txtMain;
                    textView.setText("Hi " + documentSnapshot.getString("fname") + "!");
                    HomeActivity homeActivity = HomeActivity.this;
                    homeActivity.createNotification(HomeActivity.this.txtMain.getText().toString() + ", Tap here to customize your profile");
                    return;
                }
                TextView textView2 = HomeActivity.this.txtMain;
                textView2.setText("Hi " + documentSnapshot.getString("fullname") + "!");
            }
        });
        ((ImageView) findViewById(R.id.appsicon)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HomeActivity.this.startActivity(new Intent(HomeActivity.this, ProfileActivity.class));
            }
        });
        this.noteAdapter = new FirestoreRecyclerAdapter<Note, NoteViewHolder>(new FirestoreRecyclerOptions.Builder().setQuery(this.fstore.collection("notes").document(this.user.getUid()).collection("myNotes").orderBy("title", Query.Direction.DESCENDING), Note.class).build()) {
            /* access modifiers changed from: protected */
            public void onBindViewHolder(NoteViewHolder noteViewHolder, int i, Note note) {
                noteViewHolder.noteTitle.setText(note.getTitle());
                noteViewHolder.noteContent.setText(note.getContent());
            }

            public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_home_view_layout, parent, false));
            }
        };
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.RecyleHome);
        this.noteLists = recyclerView;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, 0));
        this.noteLists.setAdapter(this.noteAdapter);
    }

    public void onClick() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.bringToFront();
        fab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(HomeActivity.this, R.style.PauseDialog);
                dialog1.setContentView(R.layout.home_add_new_dialog);
                dialog1.setCancelable(true);
                dialog1.setCanceledOnTouchOutside(true);
                dialog1.findViewById(R.id.notesadd).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        HomeActivity.this.startActivity(new Intent(HomeActivity.this, MainActivity.class));
                        dialog1.dismiss();
                    }
                });
                dialog1.findViewById(R.id.filesadd).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        HomeActivity.this.startActivity(new Intent(HomeActivity.this, FileActivity.class));
                        dialog1.dismiss();
                    }
                });
                dialog1.findViewById(R.id.cancelbtndialog).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });
                dialog1.show();
            }
        });
    }

    public void onClickListener() {
        ((BottomNavigationView) findViewById(R.id.bottom_app_bar)).setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.media_academic /*2131362175*/:
                        HomeActivity.this.startActivity(new Intent(HomeActivity.this, AcademicActivity.class));
                        return true;
                    case R.id.media_attendance /*2131362177*/:
                        HomeActivity.this.startActivity(new Intent(HomeActivity.this, AttendanceActivity.class));
                        return true;
                    case R.id.media_curriculum /*2131362178*/:
                        HomeActivity.this.startActivity(new Intent(HomeActivity.this, CurricularActivity.class));
                        return true;
                    case R.id.media_schedule /*2131362179*/:
                        HomeActivity.this.startActivity(new Intent(HomeActivity.this, ScheduleActivity.class));
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    public void onBackPressed() {
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
        AlertDialog.Builder alertdialog = new AlertDialog.Builder(this);
        alertdialog.setTitle("Log Out?");
        alertdialog.setMessage("Are you sure you Want to log out and exit the application?");
        alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                HomeActivity.this.mAuth.signOut();
                HomeActivity.this.startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                HomeActivity.this.finish();
            }
        });
        alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog create = alertdialog.create();
        alertdialog.show();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView noteContent;
        TextView noteTitle;
        View view;

        public NoteViewHolder(View itemView) {
            super(itemView);
            this.noteTitle = (TextView) itemView.findViewById(R.id.filetitles);
            this.noteContent = (TextView) itemView.findViewById(R.id.filecontent);
            this.mCardView = (CardView) itemView.findViewById(R.id.noteCard);
            this.view = itemView;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.noteAdapter.startListening();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        FirestoreRecyclerAdapter<Note, NoteViewHolder> firestoreRecyclerAdapter = this.noteAdapter;
        if (firestoreRecyclerAdapter != null) {
            firestoreRecyclerAdapter.stopListening();
        }
    }

    public void createNotification(String aMessage) {
        NotificationCompat.Builder builder;
        String str = aMessage;
        if (this.notifManager == null) {
            this.notifManager = (NotificationManager) getSystemService("notification");
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (this.notifManager.getNotificationChannel("my_package_channel_1") == null) {
                NotificationChannel mChannel = new NotificationChannel("my_package_channel_1", "my_package_channel", 4);
                mChannel.setDescription("my_package_first_channel");
                mChannel.enableVibration(true);
                mChannel.setLightColor(-16711936);
                mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
                this.notifManager.createNotificationChannel(mChannel);
            }
            builder = new NotificationCompat.Builder(this, "my_package_channel_1");
            Intent intent = new Intent(this, EditProfile.class);
            intent.setFlags(603979776);
            builder.setContentTitle(str).setSmallIcon(17301598).setContentText(getString(R.string.app_name)).setDefaults(-1).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, 0, intent, 0)).setTicker(str).setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
        } else {
            builder = new NotificationCompat.Builder(this);
            Intent intent2 = new Intent(this, EditProfile.class);
            intent2.setFlags(603979776);
            builder.setContentTitle(str).setSmallIcon(17301598).setContentText(getString(R.string.app_name)).setDefaults(-1).setAutoCancel(true).setContentIntent(PendingIntent.getActivity(this, 0, intent2, 0)).setTicker(str).setVibrate(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400}).setPriority(1);
        }
        this.notifManager.notify(PointerIconCompat.TYPE_HAND, builder.build());
    }
}
