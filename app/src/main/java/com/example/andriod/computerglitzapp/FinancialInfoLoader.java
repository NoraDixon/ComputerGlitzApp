package com.example.andriod.computerglitzapp;

import android.content.Context;
import android.content.res.AssetManager;

import com.opencsv.CSVReader;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by norad on 4/14/2018.
 */

public class FinancialInfoLoader {
    private List<TrendingJobsData> trendingDatas;

    public List<TrendingJobsData> getCollegeData() {
        return trendingDatas;
    }

    public void setCollegeData(List<TrendingJobsData> collegeData) {
        this.trendingDatas = trendingDatas;
    }
    private static final TrendingJobsHolder holder=new TrendingJobsHolder ();
    public static TrendingJobsHolder getInstance(){return holder;}
    public List<TrendingJobsData> loadTrendingJobsData(Context contextScreen){
        AssetManager assetManager = contextScreen.getAssets();
        List<TrendingJobsData> myTrendingJobDataList  = new ArrayList<>();

        try {
            InputStream inputStream = assetManager.open("TrendingData.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReader(inputStreamReader);
            List<String[]>bunchOfLists = csvReader.readAll();
            for(int n=1; n<bunchOfLists.size(); n++){
                String[] criteria = bunchOfLists.get(n);
                TrendingJobsData readableTrendingJobsData = new TrendingJobsData(
                        criteria[0],
                        criteria[1]);
                myTrendingJobDataList.add( readableTrendingJobsData );


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return myTrendingJobDataList;

    }
}
