package com.company;

import java.util.ArrayList;

public class FileReaderMain {

    public static void main(String[] args) {
        BST tree;
        tree = FileReader.readResearcherProfiles("researchers.txt");
        FileReader.readResearcherProfiles("researchers.txt").printAlphabetical();


    }
}
