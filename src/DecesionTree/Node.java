package DecesionTree;

import java.util.ArrayList;

public class Node {
    public String classType;
    public ArrayList<Wine> data;
    public Node leftChild, rightChild;

    public Node () {}

    public Node(String classType, ArrayList<Wine> data, Node leftChild, Node rightChild) {
        this.classType = classType;
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
