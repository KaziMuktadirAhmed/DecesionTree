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
        int conditionAttribute = -1;
        double conditionThreashold = -1;
        double initialGain = -1;

        for (Wine wine : node.data) {
            for (int i = 1; i <= maxDimension; i++)
            {
                Node tempNode = new Node(node.data);

                ArrayList<Wine> leftChildData = new ArrayList<>();
                ArrayList<Wine> rightChildData = new ArrayList<>();

                for (Wine tempWineData : tempNode.data) {
                    if (tempWineData.get(i) <=  wine.get(i))
                        leftChildData.add(wine);
                    else
                        rightChildData.add(wine);
                }

                tempNode.leftChild = new Node(leftChildData);
                tempNode.rightChild = new Node(rightChildData);

                if (calculateInformationGain(tempNode) > initialGain){
                    conditionAttribute = i;
                    conditionThreashold = wine.get(i);
                }
            }
        }

        node.conditionAttribute = conditionAttribute;
        node.conditionThreshold = conditionThreashold;
    }

    private double calculateInformationGain(Node node) {
        double totalAvg = 0, gain = 0;
        double probabilityOfLeft = (double) node.leftChild.data.size() / node.data.size();
        double probabilityOfRight = (double) node.rightChild.data.size() / node.data.size();

        totalAvg = probabilityOfLeft * node.leftChild.enthropy() +  probabilityOfRight * node.rightChild.enthropy();
        gain = node.enthropy() - totalAvg;

        return gain;
    }

}
