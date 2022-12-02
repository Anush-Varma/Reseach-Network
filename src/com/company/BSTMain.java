package com.company;

import java.util.ArrayList;

public class BSTMain {

    public static void main(String[] args) {
        ArrayList<String> interests = new ArrayList<String>();
        interests.add("cars");
        interests.add("space");
        interests.add("drones");

        BST tree = new BST();

        Profile p1 = new Profile("Varma", "Anush", 12, 2, 2, "email", interests);
        Profile p2 = new Profile("Jones", "Tom", 12, 2, 22, "email", interests);
        Profile p3 = new Profile("Hazard", "James", 12, 2, 22, "email", interests);
        Profile p4 = new Profile("Wills", "David", 12, 2, 22, "email", interests);
        Profile p5 = new Profile("Edwards", "Lewis", 12, 2, 22, "email", interests);

        tree.insertResearcher(p1);
        tree.insertResearcher(p2);
        tree.insertResearcher(p3);
        tree.insertResearcher(p4);
        tree.insertResearcher(p5);

        System.out.println(tree.printAlphabetical());

        for (Profile p : tree.returnAllNodes()) {
            System.out.println(p.toString());
        }

    }
}
