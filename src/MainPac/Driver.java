package MainPac;

import DecesionTree.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Driver {
    private TreeDataset treeDataset;
    private TreeBuilder treeBuilder;
    private Tree decesionTree;

    public void run() throws FileNotFoundException {
        treeDataset = new TreeDataset("wine.data");
        decesionTree = new Tree(treeDataset);
        decesionTree.traverseTree();

        double accuracy = calculateAggregatedAverage();
        System.out.println("Accuracy: " + accuracy*100 + " percent");
    }

    private double calculateAvgAccuracy_crossValidation () throws FileNotFoundException {
        double aggregatedAvgAccuracy = 0.0;
        treeDataset = new TreeDataset("wine.data");



        return aggregatedAvgAccuracy;
    }

    private double calculateAggregatedAverage() throws FileNotFoundException {
        double aggregatedAvgAccuracy = 0.0;

        for (int i=0; i<1000; i++) {
            treeDataset = new TreeDataset("wine.data");
            decesionTree = new Tree(treeDataset);
            aggregatedAvgAccuracy += calculateAccuracy(treeDataset.TestingDataset, decesionTree);
        }

        aggregatedAvgAccuracy /= 1000;
        return aggregatedAvgAccuracy;
    }

    private double calculateAccuracy (ArrayList<Wine> testSet, Tree decesionTree) {
        double average = 0.0;
        int totalTestCase = testSet.size();
        int totalAccurateFound = 0;

        for (Wine wine : testSet) {
            if (wine.classType == decesionTree.checkWine(wine))
                totalAccurateFound++;
        }

        average = (double) totalAccurateFound / (double) totalTestCase;
        return average;
    }
}
