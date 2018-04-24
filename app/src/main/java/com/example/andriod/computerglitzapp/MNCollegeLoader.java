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
 * Created by Ashley on 4/7/2018.
 */

public class MNCollegeLoader {
    public List<MNCollege> loadMNColleges(Context contextScreen){
        AssetManager assetManager = contextScreen.getAssets();
        List<MNCollege> mnColleges = new ArrayList<>();

        try {
            InputStream inputStream = assetManager.open("CollegeScorecardDataFinal.csv");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            CSVReader csvReader = new CSVReader(inputStreamReader);
            List<String[]>bunchOfLists = csvReader.readAll();
            for(int n=1; n<bunchOfLists.size(); n++){
               String[] criteria = bunchOfLists.get(n);
              MNCollege readableMNCollegeData = new MNCollege(criteria[0],
                      criteria[1],
                      criteria[2],
                      criteria[3],
                      criteria[4],
                      criteria[5],
                      criteria[6],
                      criteria[7],
                      criteria[8],
                      criteria[9],
                      criteria[10],
                      criteria[11],
                      criteria[12],
                      criteria[13],
                      criteria[14],
                      criteria[15],
                      criteria[16],
                      criteria[17],
                      criteria[18],
                      criteria[19],
                      criteria[20],
                      criteria[21],
                      criteria[22]);
              mnColleges.add(readableMNCollegeData);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mnColleges;

    }
}
