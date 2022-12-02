package com.company;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ProfileMain {

    public static void main(String[] args) throws FileNotFoundException {

        ArrayList<String> interests = new ArrayList<String>();
        interests.add("cars");
        interests.add("space");
        interests.add("drones");
        Profile p1 = new Profile("Varma", "Anush", 12, 2, 2, "email", interests);
        Profile p2 = new Profile("Jones", "Tom", 12, 2, 22, "email", interests);
        Profile p3 = new Profile("Hazard", "James", 12, 2, 22, "email", interests);
        Profile p4 = new Profile("Wills", "David", 12, 2, 22, "email", interests);
        Profile p5 = new Profile("Edwards", "Lewis", 12, 2, 22, "email", interests);


        p1.collaborate(p2);
        p1.collaborate(p3);

        System.out.println(p1.getFamilyNames() + " " + p1.getGivenNames() + " " + p1.hasCollaboratedWith(p2) + " " + p1.getDateOfPhD() + " " + p1.numOfCollabs());
        ArrayList<String> p1Intersests = new ArrayList<>();
        p1Intersests = p1.getResearchInts();

        for (String intersest : p1Intersests) {
            System.out.println(intersest);
        }

        System.out.println(p1.toString());

    }


}
