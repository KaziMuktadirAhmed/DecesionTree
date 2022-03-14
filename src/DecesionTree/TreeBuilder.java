package DecesionTree;

import java.util.ArrayList;

public class TreeBuilder {
    private Node parentNode;
    private int parentLevel;

    public TreeBuilder(Node parentNode, int parentLevel) {
        this.parentNode = parentNode;
        this.parentLevel = parentLevel;
    }

    public void build() {

    }

    private double logBase3 (double value) {
        double result;
        result = Math.log(value) / Math.log(3);
        return result;
    }
}
