package com.company;


/**
 * BST class holds data on a binary search tree
 * Contains the root node of the binary tree.
 */

import java.util.ArrayList;

public class BST {

    //Root node of the tree
    private BSTNode root;

    /**
     * sets root to null to create an empty tree
     */
    public BST() {
        this.root = null;
    }

    /**
     * adds a profile to root node if empty tree
     *
     * @param p profile to be added in the tree
     */
    public void insertResearcher(Profile p) {
        BSTNode temp = new BSTNode(p);
        if (root == null) {
            root = temp;
        } else {
            add(root, temp);
        }
    }


    /**
     * Adds the profile to the left or right child of the root node
     * or to subtrees
     *
     * @param root Root node of the current subtree
     * @param node node to be placed into the tree
     * @return current node
     */
    private BSTNode add(BSTNode root, BSTNode node) {

        BSTNode current = root;
        int compare = current.getResearcher().getFamilyNames().compareToIgnoreCase(node.getResearcher().getFamilyNames());
        if ((current.getL() == null) && (compare > 0)) {
            current.setL(node);
        } else if ((current.getR() == null) && (compare < 0)) {
            current.setR(node);
        } else {
            if (compare > 0) {
                return add(current.getL(), node);
            } else {
                return add(current.getR(), node);
            }
        }

        return current;
    }

    /**
     * Prints the family names of the profiles
     * in the tree in alphabetical order
     *
     * @return the string of family names in alphabetical order
     */
    public String printAlphabetical() {

        return inOrder(root);
    }

    /**
     * Recursive loop of inOrder traversal of the tree
     *
     * @param node the current profile
     * @return String of family names of profiles in
     * alphabetical order
     */
    private String inOrder(BSTNode node) {

        if (node == null) {
            return "";
        }

        inOrder(node.getL());
        System.out.println(node.getResearcher().getFamilyNames() + ", " + node.getResearcher().getGivenNames());
        inOrder(node.getR());
        return "";
    }

    /**
     * @return Array list containing profiles from the BST
     */
    public ArrayList<Profile> returnAllNodes() {

        ArrayList<Profile> listOfProfiles = new ArrayList<>();
        bstNodes(root, listOfProfiles);
        return listOfProfiles;
    }

    /**
     * @param node        current done to get children
     * @param listOfNodes adds profiles to the array list when traversing the tree
     * @return list of nodes in the BST
     */
    private ArrayList<Profile> bstNodes(BSTNode node, ArrayList<Profile> listOfNodes) {

        if (node != null) {
            listOfNodes.add(node.getResearcher());
            ArrayList<BSTNode> children = node.getChildren();
            if (children != null) {
                for (BSTNode child : children) {
                    bstNodes(child, listOfNodes);
                }
            }
        }
        return listOfNodes;
    }


}
