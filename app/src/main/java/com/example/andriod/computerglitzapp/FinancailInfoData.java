package com.example.andriod.computerglitzapp;

import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Clare on 4/7/2018.
 */

public class FinancailInfoData {
    public static ArrayList<FinancailInfoItem> mButton = new ArrayList<>();
    static {
        mButton.add(new FinancailInfoItem (0, "FAFSA", "https://fafsa.ed.gov/ ",0 ));
        mButton.add(new FinancailInfoItem (0, "SCHOLARSHIPS", "https://www.scholarships.com/",1 ));
        mButton.add(new FinancailInfoItem (0, "IMPORTANT THINGS TO KNOW ABOUT FASFA", "https://blog.ed.gov/2017/09/12-common-fafsa-mistakes-2/",2 ));
        // FIND THE ADD NOTES PART FROM NORA'S CODE
    }
    }
