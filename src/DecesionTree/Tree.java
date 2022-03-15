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
    }

    private void buildTree() {
        treeBuilder = new TreeBuilder(root, 13);
        treeBuilder.build();
    }

    public boolean search() {
        boolean serachVal = true;
        return false;
    }

    public void traverseTree () {
        if (root == null) {
            return;
        }
        traverseTree(root);
    }

    public void traverseTree (Node startNode) {
        System.out.println(startNode);

        if (startNode.leftChild != null) {
            System.out.print("\t");
            System.out.print("l: ");
            System.out.println(startNode.leftChild);
            traverseTree(startNode.leftChild);
        }

        if (startNode.rightChild != null) {
            System.out.print("\t");
            System.out.print("r: ");
            System.out.println(startNode.rightChild);
            traverseTree(startNode.rightChild);
        }
    }
}
