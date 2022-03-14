package DecesionTree;

import java.util.ArrayList;

public class Node {
    public String classType;
    public ArrayList<Wine> data;
    public ArrayList<Node> childs;

    public Node () {}

    public Node(String classType, ArrayList<Wine> data, ArrayList<Node> childs) {
        this.classType = classType;
        this.data = data;
        this.childs = childs;
    }
}
