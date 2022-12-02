package com.company;

/**
 * Graph class used to create a non-directional graph using a
 * binary search tree and a text file containing edges
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Graph {

    //ArrayList containing nodes of the graph as profiles
    private ArrayList<Profile> graphNodes;

    /**
     * @param filename The file containing the edges for the graph
     * @param tree     The binary search tree which is used ot populate the nodes in the graph
     */
    public Graph(String filename, BST tree) {

        graphNodes = tree.returnAllNodes();
        fileReader(filename);

    }

    /**
     * Reads the text file containing edges and checks if the file exists
     *
     * @param filename File containing the edges for the graph
     */
    private void fileReader(String filename) {

        File file = new File(filename);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File may not exist");
            System.exit(0);
        }
        profilesExist(in);
        in.close();
    }

    /**
     * Checks if profiles names in the file exist in the BST
     * Add edges to the graph of existing nodes
     *
     * @param in Scanner of the file
     */
    private void profilesExist(Scanner in) {

        String token;
        while (in.hasNextLine()) {
            boolean exists = false;
            token = in.nextLine();
            if ((token == null || token.equals(""))) {
                exists = true;
            } else {
                Scanner line = new Scanner(token);
                line.useDelimiter(",|\\r|\\n");
                String name_1 = line.next();
                String name_2 = line.next();

                for (Profile profile : graphNodes) {
                    for (Profile profile2 : graphNodes) {
                        if (profile.getFamilyNames().equals(name_1)) {
                            if (profile2.getFamilyNames().equals(name_2)) {
                                exists = true;
                                addEdge(profile, profile2);
                            }

                        }

                    }

                }
            }
            if (!exists) {
                System.out.println("Error one of the profiles does not exist in the BST");
            }


        }
    }

    /**
     * Adds edges to the collaborators in each direction
     * to represent non-directional graph
     *
     * @param u start graph node
     * @param v end graph node for edge
     */
    private void addEdge(Profile u, Profile v) {

        for (Profile p : graphNodes) {


            if (p == u) {
                if (!p.hasCollaboratedWith(v)) {
                    p.collaborate(v);
                }
            }

            if (p == v) {
                if (!p.hasCollaboratedWith(u)) {
                    p.collaborate(u);
                }
            }

        }

    }


    /**
     * Returns the influence of the familyNames or error if the person
     * does not exist in the BST or graph.
     *
     * @param familyNames Name of person to find influencer of.
     * @return - Profile of influencer
     * - Error that Profile does not exist in BST or Graph
     * - If profile exists but can't find a valid influencer returns itself
     */
    public Profile findInfluencer(String familyNames) {

        Profile influencer = null;
        boolean existsInGraph = false;
        boolean exisitsInBST = false;
        for (Profile p : graphNodes) {
            if (p.getFamilyNames().equals(familyNames)) {
                existsInGraph = true;
                exisitsInBST = true;
                influencer = mostCollaborated(p);
            }
        }
        if (!existsInGraph) {
            System.out.println("The person: " + familyNames + " is not present in the graph");
        }

        if (influencer == null) {
            for (Profile p : graphNodes) {
                if (p.getFamilyNames().equals(familyNames)) {
                    influencer = p;
                    exisitsInBST = true;
                }
            }
        }
        if (!exisitsInBST) {
            throw new NullPointerException("Profile with family name: " + familyNames + " does not exist in the graph or BST");

        }
        return influencer;
    }

    /**
     * Finds the most collaborated person which is not itself
     *
     * @param profile the profile to find the persons most collaborated profile
     * @return Profile of most collaborated person
     */
    private Profile mostCollaborated(Profile profile) {

        Profile temp = null;
        int highest = 0;
        for (Profile p : graphNodes) {
            if (p != profile) {
                if (p.numOfCollabs() > highest) {
                    if (!p.hasCollaboratedWith(profile)) {
                        highest = p.numOfCollabs();
                        temp = p;
                    }
                }
            }

        }
        return temp;
    }


}
