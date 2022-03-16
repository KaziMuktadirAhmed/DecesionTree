package DecesionTree;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {
    public ArrayList<Wine> data;
    public Node leftChild, rightChild;

    public String classType = "";
    public int conditionAttribute;
    public double conditionThreshold;

    public Node (ArrayList<Wine> data) {
        this.data = data;
        setClassType();
    }

    public Node(ArrayList<Wine> data, Node leftChild, Node rightChild) {
        this.data = data;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        setClassType();
    }

    public boolean shouldSplit() {
        double[] count = new double[4];
        Arrays.fill(count, 0);

        for (Wine wine : data) {
            count[0]++;
            count[wine.classType]++;
        }

        return count[1] * count[2] + count[2] * count[3] + count[3] * count[1] > 0;
    }

    public void splitByGivenCondition() {
        ArrayList<Wine> leftChildData = new ArrayList<>();
        ArrayList<Wine> rightChildData = new ArrayList<>();

        for (Wine wine : data) {
            if (wine.get(conditionAttribute) <=  conditionThreshold)
                leftChildData.add(wine);
            else
                rightChildData.add(wine);
        }

        leftChild = new Node(leftChildData);
        rightChild = new Node(rightChildData);
    }

    private void setClassType () {
        double[] count = new double[4];
        Arrays.fill(count, 0);
        for (Wine wine : data) {
            count[0]++;
            count[wine.classType]++;
        }

        for (int i=1; i<4; i++) {
            if (count[i] != 0)
                classType += i;
        }
    }

    public double informationGain() {
        double totalAvg = 0, gain = 0;
        double probabilityOfLeft = (double) leftChild.data.size() / data.size();
        double probabilityOfRight = (double) rightChild.data.size() / data.size();

        totalAvg = probabilityOfLeft * leftChild.entropy() +  probabilityOfRight * rightChild.entropy();
        gain = entropy() - totalAvg;

        return gain;
    }

    public double entropy() {
        double result = 0.0;
        int maximumClassCount = 3;

        double[] count = new double[maximumClassCount+1];
        Arrays.fill(count, 0);

        for (Wine wine : data) {
            count[0]++;
            count[wine.classType]++;
        }

        for (int i=1; i<maximumClassCount+1; i++) {
            if(count[i] != 0)
                result -= (count[i]/count[0]) * logBase2(count[i]/count[0]);
        }

        return result;
    }

    private double logBase2 (double value) {
        double result;
        result = Math.log(value) / Math.log(2);
        return result;
    }

    public void setCondition(int conditionAttribute, double conditionThreshold) {
        this.conditionAttribute = conditionAttribute;
        this.conditionThreshold = conditionThreshold;
    }

    public void printNode(int tabLevel) {
        double[] count = new double[4];
        Arrays.fill(count, 0);
        for (Wine wine : data) {
            count[0]++;
            count[wine.classType]++;
        }

        for (int i=0; i<tabLevel; i++) System.out.print("\t");
        System.out.println("Total size " + count[0]);
        for (int i=0; i<tabLevel; i++) System.out.print("\t");
        System.out.println("Class Type " + classType);
        for (int i=0; i<tabLevel; i++) System.out.print("\t");
        System.out.println("Condition attr: " + conditionAttribute + " Condition threshold: " + conditionThreshold);
        for (int i=0; i<tabLevel; i++) System.out.print("\t");
        System.out.println("Class 1: " + count[1]);
        for (int i=0; i<tabLevel; i++) System.out.print("\t");
        System.out.println("Class 2: " + count[2]);
        for (int i=0; i<tabLevel; i++) System.out.print("\t");
        System.out.println("Class 3: " + count[3]);
        System.out.println("");
    }

    public boolean isLeaf () {
        return conditionAttribute == 0 && conditionThreshold == 0.0;
    }
}

