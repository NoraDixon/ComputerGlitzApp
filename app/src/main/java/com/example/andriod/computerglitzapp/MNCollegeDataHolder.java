package com.example.andriod.computerglitzapp;

import java.util.List;

/**
 * Created by emspr on 4/8/2018.
 */

public class MNCollegeDataHolder {
    private List<MNCollege> collegeData;

    public List<MNCollege> getCollegeData() {
        return collegeData;
    }

    public void setCollegeData(List<MNCollege> collegeData) {
        this.collegeData = collegeData;
    }
    private static final MNCollegeDataHolder holder=new MNCollegeDataHolder ();
    public static MNCollegeDataHolder getInstance(){return holder;}
}
