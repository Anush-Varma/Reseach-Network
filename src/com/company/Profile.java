package com.company;

import java.util.ArrayList;

/**
 * Profile class generates a profile containing
 * information about each profile
 * <p>
 * Profile can be used to create Graphs and Trees of Profiles
 */


public class Profile {
    private String familyNames;
    private String givenNames;
    private int yearPhD;
    private int monthPhD;
    private int dayPhD;
    private String email;
    private ArrayList<String> researchInts;
    // Array list containing profiles who have collaborated with this profile
    private ArrayList<Profile> collaborators = new ArrayList<>();

    /**
     * @param familyNames  Family name of profile
     * @param givenNames   Given name of profile
     * @param yearPhD      year of PhD of the profile
     * @param monthPhD     month of the PhD of the profile
     * @param dayPhD       day of the PhD for teh profile
     * @param email        email of the profile
     * @param researchInts interests of the profile
     */
    public Profile(String familyNames, String givenNames, int yearPhD, int monthPhD, int dayPhD, String email, ArrayList<String> researchInts) {
        this.familyNames = familyNames;
        this.givenNames = givenNames;
        this.yearPhD = yearPhD;
        this.monthPhD = monthPhD;
        this.dayPhD = dayPhD;
        this.email = email;
        this.researchInts = researchInts;

    }

    /**
     * @return full name of profile
     */
    public String getName() {
        return givenNames + " " + familyNames;
    }


    /**
     * @return family name of profile
     */
    public String getFamilyNames() {
        return familyNames;
    }

    /**
     * @return given name of profile
     */
    public String getGivenNames() {
        return givenNames;
    }

    /**
     * @return email of profile
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return array list of profiles interests
     */
    public ArrayList<String> getResearchInts() {
        return researchInts;
    }

    /**
     * @param dayPhD set day of PhD
     */
    public void setDayPhD(int dayPhD) {
        this.dayPhD = dayPhD;
    }

    /**
     * @param email set email of profile
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param familyNames set family name of profile
     */
    public void setFamilyNames(String familyNames) {
        this.familyNames = familyNames;
    }

    /**
     * @param givenNames set given name of profile
     */
    public void setGivenNames(String givenNames) {
        this.givenNames = givenNames;
    }

    /**
     * @param yearPhD set the year of PhD
     */
    public void setYearPhD(int yearPhD) {
        this.yearPhD = yearPhD;
    }

    /**
     * @param monthPhD set the month of PhD
     */
    public void setMonthPhD(int monthPhD) {
        this.monthPhD = monthPhD;
    }

    /**
     * @param researchInts set arraylist containing profiles interests (Strings)
     */
    public void setResearchInts(ArrayList<String> researchInts) {
        this.researchInts = researchInts;
    }

    /**
     * @return day of PhD
     */
    public int getDayPhD() {
        return this.dayPhD;
    }

    /**
     * @return month of PhD
     */
    public int getMonthPhD() {
        return this.monthPhD;
    }

    /**
     * @return year of PhD
     */
    public int getYearPhD() {
        return this.yearPhD;
    }

    /**
     * @return full date of PhD for the profile
     */
    public String getDateOfPhD() {

        return String.format("%02d" + "-" + "%02d" + "-" + "%02d", getYearPhD(), getMonthPhD(), getDayPhD());
    }

    /**
     * @param p adds a profile to the collaborates arrayList
     */
    public void collaborate(Profile p) {

        this.collaborators.add(p);
    }


    /**
     * @param p profile to search
     * @return true or false if the profile p has collaborated with the current profile
     */
    public boolean hasCollaboratedWith(Profile p) {

        if (collaborators == null) {
            return false;
        } else {
            return collaborators.contains(p);
        }
    }

    /**
     * @return int value of number of collaborators with profile
     */
    public int numOfCollabs() {
        int size;
        if (collaborators == null) {
            size = 0;
        } else {
            size = collaborators.size();
        }
        return size;
    }

    /**
     * @return Method to convert a profile to string
     */
    @Override
    public String toString() {
        return "Profile{" +
                "familyNames = " + familyNames + '\'' +
                ", givenNames = " + givenNames + '\'' +
                ", yearPhD = " + yearPhD +
                ", monthPhD = " + monthPhD +
                ", dayPhD = " + dayPhD +
                ", date of PhD = " + getDateOfPhD() +
                ", email = '" + email + '\'' +
                ", researchInts = " + researchInts +
                ", num of collaborators = " + numOfCollabs() +
                ", collaborators = " + collaborators.size() +
                '}';
    }
}
