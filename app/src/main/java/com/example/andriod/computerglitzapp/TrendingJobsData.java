package com.example.andriod.computerglitzapp;

/**
 * Created by norad on 4/14/2018.
 */

public class TrendingJobsData {
    private String Job;
    private String Pay;

    public String getJob() {
        return Job;
    }
    public void setJob(String job) {
        Job = job;
    }

    public String getPay() {
        return Pay;
    }
    public void setPay(String pay) {
        Pay = pay;
    }

    public TrendingJobsData(String job, String pay) {
        Job = job;
        Pay = pay;
    }


}
