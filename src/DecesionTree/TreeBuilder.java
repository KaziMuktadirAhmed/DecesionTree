package DecesionTree;

import java.util.ArrayList;

public class TreeBuilder {
    private final Node RootNode;
    private final int maxDimension;

    public TreeBuilder(Node RootNode, int maxDimension) {
        this.RootNode = RootNode;
        this.maxDimension = maxDimension;
    }

    public void build() {
        if (RootNode != null) {
            splitNode(RootNode);
        }
    }

    private void splitNode(Node currentParent) {
        if (!currentParent.shouldSplit())
            return;

        findBestSplitPoint(currentParent);
        currentParent.splitByGivenCondition();

        System.out.println("left child count: " + currentParent.leftChild.data.size());
        if(currentParent.leftChild.shouldSplit()){
            splitNode(currentParent.leftChild);}

        System.out.println("right child count: " + currentParent.rightChild.data.size());
        if(currentParent.rightChild.shouldSplit()){
            splitNode(currentParent.rightChild);}
    }



    private void findBestSplitPoint(Node node) {
        Node tempNode = new Node(node.data);
        double initialGain = -1;

        for (Wine wine : tempNode.data) {
            for (int i = 1; i <= maxDimension; i++) {
                tempNode.setCondition(i, wine.get(i));
                tempNode.splitByGivenCondition();

                if (tempNode.informationGain() > initialGain) {
                    initialGain = tempNode.informationGain();
                    node.setCondition(tempNode.conditionAttribute, tempNode.conditionThreshold);
                }
            }
        }
    }

    private double findAvgAttributeValue (Node node, int attrIndex) {
        double avg = 0.0;
        for (Wine wine : node.data) {
            avg += wine.get(attrIndex);
        }
        avg = avg / (double) node.data.size();
        return avg;
    }
}