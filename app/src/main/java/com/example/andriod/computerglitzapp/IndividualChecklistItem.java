package com.example.andriod.computerglitzapp;

/**
 * Created by Clare on 4/7/2018.
 */

public class IndividualChecklistItem {
    private int mIndent;
    private String mText;
    private String mKey;
    private boolean mIsChecked;
    private int mId;

    public IndividualChecklistItem(String mKey, int mIndent, String mText, boolean mIsChecked, int mId) {
        this.mIndent = mIndent;
        this.mText = mText;
        this.mKey = mKey;
        this.mIsChecked = mIsChecked;
        this.mId = mId;
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

    public String getKey() { return mKey; }

    public void setmText(String mText) {
        this.mText = mText;
    }

    public boolean ismIsChecked() {
        return mIsChecked;
    }

    public void setmIsChecked(boolean mIsChecked) {
        this.mIsChecked = mIsChecked;
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }
}
