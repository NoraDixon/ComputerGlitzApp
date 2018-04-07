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
 * Created by norad on 3/25/2018.
 */

public class InitalLoader {
    public List<CollegeData> LoadColleges(Context context){
        //this will allow us to load our file from our assets folder.  Our assets folder will always
        //be accessible to our code
        AssetManager assetManager = context.getAssets();
        //We are going to return a list of colleges, so lists start with an empty list.
        List<CollegeData> colleges = new ArrayList<>();
        try {

            //This will read the file from our asset folder.  It should be the name of your file
            InputStream inputStream = assetManager.open("SchoolsTest.csv");
            //We need to convert the stream to a reader to actually read through the file
            InputStreamReader csvStreamReader = new InputStreamReader(inputStream);
            //this is the other person's code.  We pass the reader to their code
            CSVReader csvReader = new CSVReader(csvStreamReader);
            //their codse will read through the file, and create a list of string arrays.
            List<String[]> csv = csvReader.readAll();
            //We will loop through every item in the list, and assign what is there to our object
            //start at 1 because that is where the headers are
            for(int i = 1; i < csv.size(); i++){
                //get the item at location "i".  This will be a string array because it is multiple values
                String [] college = csv.get(i);
                //I will add to my list of colleges.  I am going to use the constructor I made to make a
                //new object and pass my parameters in.
                colleges.add(new CollegeData(college[0], college[1], college[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //I now can return a list of colleges! yay woot omg i hope this works
        return colleges;
    }
}
