package DecesionTree;

import java.io.FileNotFoundException;

public class Tree {
    private TreeBuilder treeBuilder;
    private final TreeDataset treeDataset;
    public Node root = null;

    public Tree (String filePath) throws FileNotFoundException {
        treeDataset = new TreeDataset(filePath);
        this.root = new Node(treeDataset.TrainingDataset);
        buildTree();
    }

    public Tree (TreeDataset treeDataset) {
        this.treeDataset = treeDataset;
        this.root = new Node(treeDataset.TrainingDataset);
        buildTree();
    }

    private void buildTree() {
        treeBuilder = new TreeBuilder(root, 13);
        treeBuilder.build();
    }

    public int checkWine(Wine wineToBeChecked) {
        int foundClass = -1;
        foundClass = Integer.parseInt(findWine(root, wineToBeChecked));
        return foundClass;
    }

    private String findWine(Node startNode, Wine wineToBeChecked) {
        String retVal = "";
        if (!startNode.isLeaf()) {
            if (wineToBeChecked.get(startNode.conditionAttribute) <= startNode.conditionThreshold)
                retVal = findWine(startNode.leftChild, wineToBeChecked);
            else
                retVal = findWine(startNode.rightChild, wineToBeChecked);
        }
        else {
            retVal = startNode.classType;
        }

        return retVal;
    }

    public void traverseTree () {
        if (root == null) {
            return;
        }
        traverseTree(root, 1);
    }

    private void traverseTree (Node startNode, int tabLevel) {
        startNode.printNode(tabLevel-1);


        if (startNode.leftChild != null) {
            System.out.print("l: ");
            traverseTree(startNode.leftChild, tabLevel+1);
        }

        if (startNode.rightChild != null) {
            System.out.print("r: ");
            traverseTree(startNode.rightChild, tabLevel+1);
        }
    }
}
