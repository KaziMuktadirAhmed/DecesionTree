package MainPac;

import DecesionTree.*;

import java.io.FileNotFoundException;

public class Driver {
    private TreeDataset treeDataset;
    private TreeBuilder treeBuilder;
    private Tree decesionTree;

    public Driver() throws FileNotFoundException {
    }

    public void run() throws FileNotFoundException {
        decesionTree = new Tree("wine.data");
    }
}
