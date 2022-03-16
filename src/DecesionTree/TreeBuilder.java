package DecesionTree;

import java.util.ArrayList;

public class TreeBuilder {
    private final Node RootNode;
    private final int maxDimension;

    public TreeBuilder(Node RootNode, int maxDimension) {
        this.RootNode = RootNode;
        this.maxDimension = maxDimension;
//        System.out.println("okaue");
    }

    public void build() {
        if (RootNode != null) {
            splitNode(RootNode);
//            System.out.println("okay");
        }
    }

    private void splitNode(Node currentParent) {
        if (!currentParent.shouldSplit())
            return;

        findBestSplitPoint(currentParent);
        splitChildFromGivenCondition(currentParent);

        System.out.println("left child count: " + currentParent.leftChild.data.size());
        if(currentParent.leftChild.shouldSplit()){
            splitNode(currentParent.leftChild);}

        System.out.println("right child count: " + currentParent.rightChild.data.size());
        if(currentParent.rightChild.shouldSplit()){
            splitNode(currentParent.rightChild);}
    }

    private void splitChildFromGivenCondition(Node currentParent) {
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


    }

    private void findBestSplitPoint(Node node) {
        Node tempNode = new Node(node.data);
        double initialGain = -1;
        double currentGain;

        for (int i = 1; i <= maxDimension; i++)
        {
            tempNode.setCondition(i, findAvgAttributeValue(node, i));
            splitChildFromGivenCondition(tempNode);

            currentGain = tempNode.informationGain();
            if (currentGain > initialGain){
                initialGain = tempNode.informationGain();
                node.setCondition(tempNode.conditionAttribute, tempNode.conditionThreshold);
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