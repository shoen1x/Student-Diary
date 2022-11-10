package com.example.studente_portfolio;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.studente_portfolio.model.Note;
import com.example.studente_portfolio.note.AddNote;
import com.example.studente_portfolio.note.EditNote;
import com.example.studente_portfolio.note.NoteDetails;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    RecyclerView lists;
    NavigationView nav_view;
    FirestoreRecyclerAdapter<Note, NoteViewHolder> noteAdapter;
    ActionBarDrawerToggle toggle;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.noteToolbar);
        setSupportActionBar(toolbar);
        this.fStore = FirebaseFirestore.getInstance();
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.fAuth = instance;
        this.user = instance.getCurrentUser();
        this.noteAdapter = new FirestoreRecyclerAdapter<Note, NoteViewHolder>(new FirestoreRecyclerOptions.Builder().setQuery(this.fStore.collection("notes").document(this.user.getUid()).collection("myNotes").orderBy("title", Query.Direction.DESCENDING), Note.class).build()) {
            /* access modifiers changed from: protected */
            public void onBindViewHolder(NoteViewHolder noteViewHolder, final int i, final Note note) {
                noteViewHolder.noteTitle.setText(note.getTitle());
                noteViewHolder.noteContent.setText(note.getContent());
                final int code = MainActivity.this.getRandomColor();
                noteViewHolder.mCardView.setCardBackgroundColor(noteViewHolder.view.getResources().getColor(code, (Resources.Theme) null));
                final String docId = ((DocumentSnapshot) MainActivity.this.noteAdapter.getSnapshots().getSnapshot(i)).getId();
                noteViewHolder.view.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(v.getContext(), NoteDetails.class);
                        i.putExtra("title", note.getTitle());
                        i.putExtra(FirebaseAnalytics.Param.CONTENT, note.getContent());
                        i.putExtra("code", code);
                        i.putExtra("noteId", docId);
                        v.getContext().startActivity(i);
                    }
                });
                ((ImageView) noteViewHolder.view.findViewById(R.id.menuIcon)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(final View v) {
                        final String docId = ((DocumentSnapshot) MainActivity.this.noteAdapter.getSnapshots().getSnapshot(i)).getId();
                        PopupMenu menu = new PopupMenu(v.getContext(), v);
                        menu.setGravity(GravityCompat.END);
                        menu.getMenu().add("Edit").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                Intent i = new Intent(v.getContext(), EditNote.class);
                                i.putExtra("title", note.getTitle());
                                i.putExtra(FirebaseAnalytics.Param.CONTENT, note.getContent());
                                i.putExtra("noteId", docId);
                                MainActivity.this.startActivity(i);
                                return false;
                            }
                        });
                        menu.getMenu().add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                MainActivity.this.fStore.collection("notes").document(MainActivity.this.user.getUid()).collection("myNotes").document(docId).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    public void onSuccess(Void aVoid) {
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    public void onFailure(Exception e) {
                                        Toast.makeText(MainActivity.this, "Error in Deleting Note.", 0).show();
                                    }
                                });
                                return false;
                            }
                        });
                        menu.show();
                    }
                });
            }

            public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new NoteViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout, parent, false));
            }
        };
        this.lists = (RecyclerView) findViewById(R.id.lists);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        this.nav_view = navigationView;
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, toolbar, R.string.open, R.string.close);
        this.toggle = actionBarDrawerToggle;
        this.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        this.toggle.setDrawerIndicatorEnabled(true);
        this.toggle.syncState();
        this.lists.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
        this.lists.setAdapter(this.noteAdapter);
        View headerView = this.nav_view.getHeaderView(0);
        final TextView username = (TextView) headerView.findViewById(R.id.userDisplayName);
        final TextView userEmail = (TextView) headerView.findViewById(R.id.userDisplayEmail);
        this.userID = this.fAuth.getCurrentUser().getUid();
        this.fStore.collection("users").document(this.userID).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                username.setText(documentSnapshot.getString("fname"));
                userEmail.setText(documentSnapshot.getString("email"));
            }
        });
        ((FloatingActionButton) findViewById(R.id.addNoteFloat)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MainActivity.this.startActivity(new Intent(view.getContext(), AddNote.class));
                MainActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        this.drawerLayout.closeDrawer(8388611);
        switch (item.getItemId()) {
            case R.id.addnote /*2131361888*/:
                startActivity(new Intent(this, AddNote.class));
                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                break;
            case R.id.filemanager /*2131362049*/:
                startActivity(new Intent(this, FileActivity.class));
                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                break;
            case R.id.logout /*2131362121*/:
                checkUser();
                break;
            case R.id.rating /*2131362333*/:
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.example.studente_portfolio" + getPackageName())));
                    break;
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://play.google.com/store/apps/details?id=com.example.studente_portfolio" + getPackageName())));
                    break;
                }
            case R.id.shareapp /*2131362389*/:
                Intent myIntent = new Intent("android.intent.action.SEND");
                myIntent.setType("text/plain");
                myIntent.putExtra("android.intent.extra.SUBJECT", "Student Diary");
                myIntent.putExtra("android.intent.extra.TEXT", "Share this apps with your friends and family");
                startActivity(Intent.createChooser(myIntent, "Share Using"));
                break;
            case R.id.sync /*2131362444*/:
                if (!this.user.isAnonymous()) {
                    Toast.makeText(this, "Your Are Connected.", 0).show();
                    break;
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                    overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                    break;
                }
        }
        return false;
    }

    private void checkUser() {
        if (this.user.isAnonymous()) {
            displayAlert();
            return;
        }
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), SplashActivity.class));
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
    }

    private void displayAlert() {
        new AlertDialog.Builder(this).setTitle((CharSequence) "Are you sure ?").setMessage((CharSequence) "You are logged in with Temporary Account. Logging out will Delete All the notes.").setPositiveButton((CharSequence) "Sync Note", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), SignUpActivity.class));
                MainActivity.this.finish();
            }
        }).setNegativeButton((CharSequence) "Logout", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                MainActivity.this.user.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    public void onSuccess(Void aVoid) {
                        MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), SplashActivity.class));
                        MainActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                    }
                });
            }
        }).show();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.settings) {
            startActivity(new Intent(this, SettingsActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView noteContent;
        TextView noteTitle;
        View view;

        public NoteViewHolder(View itemView) {
            super(itemView);
            this.noteTitle = (TextView) itemView.findViewById(R.id.titles);
            this.noteContent = (TextView) itemView.findViewById(R.id.content);
            this.mCardView = (CardView) itemView.findViewById(R.id.noteCard);
            this.view = itemView;
        }
    }

    /* access modifiers changed from: private */
    public int getRandomColor() {
        List<Integer> colorCode = new ArrayList<>();
        colorCode.add(Integer.valueOf(R.color.blue));
        colorCode.add(Integer.valueOf(R.color.yellow));
        colorCode.add(Integer.valueOf(R.color.skyblue));
        colorCode.add(Integer.valueOf(R.color.lightPurple));
        colorCode.add(Integer.valueOf(R.color.lightGreen));
        colorCode.add(Integer.valueOf(R.color.gray));
        colorCode.add(Integer.valueOf(R.color.pink));
        colorCode.add(Integer.valueOf(R.color.red));
        colorCode.add(Integer.valueOf(R.color.greenlight));
        colorCode.add(Integer.valueOf(R.color.notgreen));
        return colorCode.get(new Random().nextInt(colorCode.size())).intValue();
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
}
