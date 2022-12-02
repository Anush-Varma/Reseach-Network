package com.company;

import java.util.ArrayList;

public class BSTNodeMain {

    public static void main(String[] args) {

        ArrayList<String> interests = new ArrayList<String>();
        interests.add("cars");
        interests.add("space");
        interests.add("drones");
        Profile p1 = new Profile("Varma", "Anush", 12, 2, 2, "email", interests);
        Profile p2 = new Profile("Jones", "Tom", 12, 2, 22, "email", interests);
        Profile p3 = new Profile("Hazard", "James", 12, 2, 22, "email", interests);
        BSTNode nodeTest = new BSTNode(p1);
        BSTNode p2Node = new BSTNode(p2);
        BSTNode p3Node = new BSTNode(p3);
        System.out.println(nodeTest.getResearcher().toString());
        nodeTest.setR(p2Node);
        nodeTest.setL(p3Node);

        System.out.println(nodeTest.getR().getResearcher().toString());
        System.out.println(nodeTest.getL().getResearcher().toString());
        for (BSTNode node : nodeTest.getChildren()) {
            System.out.println(node.getResearcher().getFamilyNames());
        }


    }
}
