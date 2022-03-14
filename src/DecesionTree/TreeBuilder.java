package DecesionTree;

public class TreeBuilder {
    private Node RootNode;

    public TreeBuilder(Node RootNode) {
        this.RootNode = RootNode;
    }

    public void build() {
        splitNode(RootNode, 0);
    }

    private void splitNode(Node currentParent, int currentLevel) {
        if (shouldSplit(currentParent)) {

            splitNode(currentParent.leftChild, currentLevel + 1);
            splitNode(currentParent.rightChild, currentLevel + 1);
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



//    private double logBase3 (double value) {
//        double result;
//        result = Math.log(value) / Math.log(3);
//        return result;
//    }
}
