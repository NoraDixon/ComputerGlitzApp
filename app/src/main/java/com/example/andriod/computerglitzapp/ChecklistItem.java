package com.example.andriod.computerglitzapp;

/**
 * Created by Clare on 4/7/2018.
 */

public class ChecklistItem {
    private int mIndent;
    private String mText;
    private boolean mIsChecked;
    private String Key;

    public ChecklistItem(String Key, int mIndent, String mText, boolean mIsChecked) {
        this.Key = Key;
        this.mIndent = mIndent;
        this.mText = mText;
        this.mIsChecked = mIsChecked;
    }

    public int getmIndent() {
        return mIndent;
    }

    public void setmIndent(int mIndent) {
        this.mIndent = mIndent;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public boolean ismIsChecked() {
        return mIsChecked;
    }

    public void setmIsChecked(boolean mIsChecked) {
        this.mIsChecked = mIsChecked;
    }

    public String getKey() {return Key; }
}
