package com.company;

import java.util.ArrayList;

public class GraphMain {

    public static void main(String[] args) {


        BST tree;
        tree = FileReader.readResearcherProfiles("researchers.txt");

        ArrayList<String> interests = new ArrayList<String>();
        interests.add("cars");
        interests.add("space");
        interests.add("drones");
        Profile p1 = new Profile("Varma", "Anush", 12, 2, 2, "email", interests);
        Profile p2 = new Profile("Jones", "Tom", 12, 2, 22, "email", interests);
        Profile p3 = new Profile("Hazard", "James", 12, 2, 22, "email", interests);
        Profile p4 = new Profile("Wills", "David", 12, 2, 22, "email", interests);
        Profile p5 = new Profile("Edwards", "Lewis", 12, 2, 22, "email", interests);


        BST tree2 = new BST();

        p1.collaborate(p2);
        p1.collaborate(p3);
        tree2.insertResearcher(p1);
        tree2.insertResearcher(p2);
        tree2.insertResearcher(p3);
        tree2.insertResearcher(p4);
        tree2.insertResearcher(p5);


        Graph graph = new Graph("edges.txt", tree);
        Graph graph2 = new Graph("edgelist-1.txt", tree2);
        Graph graph3 = new Graph("edgelist-2.txt", tree2);

        System.out.println(graph.findInfluencer("van Wijngaarden").getFamilyNames());
        System.out.println(graph.findInfluencer("Astarte").getFamilyNames());
        //incorrect input error check
        //System.out.println(graph.findInfluencer("Viktor").getFamilyNames());

        System.out.println(graph2.findInfluencer("Varma").getFamilyNames());
        //incorrect input error check
        //System.out.println(graph2.findInfluencer("Joe").getFamilyNames());

        System.out.println(graph3.findInfluencer("Wills").getFamilyNames());
        //incorrect input error check
        //.out.println(graph3.findInfluencer("WrongInput").getFamilyNames());


    }
}
