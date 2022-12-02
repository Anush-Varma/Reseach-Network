

package com.company;
/**
 * BSTNode class contains a profile which is the value of the node
 * for the BST tree and has references to children nodes
 */

import java.util.ArrayList;

public class BSTNode {
    //The profile/value of the node
    private Profile researcher;
    //left child reference (BSTNode)
    private BSTNode l;
    //right child reference (BSTNode)
    private BSTNode r;

    /**
     * Adds a profile to the node
     * @param elem the researcher/ profile of the node
     */
    public BSTNode(Profile elem) {
        this.researcher = elem;
        this.l = null;
        this.r = null;
    }

    /**
     *
     * @return profile of current node
     */
    public Profile getResearcher() {
        return researcher;
    }

    /**
     *
     * @param l set left child of node
     */
    public void setL(BSTNode l) {
        this.l = l;
    }

    /**
     *
     * @param r set right child of node
     */
    public void setR(BSTNode r) {
        this.r = r;
    }

    /**
     *
     * @return left child
     */
    public BSTNode getL() {
        return l;
    }

    /**
     *
     * @return right child
     */
    public BSTNode getR() {
        return r;
    }

    /**
     *
     * @return arraylist containing children of the node
     */
    public ArrayList<BSTNode> getChildren() {
        ArrayList<BSTNode> children = new ArrayList<>();
        children.add(r);
        children.add(l);

        return children;

    }
}
