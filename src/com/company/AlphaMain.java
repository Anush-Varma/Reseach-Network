package com.company;

public class AlphaMain {

    public static void main(String[] args) {

        BST tree;
        tree = FileReader.readResearcherProfiles("researchers.txt");
        FileReader.readResearcherProfiles("researchers.txt").printAlphabetical();

    }
}
