package com.example.studente_portfolio;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;

public class SlideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;
    public int[] lst_backgroundcolor = {Color.rgb(55, 55, 55), Color.rgb(239, 85, 85), Color.rgb(110, 49, 89), Color.rgb(1, 188, 212)};
    public String[] lst_description = {"Welcome to Student Diary, Customize, store and share your notes and assignment in your own way!", "Customize your notes, Sort, Delete, Share your notes to other platform unlimited and in your own way!", "Save your assignment, files and documents in ©SyncStore , Integrated with Firestore system to keep the documents and files safe and sounds!", "Be Part of the community, and contribute more to the community!"};
    public int[] lst_images = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3, R.drawable.image_4};
    public String[] lst_title = {"STUDENT'S DIARY", "NOTES", "FILE & DOCUMENT", "GET STARTED"};

    public SlideAdapter(Context context2) {
        this.context = context2;
    }

    public int getCount() {
        return this.lst_title.length;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isViewFromObject(android.view.View r2, java.lang.Object r3) {
        /*
            r1 = this;
            r0 = r3
            android.widget.LinearLayout r0 = (android.widget.LinearLayout) r0
            if (r2 != r0) goto L_0x0007
            r0 = 1
            goto L_0x0008
        L_0x0007:
            r0 = 0
        L_0x0008:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.studente_portfolio.SlideAdapter.isViewFromObject(android.view.View, java.lang.Object):boolean");
    }

    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        this.inflater = layoutInflater;
        View view = layoutInflater.inflate(R.layout.slide_layout, container, false);
        ((LinearLayout) view.findViewById(R.id.slidelinearlayout)).setBackgroundColor(this.lst_backgroundcolor[position]);
        ((ImageView) view.findViewById(R.id.slideimg)).setImageResource(this.lst_images[position]);
        ((TextView) view.findViewById(R.id.txttitle)).setText(this.lst_title[position]);
        ((TextView) view.findViewById(R.id.txtdescription)).setText(this.lst_description[position]);
        container.addView(view);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
