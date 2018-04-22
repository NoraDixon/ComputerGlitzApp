package com.example.andriod.computerglitzapp;

import java.io.Serializable;

/**
 * Created by norad on 4/14/2018.
 */

public class FinancialInfoData implements Serializable {
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

    public FinancialInfoData(String job, String pay) {
        Job = job;
        Pay = pay;
    }
}
