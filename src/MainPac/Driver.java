package MainPac;

import DecesionTree.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver {
    private TreeDataset treeDataset;
    private TreeBuilder treeBuilder;
    private Tree decesionTree;

    public Driver() throws FileNotFoundException {
    }

    public void run() throws FileNotFoundException {
        treeDataset = new TreeDataset("wine.data");
        decesionTree = new Tree(treeDataset);
        decesionTree.traverseTree();
        calculateAccuracy(treeDataset.TestingDataset, decesionTree);

        Wine testWine = treeDataset.TestingDataset.get(0);
        int classFound = decesionTree.checkWine(testWine);
        System.out.println("Class Found: " + classFound);
        System.out.println("Actual Class: " + testWine.classType);
    }

    private void calculateAccuracy (ArrayList<Wine> testSet, Tree decesionTree) {
        int totalTestCase = testSet.size();
        int totalAccurateFound = 0;

        for (Wine wine : testSet) {
            if (wine.classType == decesionTree.checkWine(wine))
                totalAccurateFound++;
        }


    }
}
