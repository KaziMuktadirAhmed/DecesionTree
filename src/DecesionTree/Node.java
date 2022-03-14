package DecesionTree;

import java.util.ArrayList;
import java.util.Arrays;

public class Node {
    public String classType = "";
    public ArrayList<Wine> data;
    public ArrayList<Node> childs;

    public Node (ArrayList<Wine> data) {
        this.data = data;
    }

    public Node(ArrayList<Wine> data, ArrayList<Node> childs) {
        this.data = data;
        this.childs = childs;
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
            result -= (count[0]/count[i]) * logBase3(count[0]/count[i]);
        }

        return result;
    }

    private double logBase3 (double value) {
        double result;
        result = Math.log(value) / Math.log(3);
        return result;
    }
}
