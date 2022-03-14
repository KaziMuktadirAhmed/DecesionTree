package DecesionTree;

import java.io.FileNotFoundException;

public class Tree {
    private TreeBuilder treeBuilder;
    private final TreeDataset treeDataset;
    public Node root = null;

    public Tree (String filePath) throws FileNotFoundException {
        treeDataset = new TreeDataset(filePath);
        this.root = new Node(treeDataset.TrainingDataset);
    }

    public Tree (TreeDataset treeDataset) {
        this.treeDataset = treeDataset;
        this.root = new Node(treeDataset.TrainingDataset);
    }

    private void buildTree() {

    }

    public boolean search() {
        boolean serachVal = true;
        return false;
    }
}
