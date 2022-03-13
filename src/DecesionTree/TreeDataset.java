package DecesionTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeDataset {
    private final String filePath;

    public ArrayList<Wine> wines = new ArrayList<>();
    public ArrayList<ArrayList<Wine>> controlData = new ArrayList<>();

    public TreeDataset (String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        parseDataFile();
    }

    private void parseDataFile() throws FileNotFoundException {
        File dataFile = new File(filePath);
        Scanner scanDataFile = new Scanner(dataFile);

        String[] wineData;

        while (scanDataFile.hasNextLine()) {
            String dataLine = scanDataFile.nextLine();
            wineData = dataLine.split(",", 0);

            Wine wine = new Wine();
            for (int i=1; i<wineData.length; i++) {
                wine.set(i, Double.parseDouble(wineData[i]));
            } wines.add(wine);
        }
    }
}
