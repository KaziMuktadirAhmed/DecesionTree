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
        if (RootNode != null)
            splitNode(RootNode);
    }

    private void splitNode(Node currentParent) {
        if (shouldSplit(currentParent)) {
            int splitAttr = findBestSplitAttribute(currentParent);
            double splitPoint = findBestSplitPoint(currentParent, splitAttr);



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

    private double findBestSplitPoint(Node node, int attrToSplit) {
        double splitPoint = 0;
        return splitPoint;
    }

    private int findBestSplitAttribute (Node node) {
        int splitAttr = 0;
        return splitAttr;
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
