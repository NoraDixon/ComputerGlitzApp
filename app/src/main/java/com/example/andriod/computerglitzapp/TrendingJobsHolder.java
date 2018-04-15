package com.example.andriod.computerglitzapp;

import java.util.List;

/**
 * Created by norad on 4/14/2018.
 */

public class TrendingJobsHolder {
    private List<TrendingJobs> trendingDatas;

    public List<TrendingJobs> getTrendingDatas() {
        return trendingDatas;
    }

    public void setCollegeData(List<MNCollege> collegeData) {
        this.trendingDatas = trendingDatas;
    }
    private static final TrendingJobsHolder holder=new TrendingJobsHolder ();
    public static TrendingJobsHolder getInstance(){return holder;}

}
