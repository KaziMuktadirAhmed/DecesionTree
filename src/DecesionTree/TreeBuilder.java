package DecesionTree;

import java.util.ArrayList;

public class TreeBuilder {
    private ArrayList<Wine> parentNodeData;
    private int parentLevel;

    public TreeBuilder(ArrayList<Wine> parentNodeData, int parentLevel) {
        this.parentNodeData = parentNodeData;
        this.parentLevel = parentLevel;
    }

    private double logBase3 (double value) {
        double result;
        result = Math.log(value) / Math.log(3);
        return result;
    }
}
