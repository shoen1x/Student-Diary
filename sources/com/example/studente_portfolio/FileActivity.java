package com.example.studente_portfolio;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
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
import androidx.core.app.ShareCompat;
import androidx.core.content.FileProvider;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.example.studente_portfolio.model.FileAttrib;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;
import java.io.File;

public class FileActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "TAG";
    DrawerLayout drawerLayout;
    String extension;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirestoreRecyclerAdapter<FileAttrib, FileViewHolder> fileAdapter;
    NavigationView file_nav_view;
    RecyclerView filelists;
    ImageView preview;
    ActionBarDrawerToggle toggle;
    FirebaseUser user;
    String userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_files);
        Toolbar toolbar = (Toolbar) findViewById(R.id.filesToolbar);
        setSupportActionBar(toolbar);
        this.fStore = FirebaseFirestore.getInstance();
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.fAuth = instance;
        this.user = instance.getCurrentUser();
        this.userID = this.fAuth.getCurrentUser().getUid();
        this.fileAdapter = new FirestoreRecyclerAdapter<FileAttrib, FileViewHolder>(new FirestoreRecyclerOptions.Builder().setQuery(this.fStore.collection("files").document(this.user.getUid()).collection("myFiles").orderBy("title", Query.Direction.ASCENDING), FileAttrib.class).build()) {
            /* access modifiers changed from: protected */
            public void onBindViewHolder(FileViewHolder fileViewHolder, final int i, final FileAttrib file) {
                fileViewHolder.fileTitle.setText(file.getTitle());
                fileViewHolder.fileContent.setText(file.getDate());
                if (file.getFiletype().equals(".zip")) {
                    FileActivity.this.preview = (ImageView) fileViewHolder.view.findViewById(R.id.imgdownload);
                    FileActivity.this.preview.setImageResource(R.drawable.zip_ic);
                }
                if (file.getFiletype().equals(".pdf")) {
                    FileActivity.this.preview = (ImageView) fileViewHolder.view.findViewById(R.id.imgdownload);
                    FileActivity.this.preview.setImageResource(R.drawable.pdf_ic);
                }
                if (file.getFiletype().equals(".jpeg")) {
                    StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://student-diary-7ce7d.appspot.com");
                    StorageReference riversRef = storageReference.child(FileActivity.this.user.getUid() + "/" + file.getTitle());
                    FileActivity.this.preview = (ImageView) fileViewHolder.view.findViewById(R.id.imgdownload);
                    riversRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        public void onSuccess(Uri uri) {
                            Picasso.get().load(uri.toString()).into(FileActivity.this.preview);
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        public void onFailure(Exception exception) {
                        }
                    });
                }
                ((ImageView) fileViewHolder.view.findViewById(R.id.filemenuIcon)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        final String docId = ((DocumentSnapshot) FileActivity.this.fileAdapter.getSnapshots().getSnapshot(i)).getId();
                        PopupMenu menu = new PopupMenu(v.getContext(), v);
                        menu.setGravity(GravityCompat.END);
                        menu.getMenu().add("Download").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://student-diary-7ce7d.appspot.com");
                                StorageReference riversRef = storageReference.child(FileActivity.this.user.getUid() + "/" + file.getTitle());
                                File rootPath = new File(Environment.getExternalStorageDirectory(), "Download");
                                if (!rootPath.exists()) {
                                    rootPath.mkdirs();
                                }
                                riversRef.getFile(new File(rootPath, file.getTitle() + file.getFiletype())).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
                                    public void onSuccess(FileDownloadTask.TaskSnapshot taskSnapshot) {
                                        Log.e("firebase ", ";local tem file created  created " + file.getTitle());
                                        Toast.makeText(FileActivity.this.getApplicationContext(), "Download Completed", 0).show();
                                        Context applicationContext = FileActivity.this.getApplicationContext();
                                        Toast.makeText(applicationContext, "Internal storage/Download/" + file.getTitle(), 1).show();
                                    }
                                }).addOnFailureListener((OnFailureListener) new OnFailureListener() {
                                    public void onFailure(Exception e) {
                                        Log.e("firebase ", ";local temp file not created  created " + file.getTitle());
                                        Toast.makeText(FileActivity.this.getApplicationContext(), "Download Incompleted", 1).show();
                                    }
                                });
                                return false;
                            }
                        });
                        menu.getMenu().add("Share to Drive").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                StorageReference strgref = FirebaseStorage.getInstance().getReferenceFromUrl("gs://student-diary-7ce7d.appspot.com");
                                StorageReference rvrsref = strgref.child(FileActivity.this.user.getUid() + "/" + file.getTitle());
                                StringBuilder sb = new StringBuilder();
                                sb.append("Generated link : ");
                                sb.append(rvrsref);
                                Log.i(FileActivity.TAG, sb.toString());
                                File rootPath = new File(Environment.getExternalStorageDirectory(), "Download");
                                if (!rootPath.exists()) {
                                    rootPath.mkdirs();
                                }
                                File finalFile = new File(rootPath, file.getTitle() + file.getFiletype());
                                Log.i(FileActivity.TAG, "Download file in : " + finalFile.getPath());
                                rvrsref.getFile(finalFile);
                                if (file.getFiletype().equals(".zip")) {
                                    FileActivity.this.extension = "application/zip";
                                } else if (file.getFiletype().equals(".pdf")) {
                                    FileActivity.this.extension = "application/pdf";
                                } else if (file.getFiletype().equals(".jpeg")) {
                                    FileActivity.this.extension = "image/*";
                                }
                                Uri fileUri = FileProvider.getUriForFile(FileActivity.this, "com.example.studente_portfolio.provider", finalFile);
                                Log.i(FileActivity.TAG, "Download file in : " + fileUri);
                                ShareCompat.IntentBuilder from = ShareCompat.IntentBuilder.from(FileActivity.this);
                                FileActivity.this.startActivity(from.setText(file.getTitle() + file.getFiletype()).setType(FileActivity.this.extension).setStream(fileUri).getIntent().addFlags(1).setPackage("com.google.android.apps.docs"));
                                return false;
                            }
                        });
                        menu.getMenu().add("Delete").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
                            public boolean onMenuItemClick(MenuItem item) {
                                FileActivity.this.fStore.collection("files").document(FileActivity.this.user.getUid()).collection("myFiles").document(docId).delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                    public void onSuccess(Void aVoid) {
                                        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl("gs://student-diary-7ce7d.appspot.com");
                                        storageReference.child(FileActivity.this.user.getUid() + "/" + file.getTitle()).delete();
                                        FileActivity.this.user.delete();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                                    public void onFailure(Exception e) {
                                        Toast.makeText(FileActivity.this, "Error in Deleting Note.", 0).show();
                                    }
                                });
                                return false;
                            }
                        });
                        menu.show();
                    }
                });
            }

            public FileViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new FileViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_files_view, parent, false));
            }
        };
        this.filelists = (RecyclerView) findViewById(R.id.filelists);
        this.drawerLayout = (DrawerLayout) findViewById(R.id.filedrawer);
        NavigationView navigationView = (NavigationView) findViewById(R.id.file_nav_view);
        this.file_nav_view = navigationView;
        navigationView.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, this.drawerLayout, toolbar, R.string.open, R.string.close);
        this.toggle = actionBarDrawerToggle;
        this.drawerLayout.addDrawerListener(actionBarDrawerToggle);
        this.toggle.setDrawerIndicatorEnabled(true);
        this.toggle.syncState();
        this.filelists.setLayoutManager(new StaggeredGridLayoutManager(1, 1));
        this.filelists.setAdapter(this.fileAdapter);
        View headerView = this.file_nav_view.getHeaderView(0);
        final TextView username = (TextView) headerView.findViewById(R.id.userDisplayName);
        final TextView userEmail = (TextView) headerView.findViewById(R.id.userDisplayEmail);
        this.fStore.collection("users").document(this.userID).addSnapshotListener((Activity) this, (EventListener<DocumentSnapshot>) new EventListener<DocumentSnapshot>() {
            public void onEvent(DocumentSnapshot documentSnapshot, FirebaseFirestoreException e) {
                username.setText(documentSnapshot.getString("fname"));
                userEmail.setText(documentSnapshot.getString("email"));
            }
        });
        ((FloatingActionButton) findViewById(R.id.addFileFloat)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                FileActivity.this.startActivity(new Intent(view.getContext(), addFilesActivity.class));
                FileActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
            }
        });
    }

    public boolean onNavigationItemSelected(MenuItem item) {
        this.drawerLayout.closeDrawer(8388611);
        switch (item.getItemId()) {
            case R.id.addfiles /*2131361887*/:
                startActivity(new Intent(this, addFilesActivity.class));
                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
                break;
            case R.id.logout /*2131362121*/:
                checkUser();
                break;
            case R.id.notemanager /*2131362281*/:
                startActivity(new Intent(this, MainActivity.class));
                overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
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
        new AlertDialog.Builder(this).setTitle((CharSequence) "Are you sure ?").setMessage((CharSequence) "You are logged in with Temporary Account. Logging out will Delete All the notes.").setPositiveButton((CharSequence) "Sync File", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                FileActivity.this.startActivity(new Intent(FileActivity.this.getApplicationContext(), SignUpActivity.class));
                FileActivity.this.finish();
            }
        }).setNegativeButton((CharSequence) "Logout", (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                FileActivity.this.user.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    public void onSuccess(Void aVoid) {
                        FileActivity.this.startActivity(new Intent(FileActivity.this.getApplicationContext(), SplashActivity.class));
                        FileActivity.this.overridePendingTransition(R.anim.slide_up, R.anim.slide_down);
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

    public class FileViewHolder extends RecyclerView.ViewHolder {
        TextView fileContent;
        TextView fileTitle;
        CardView mCardView;
        ImageView preview;
        View view;

        public FileViewHolder(View itemView) {
            super(itemView);
            this.fileTitle = (TextView) itemView.findViewById(R.id.filetitles);
            this.fileContent = (TextView) itemView.findViewById(R.id.filecontent);
            this.mCardView = (CardView) itemView.findViewById(R.id.FilesCard);
            this.preview = (ImageView) itemView.findViewById(R.id.imgdownload);
            this.view = itemView;
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        this.fileAdapter.startListening();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        FirestoreRecyclerAdapter<FileAttrib, FileViewHolder> firestoreRecyclerAdapter = this.fileAdapter;
        if (firestoreRecyclerAdapter != null) {
            firestoreRecyclerAdapter.stopListening();
        }
    }
}
