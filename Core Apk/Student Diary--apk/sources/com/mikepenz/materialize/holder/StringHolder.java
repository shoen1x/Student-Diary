package com.mikepenz.materialize.holder;

import android.content.Context;
import android.widget.TextView;

public class StringHolder {
    private CharSequence mText;
    private int mTextRes = -1;

    public StringHolder(CharSequence text) {
        this.mText = text;
    }

    public StringHolder(String text) {
        this.mText = text;
    }

    public StringHolder(int textRes) {
        this.mTextRes = textRes;
    }

    public CharSequence getText() {
        return this.mText;
    }

    public void setText(String mText2) {
        this.mText = mText2;
    }

    public int getTextRes() {
        return this.mTextRes;
    }

    public void setTextRes(int mTextRes2) {
        this.mTextRes = mTextRes2;
    }

    public void applyTo(TextView textView) {
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            textView.setText(charSequence);
            return;
        }
        int i = this.mTextRes;
        if (i != -1) {
            textView.setText(i);
        } else {
            textView.setText("");
        }
    }

    public boolean applyToOrHide(TextView textView) {
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            textView.setText(charSequence);
            textView.setVisibility(0);
            return true;
        }
        int i = this.mTextRes;
        if (i != -1) {
            textView.setText(i);
            textView.setVisibility(0);
            return true;
        }
        textView.setVisibility(8);
        return false;
    }

    public String getText(Context ctx) {
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            return charSequence.toString();
        }
        int i = this.mTextRes;
        if (i != -1) {
            return ctx.getString(i);
        }
        return null;
    }

    public static void applyTo(StringHolder text, TextView textView) {
        if (text != null && textView != null) {
            text.applyTo(textView);
        }
    }

    public static boolean applyToOrHide(StringHolder text, TextView textView) {
        if (text != null && textView != null) {
            return text.applyToOrHide(textView);
        }
        if (textView == null) {
            return false;
        }
        textView.setVisibility(8);
        return false;
    }

    public String toString() {
        CharSequence charSequence = this.mText;
        if (charSequence != null) {
            return charSequence.toString();
        }
        if (this.mTextRes == -1) {
            return "";
        }
        return "StringRes:" + this.mTextRes;
    }
}
