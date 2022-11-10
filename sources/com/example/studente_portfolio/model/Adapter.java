package com.example.studente_portfolio.model;

import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.studente_portfolio.R;
import com.example.studente_portfolio.note.NoteDetails;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Adapter extends RecyclerView.Adapter<ViewHolder> {
    List<String> content;
    List<String> titles;

    public Adapter(List<String> title, List<String> content2) {
        this.titles = title;
        this.content = content2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.note_view_layout, parent, false));
    }

    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.noteTitle.setText(this.titles.get(position));
        holder.noteContent.setText(this.content.get(position));
        final int code = getRandomColor();
        holder.mCardView.setCardBackgroundColor(holder.view.getResources().getColor(code, (Resources.Theme) null));
        holder.view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NoteDetails.class);
                i.putExtra("title", Adapter.this.titles.get(position));
                i.putExtra(FirebaseAnalytics.Param.CONTENT, Adapter.this.content.get(position));
                i.putExtra("code", code);
                v.getContext().startActivity(i);
            }
        });
    }

    private int getRandomColor() {
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

    public int getItemCount() {
        return this.titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView mCardView;
        TextView noteContent;
        TextView noteTitle;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            this.noteTitle = (TextView) itemView.findViewById(R.id.filetitles);
            this.noteContent = (TextView) itemView.findViewById(R.id.filecontent);
            this.mCardView = (CardView) itemView.findViewById(R.id.noteCard);
            this.view = itemView;
        }
    }
}
