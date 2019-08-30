package com.lourence.jonh.section.repository;

public class Section {
    private int sectionId;
    private String sectionName;
    private String yearLevel;

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

    public String getYearLevel() {
        return yearLevel;
    }
}
