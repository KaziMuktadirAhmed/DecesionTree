package DecesionTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TreeDataset {
    private final String filePath;

    public ArrayList<Wine> wines = new ArrayList<>();
    public ArrayList<ArrayList<Wine>> controlData = new ArrayList<>();

    public ArrayList<Wine> TrainingDataset = new ArrayList<>();
    public ArrayList<Wine> TestingDataset;

    public TreeDataset (String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        setInitialDatasets();
    }

    private void setInitialDatasets() throws FileNotFoundException {
        parseDataFile();
        setTrainingDataset();
    }

    private void parseDataFile() throws FileNotFoundException {
        File dataFile = new File(filePath);
        Scanner scanDataFile = new Scanner(dataFile);

        this.controlData.add(new ArrayList<>());
        this.controlData.add(new ArrayList<>());
        this.controlData.add(new ArrayList<>());

        String[] wineData;

        while (scanDataFile.hasNextLine()) {
            String dataLine = scanDataFile.nextLine();
            wineData = dataLine.split(",", 0);

            Wine wine = new Wine();
            for (int i=0; i<wineData.length; i++) {
                wine.set(i, Double.parseDouble(wineData[i]));
            } wines.add(wine);

            if (wine.classType == 1)
                this.controlData.get(0).add(wine);
            else if (wine.classType == 2)
                this.controlData.get(1).add(wine);
            else if (wine.classType == 3)
                this.controlData.get(2).add(wine);
        }
    }

    private void setTrainingDataset () {
        ArrayList<Wine> tempWines = new ArrayList<>(wines);
        int maximumSize = (int) Math.ceil(((double) wines.size() * 90) / (double) 100);

        while (TrainingDataset.size() < maximumSize) {
            int newRandomIndex = rangedRandom(0, tempWines.size()-1);
            TrainingDataset.add(tempWines.get(newRandomIndex));
            tempWines.remove(newRandomIndex);
        }

        TestingDataset = new ArrayList<>(tempWines);
    }

    private int rangedRandom (int start, int end) {
        Random rand = new Random();
        return rand.nextInt(end - start + 1) + start;
    }
}
