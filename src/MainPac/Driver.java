package MainPac;

import DecesionTree.*;

import java.io.FileNotFoundException;

public class Driver {
    private TreeDataset treeDataset;
    private TreeBuilder treeBuilder;

    public Driver() throws FileNotFoundException {
    }

    public void run() throws FileNotFoundException {
        treeDataset = new TreeDataset("wine.data");
    }
}
