package com.example.andriod.computerglitzapp;

/**
 * Created by Clare on 4/7/2018.
 */

public class SkillsItem {
    private int mIndent;
    private String mText;
    private int mId;
    private String mLink;

    public int getmId() {
        return mId;
    }

    public String getmLink() {
        return mLink;
    }

    public void setmLink(String mLink) {
        this.mLink = mLink;
    }

    public SkillsItem(int mIndent, String mText, String mLink, int mId) {
        this.mIndent = mIndent;
        this.mText = mText;
        this.mLink = mLink;
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
