package DecesionTree;

import java.util.ArrayList;

public class TreeBuilder {
    private Node RootNode;
    private int maxDimention;

    public TreeBuilder(Node RootNode, int maxDimention) {
        this.RootNode = RootNode;
        this.maxDimention = maxDimention;
    }

    public void build() {
        splitNode(RootNode, 0);
    }

    private void splitNode(Node currentParent, int currentLevel) {
        if (shouldSplit(currentParent)) {
            int currentDimention = (currentLevel % maxDimention) + 1;
            double splitPoint = findBestSplitPoint(currentParent);



            splitNode(currentParent.leftChild, currentLevel + 1);
            splitNode(currentParent.rightChild,currentLevel + 1);
        }
    }

    private boolean shouldSplit(Node node) {
        if (node.data.size() == 1)
            return false;
        else {
            int refClassType = node.data.get(0).classType;
            for (Wine wine : node.data) {
                if (refClassType != wine.classType)
                    return true;
            }
        }
        return false;
    }

    private double findBestSplitPoint(Node node) {
        double splitPoint = 0;
        return splitPoint;
    }

    private double calculateWeightedAvarageOfChilds(Node node) {
        double totalAvg = 0;
        return totalAvg;
    }



//    private double logBase3 (double value) {
//        double result;
//        result = Math.log(value) / Math.log(3);
//        return result;
//    }
}
