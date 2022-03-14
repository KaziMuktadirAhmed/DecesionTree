package DecesionTree;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {
    public String classType = "";
    public ArrayList<Wine> data;
    public double conditionThreshold;
    public Node leftChild, rightChild;

    public Node (ArrayList<Wine> data) {
        this.data = data;
    }

    public Node(ArrayList<Wine> data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public double enthropy() {
        double result = 0.0;
        int maximumClassCount = 3;

        double[] count = new double[maximumClassCount+1];
        Arrays.fill(count, 0);

        for (Wine wine : data) {
            count[0]++;
            count[wine.classType]++;
        }

        for (int i=1; i<maximumClassCount+1; i++) {
            result -= (count[i]/count[0]) * logBase2(count[i]/count[0]);
        }

        return result;
    }

    private double logBase2 (double value) {
        double result;
        result = Math.log(value) / Math.log(2);
        return result;
    }
}
