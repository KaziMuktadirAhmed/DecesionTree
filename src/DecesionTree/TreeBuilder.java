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

        if (currentParent.shouldSplit()) {
            findBestSplitPoint(currentParent);
            splitChildFromGivenCondition(currentParent);

            splitNode(currentParent.leftChild);
            splitNode(currentParent.rightChild);
        }
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

        for (Wine wine : node.data) {
            for (int i = 1; i <= maxDimension; i++)
            {
                tempNode.setCondition(i,wine.get(i));
                splitChildFromGivenCondition(tempNode);

                double currentGain = tempNode.informationGain();
                if (tempNode.informationGain() > initialGain){
                    initialGain = tempNode.informationGain();
                    node.setCondition(tempNode.conditionAttribute, tempNode.conditionThreshold);
                }
            }
        }
    }
}
