package DecesionTree;

import java.util.ArrayList;
import java.util.Arrays;

public class TreeBuilder {
    private Node RootNode;
    private int maxDimention;

    public TreeBuilder(Node RootNode, int maxDimention) {
        this.RootNode = RootNode;
        this.maxDimention = maxDimention;
    }

    public void build() {
        if (RootNode != null)
            splitNode(RootNode);
    }

    private void splitNode(Node currentParent) {
        if (shouldSplit(currentParent)) {
            findBestSplitPoint(currentParent);

            ArrayList<Wine> leftChildData = new ArrayList<>();
            ArrayList<Wine> rightChildData = new ArrayList<>();

            for (Wine wine : currentParent.data) {
                if (wine.get(currentParent.conditionAttribute) <=  currentParent.conditionThreshold)
                    leftChildData.add(wine);
                else
                    rightChildData.add(wine);
            }

            currentParent.leftChild = new Node(leftChildData);
            currentParent.rightChild = new Node(rightChildData);

            splitNode(currentParent.leftChild);
            splitNode(currentParent.rightChild);
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

    private void findBestSplitPoint(Node node) {

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
