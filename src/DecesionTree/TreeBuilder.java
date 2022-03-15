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
        if (currentParent.shouldSplit()) {
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

    private void findBestSplitPoint(Node node) {
        int conditionAttribute;
        double conditionThreashold;
        Node tempNode = new Node(node.data);

        for (Wine wine : node.data) {
            for (int i = 1; i <= 13; i++) {

            }
        }
    }

    private double calculateInformationGain(Node node) {
        double totalAvg = 0, gain = 0;
        double probabilityOfLeft = (double) node.leftChild.data.size() / node.data.size();
        double probabilityOfRight = (double) node.rightChild.data.size() / node.data.size();

        totalAvg = probabilityOfLeft * node.leftChild.enthropy() +  probabilityOfRight * node.rightChild.enthropy();
        gain = node.enthropy() - totalAvg;

        return gain;
    }



//    private double logBase3 (double value) {
//        double result;
//        result = Math.log(value) / Math.log(3);
//        return result;
//    }
}
