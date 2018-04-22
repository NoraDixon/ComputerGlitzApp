package com.example.andriod.computerglitzapp;

import java.util.List;

/**
 * Created by norad on 4/14/2018.
 */

public class FinancialInfoHolder {
    private List<TrendingJobsData> trendingDatas;

    public List<TrendingJobsData> getTrendingDatas() {
        return trendingDatas;
    }

    public void setTrendingDatas(List<TrendingJobsData> trendingDatas) {
        this.trendingDatas = trendingDatas;
    }
    private static final FinancialInfoHolder holder=new FinancialInfoHolder();
    public static FinancialInfoHolder getInstance(){return holder;}

}
