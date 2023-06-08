package com.example.studente_portfolio;

import android.os.Parcel;
import android.os.Parcelable;
import com.applandeo.materialcalendarview.EventDay;
import java.util.Calendar;

class MyEventDay extends EventDay implements Parcelable {
    public static final Parcelable.Creator<MyEventDay> CREATOR = new Parcelable.Creator<MyEventDay>() {
        public MyEventDay createFromParcel(Parcel in) {
            return new MyEventDay(in);
        }

        public MyEventDay[] newArray(int size) {
            return new MyEventDay[size];
        }
    };
    private String mNote;

    MyEventDay(Calendar day, int imageResource, String note) {
        super(day, imageResource);
        this.mNote = note;
    }

    /* access modifiers changed from: package-private */
    public String getNote() {
        return this.mNote;
    }

    private MyEventDay(Parcel in) {
        super((Calendar) in.readSerializable(), in.readInt());
        this.mNote = in.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeSerializable(getCalendar());
        parcel.writeInt(getImageResource());
        parcel.writeString(this.mNote);
    }

    private int getImageResource() {
        return 0;
    }

    public int describeContents() {
        return 0;
    }
}
