package com.example.andriod.computerglitzapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by norad on 4/14/2018.
 */

public class TrendingJobsData implements Serializable {
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
