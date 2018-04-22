package com.example.andriod.computerglitzapp;

/**
 * Created by Clare on 4/7/2018.
 */

public class FinancailInfoItem {
    private int mIndent;
    private String mText;
    private int mId;

    public FinancailInfoItem(int mIndent, String mText, int mId) {
        this.mIndent = mIndent;
        this.mText = mText;
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

    public void setmText(String mText) {
        this.mText = mText;
    }

    public int setmId (int mId) { return mId = mId; }



}
