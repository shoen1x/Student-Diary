package com.example.studente_portfolio;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class addFilesActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonChoose;
    private Button buttonUpload;
    String checker;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    private Uri filePath;
    String fileType;
    private ImageView imageView;
    FirebaseUser userID;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_add_files);
        this.fStore = FirebaseFirestore.getInstance();
        FirebaseAuth instance = FirebaseAuth.getInstance();
        this.fAuth = instance;
        this.userID = instance.getCurrentUser();
        this.buttonChoose = (Button) findViewById(R.id.buttonChoose);
        this.buttonUpload = (Button) findViewById(R.id.buttonUpload);
        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.buttonChoose.setOnClickListener(this);
        this.buttonUpload.setOnClickListener(this);
    }

    private void showFileChooser() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle((CharSequence) "Select the file");
        builder.setItems(new CharSequence[]{"Images", "PDF Files", "Documents"}, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                if (which == 0) {
                    addFilesActivity.this.checker = "image";
                    Intent intent = new Intent();
                    intent.setType("image/*");
                    intent.setAction("android.intent.action.GET_CONTENT");
                    addFilesActivity.this.startActivityForResult(Intent.createChooser(intent, "Select Picture"), 438);
                }
                if (which == 1) {
                    addFilesActivity.this.checker = "PDF";
                    Intent intent2 = new Intent();
                    intent2.setType("application/pdf");
                    intent2.setAction("android.intent.action.GET_CONTENT");
                    addFilesActivity.this.startActivityForResult(Intent.createChooser(intent2, "Select PDF Files"), 438);
                }
                if (which == 2) {
                    addFilesActivity.this.checker = "Documents";
                    Intent intent3 = new Intent();
                    intent3.setType("application/zip");
                    intent3.setAction("android.intent.action.GET_CONTENT");
                    addFilesActivity.this.startActivityForResult(Intent.createChooser(intent3, "Select ZIP Files"), 438);
                }
            }
        });
        builder.show();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 438 && resultCode == -1 && data != null && data.getData() != null) {
            this.filePath = data.getData();
            DocumentReference document = this.fStore.collection("files").document(this.userID.getUid()).collection("myFiles").document();
            new HashMap();
            if (this.checker.equals("image")) {
                try {
                    this.imageView.setImageBitmap(MediaStore.Images.Media.getBitmap(getContentResolver(), this.filePath));
                    this.fileType = ".jpeg";
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (this.checker.equals("PDF")) {
                this.imageView.setImageResource(R.drawable.pdf_ic);
                this.fileType = ".pdf";
            }
            if (this.checker.equals("Documents")) {
                this.imageView.setImageResource(R.drawable.zip_ic);
                this.fileType = ".zip";
            }
        }
    }

    private void uploadFile() {
        final String millisInString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
        final EditText filename = (EditText) findViewById(R.id.filenames);
        if (this.filePath != null) {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading");
            progressDialog.show();
            storageReference.child(this.userID.getUid() + "/" + filename.getText().toString()).putFile(this.filePath).addOnSuccessListener((OnSuccessListener) new OnSuccessListener<UploadTask.TaskSnapshot>() {
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    DocumentReference documentReference = addFilesActivity.this.fStore.collection("files").document(addFilesActivity.this.userID.getUid()).collection("myFiles").document();
                    Map<String, Object> user = new HashMap<>();
                    if (addFilesActivity.this.fileType.equals(".jpeg")) {
                        user.put("filetype", ".jpeg");
                    }
                    if (addFilesActivity.this.fileType.equals(".pdf")) {
                        user.put("filetype", ".pdf");
                    }
                    if (addFilesActivity.this.fileType.equals(".zip")) {
                        user.put("filetype", ".zip");
                    }
                    user.put("title", filename.getText().toString());
                    user.put("date", millisInString);
                    documentReference.set(user);
                    progressDialog.dismiss();
                    Toast.makeText(addFilesActivity.this.getApplicationContext(), "File Uploaded ", 1).show();
                }
            }).addOnFailureListener((OnFailureListener) new OnFailureListener() {
                public void onFailure(Exception exception) {
                    progressDialog.dismiss();
                    Toast.makeText(addFilesActivity.this.getApplicationContext(), exception.getMessage(), 1).show();
                }
            }).addOnProgressListener((OnProgressListener) new OnProgressListener<UploadTask.TaskSnapshot>() {
                public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                    double progress = (((double) taskSnapshot.getBytesTransferred()) * 100.0d) / ((double) taskSnapshot.getTotalByteCount());
                    ProgressDialog progressDialog = progressDialog;
                    progressDialog.setMessage("Uploaded " + ((int) progress) + "%...");
                }
            });
        }
    }

    public void onClick(View view) {
        if (view == this.buttonChoose) {
            showFileChooser();
        } else if (view != this.buttonUpload) {
        } else {
            if (((EditText) findViewById(R.id.filenames)).getText().toString().trim().length() > 0) {
                uploadFile();
            } else {
                Toast.makeText(getApplicationContext(), "Please enter the file name", 1).show();
            }
        }
    }
}
