package com.example.andriod.computerglitzapp;

import java.util.ArrayList;

/**
 * Created by Clare on 4/7/2018.
 */

public class ChecklistData {
    public static ArrayList<ChecklistItem> mChecklist = new ArrayList<>();
    static {
        mChecklist.add(new ChecklistItem(0, "Getting Started", false));
        mChecklist.add(new ChecklistItem(1, "Career Planning", false));
        mChecklist.add(new ChecklistItem(2, "Explore these links to think about your interests, skills, and careers \n" +
                "-Career Exploration - link https://www.bls.gov/k12/content/students/careers/career-exploration.htm \n" +
                "- Career assessment tools - link https://www.monster.com/career-advice/article/best-free-career-assessment-tools \n" +
                "- MnCareers Interest Assessment tool - https://mygpslifeplan.org/app/interest-assessment \n" +
                "- My Next Move - Interest Profiler - https://www.mynextmove.org/explore/ip \n" +
                "- Career Interest Explorer - link https://careerwise.minnstate.edu/careers/interestassessment.html  \n" +
                "- GPS LifePlan - https://mygpslifeplan.org/app/interest-assessment \n" +
                "-CAREERwise Assessment options by Minnesota State ISEEK - http://www.iseek.org/careers/stem.html  \n", false));
        mChecklist.add(new ChecklistItem(2, "-Talk with your parents/counselor/trusted adult\n", false));
        mChecklist.add(new ChecklistItem(2, "Job Shadow", false));
        mChecklist.add(new ChecklistItem(1, "Document your progress and highlight your achievements - large edit field with bullets for each item - Plus sign to add more items with large edit field\n", false));
    }
}
