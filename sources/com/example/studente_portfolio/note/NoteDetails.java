package com.example.studente_portfolio.note;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.studente_portfolio.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.analytics.FirebaseAnalytics;

public class NoteDetails extends AppCompatActivity {
    Intent data;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) R.layout.activity_note_details);
        setSupportActionBar((Toolbar) findViewById(R.id.notetoolbardetails));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.data = getIntent();
        TextView content = (TextView) findViewById(R.id.noteDetailsContent);
        content.setMovementMethod(new ScrollingMovementMethod());
        content.setText(this.data.getStringExtra(FirebaseAnalytics.Param.CONTENT));
        ((TextView) findViewById(R.id.noteDetailsTitle)).setText(this.data.getStringExtra("title"));
        content.setBackgroundColor(getResources().getColor(this.data.getIntExtra("code", 0), (Resources.Theme) null));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), EditNote.class);
                i.putExtra("title", NoteDetails.this.data.getStringExtra("title"));
                i.putExtra(FirebaseAnalytics.Param.CONTENT, NoteDetails.this.data.getStringExtra(FirebaseAnalytics.Param.CONTENT));
                i.putExtra("noteId", NoteDetails.this.data.getStringExtra("noteId"));
                NoteDetails.this.startActivity(i);
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == 16908332) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}
