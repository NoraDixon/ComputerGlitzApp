package com.example.andriod.computerglitzapp;

import java.util.List;

/**
 * Created by norad on 4/22/2018.
 */

public class FavoritesDataHolder {
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
    private static final FavoritesDataHolder holder=new FavoritesDataHolder();
    public static FavoritesDataHolder getInstance(){return holder;}
    public void resetFilteredCollegeData(){
        this.filteredCollegeData = collegeData;
    }
}
