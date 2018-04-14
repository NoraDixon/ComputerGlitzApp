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

public class TrendingJobsLoader {
    private List<TrendingDatas> trendingDatas;

    public List<TrendingDatas> getCollegeData() {
        return trendingDatas;
    }

    public void setCollegeData(List<TrendingDatas> collegeData) {
        this.trendingDatas = trendingDatas;
    }
    private static final TrendingDataHolder holder=new TrendingDataHolder ();
    public static TrendingDataHolder getInstance(){return holder;}
    public List<TrendingDatas> loadTrendingsData(Context contextScreen){
        AssetManager assetManager = contextScreen.getAssets();
        List<TrendingDatas> TrendingData = new ArrayList<>();

        try {
            InputStream inputStream = assetManager.open("TrendingData.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReader(inputStreamReader);
            List<String[]>bunchOfLists = csvReader.readAll();
            for(int n=1; n<bunchOfLists.size(); n++){
                String[] criteria = bunchOfLists.get(n);
                MNCollege readableMNCollegeData = new MNCollege(
                        criteria[0],
                        criteria[1]);
                TrendingdDatas.add(TrendingDatas);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return TrendingDatas;

    }
}
