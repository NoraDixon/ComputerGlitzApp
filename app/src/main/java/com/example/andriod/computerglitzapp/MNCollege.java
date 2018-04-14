package com.example.andriod.computerglitzapp;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashley on 4/7/2018.
 */

public class MNCollege implements Serializable {
    //UNITID,OPEID,OPEID6,INSTNM,CITY,STABBR,ZIP,INSTURL,NPCURL,COSTT4_A,TUITFTE,PCIP01,PCIP11,PCIP15,PCIP43,PCIP46,PCIP47,PCIP48,PCIP49,PCIP50,PCIP51,PCIP52
    private String unitid;
    private String opeid;
    private String opeid6;
    private String name;
    private String city;
    private String state;
    private String zip;
    private String website;
    private String npcurl;
    private String costt4_A;
    private String tuitfte;
    private String pcip01;
    private String pcip11;
    private String pcip15;
    private String pcip43;
    private String pcip46;
    private String pcip47;
    private String pcip48;
    private String pcip49;
    private String pcip50;
    private String pcip51;
    private String pcip52;


    private List<String> programList;


    public MNCollege() {
    }

    public MNCollege(String unitid, String opeid, String opeid6, String name, String city, String state, String zip, String website, String npcurl, String costt4_A, String tuitfte, String pcip01, String pcip11, String pcip15, String pcip43, String pcip46, String pcip47, String pcip48, String pcip49, String pcip50, String pcip51, String pcip52) {
        this.unitid = unitid;
        this.opeid = opeid;
        this.opeid6 = opeid6;
        this.name = name;
        this.city = city;
        this.state = state;
        this.zip = zip;
        if (!website.startsWith("http://") && !website.startsWith("https://")){
            website = "http://" + website;
        }
        this.website = website;
        this.npcurl = npcurl;
        this.costt4_A = costt4_A;
        this.tuitfte = tuitfte;
        this.pcip01 = pcip01;
        this.pcip11 = pcip11;
        this.pcip15 = pcip15;
        this.pcip43 = pcip43;
        this.pcip46 = pcip46;
        this.pcip47 = pcip47;
        this.pcip48 = pcip48;
        this.pcip49 = pcip49;
        this.pcip50 = pcip50;
        this.pcip51 = pcip51;
        this.pcip52 = pcip52;
        List<String> programList = new ArrayList<>();
        if(!getPcip01().equals("NULL") && Double.parseDouble(getPcip01())>0){
            programList.add("Agriculture, Agriculture Operations, and Related Sciences");
        }
        if(!getPcip11().equals("NULL") && Double.parseDouble(getPcip11())>0){
            programList.add("Computer and Information Sciences and Support Services");
        }
        if(!getPcip15().equals("NULL") && Double.parseDouble(getPcip15())>0){
            programList.add("Engineering Technologies and Engineering-Related Fields");
        }
        if(!getPcip43().equals("NULL") && Double.parseDouble(getPcip43())>0){
            programList.add("Homeland Security, Law Enforcement, Firefighting and Related Protective Services");
        }
        if(!getPcip46().equals("NULL") && Double.parseDouble(getPcip46())>0){
            programList.add("Construction Trades");
        }
        if(!getPcip47().equals("NULL") && Double.parseDouble(getPcip47())>0){
            programList.add("Mechanic and Repair Technologies/Technicians");
        }
        if(!getPcip48().equals("NULL") && Double.parseDouble(getPcip48())>0){
            programList.add("Precision Production");
        }
        if(!getPcip49().equals("NULL") && Double.parseDouble(getPcip49())>0){
            programList.add("Transportation and Materials Moving");
        }
        if(!getPcip50().equals("NULL") && Double.parseDouble(getPcip50())>0){
            programList.add("Visual and Performing Arts");
        }
        if(!getPcip51().equals("NULL") && Double.parseDouble(getPcip51())>0){
            programList.add("Health Professions and Related Programs");
        }
        if(!getPcip52().equals("NULL") && Double.parseDouble(getPcip52())>0){
            programList.add("Business, Management, Marketing, and Related Support Services");
        }


        this.programList = programList;
    }



    public String getUnitid() {
        return unitid;
    }

    public void setUnitid(String unitid) {
        this.unitid = unitid;
    }

    public String getOpeid() {
        return opeid;
    }

    public void setOpeid(String opeid) {
        this.opeid = opeid;
    }

    public String getOpeid6() {
        return opeid6;
    }

    public void setOpeid6(String opeid6) {
        this.opeid6 = opeid6;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getNpcurl() {
        return npcurl;
    }

    public void setNpcurl(String npcurl) {
        this.npcurl = npcurl;
    }

    public String getCostt4_A() {
        return costt4_A;
    }

    public void setCostt4_A(String costt4_A) {
        this.costt4_A = costt4_A;
    }

    public String getTuitfte() {
        return tuitfte;
    }

    public void setTuitfte(String tuitfte) {
        this.tuitfte = tuitfte;
    }

    public String getPcip01() {
        return pcip01;
    }

    public void setPcip01(String pcip01) {
        this.pcip01 = pcip01;
    }

    public String getPcip11() {
        return pcip11;
    }

    public void setPcip11(String pcip11) {
        this.pcip11 = pcip11;
    }

    public String getPcip15() {
        return pcip15;
    }

    public void setPcip15(String pcip15) {
        this.pcip15 = pcip15;
    }

    public String getPcip43() {
        return pcip43;
    }

    public void setPcip43(String pcip43) {
        this.pcip43 = pcip43;
    }

    public String getPcip46() {
        return pcip46;
    }

    public void setPcip46(String pcip46) {
        this.pcip46 = pcip46;
    }

    public String getPcip47() {
        return pcip47;
    }

    public void setPcip47(String pcip47) {
        this.pcip47 = pcip47;
    }

    public String getPcip48() {
        return pcip48;
    }

    public void setPcip48(String pcip48) {
        this.pcip48 = pcip48;
    }

    public String getPcip49() {
        return pcip49;
    }

    public void setPcip49(String pcip49) {
        this.pcip49 = pcip49;
    }

    public String getPcip50() {
        return pcip50;
    }

    public void setPcip50(String pcip50) {
        this.pcip50 = pcip50;
    }

    public String getPcip51() {
        return pcip51;
    }

    public void setPcip51(String pcip51) {
        this.pcip51 = pcip51;
    }

    public String getPcip52() {
        return pcip52;
    }

    public void setPcip52(String pcip52) {
        this.pcip52 = pcip52;
    }

    public List<String> getProgramList() {
        return programList;
    }

    public void setProgramList(List<String> programList) {
        this.programList = programList;
    }
}
