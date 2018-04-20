package com.example.andriod.computerglitzapp;

import java.util.List;

/**
 * Created by emspr on 4/8/2018.
 */

public class MNCollegeDataHolder {
    private List<MNCollege> collegeData;
    private List<MNCollege> filteredCollegeData;

    public List<MNCollege> getCollegeData() {
        return collegeData;
    }
    public List<MNCollege> getFilteredCollegeData() {
        if (filteredCollegeData == null){
            return collegeData;
        }

        return filteredCollegeData;
    }

    public void setCollegeData(List<MNCollege> collegeData) {
        this.collegeData = collegeData;
    }
    public void setFilteredCollegeData(List<MNCollege> filteredCollegeData) {this.filteredCollegeData = filteredCollegeData;}
    private static final MNCollegeDataHolder holder=new MNCollegeDataHolder ();
    public static MNCollegeDataHolder getInstance(){return holder;}
    public void resetFilteredCollegeData(){
        this.filteredCollegeData = collegeData;
    }
}
