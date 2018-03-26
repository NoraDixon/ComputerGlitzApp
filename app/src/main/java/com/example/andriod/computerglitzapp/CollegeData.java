package com.example.andriod.computerglitzapp;

/**
 * Created by norad on 3/25/2018.
 */

public class CollegeData {

    private String NameofCollege;

    private String Website;

    private String Location;

    public CollegeData(String nameofCollege, String website, String location) {
        NameofCollege = nameofCollege;
        Website = website;
        Location = location;
    }

    public String getNameofCollege() {
        return NameofCollege;
    }

    public void setNameofCollege(String nameofCollege) {
        NameofCollege = nameofCollege;
    }

    public String getWebsite() {
        return Website;
    }

    public void setWebsite(String website) {
        Website = website;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

}
