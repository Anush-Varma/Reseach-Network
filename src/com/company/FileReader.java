package com.company;

/**
 * FileReader class used to create a binary search tree using
 * a text file provided
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileReader {

    /**
     * Returns the binary search tree made using the file
     *
     * @param filename name of file to be accessed
     * @return A binary search tree made from the text file
     */

    public static BST readResearcherProfiles(String filename) {

        File file = new File(filename);
        Scanner in = null;
        try {
            in = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println(filename + ": This file may not exist");
            System.exit(0);
        }

        BST tree = new BST();
        return readLineByLine(tree, in);

    }


    /**
     * Populates an empty BSt using the Scanner of the file
     *
     * @param tree takes in an empty BSt
     * @param in   Scanner containing file information
     * @return Returns the populated BST
     */
    private static BST readLineByLine(BST tree, Scanner in) {

        String tokens;
        while (in.hasNextLine()) {
            tokens = in.nextLine();
            Scanner line = new Scanner(tokens);
            line.useDelimiter(",|-|\\r");
            String givenNames = line.next();
            String familyNames = line.next();
            tree.insertResearcher(new Profile(familyNames, givenNames, line.nextInt(), line.nextInt(), line.nextInt(), line.next(), interests(line.next())));

        }
        return tree;
    }


    /**
     * @param researchInts String of interests of the Profile
     * @return Array list containing the interests of each profile from the file
     */
    private static ArrayList<String> interests(String researchInts) {

        return new ArrayList<String>(Arrays.asList(researchInts.split("/")));
    }


}
