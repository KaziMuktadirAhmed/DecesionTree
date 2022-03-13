package DecesionTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TreeDataset {
    private final String filePath;

    public ArrayList<Wine> wines = new ArrayList<>();
    public ArrayList<ArrayList<Wine>> controlData = new ArrayList<>();

    public ArrayList

    public TreeDataset (String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        parseDataFile();
    }

    private void parseDataFile() throws FileNotFoundException {
        File dataFile = new File(filePath);
        Scanner scanDataFile = new Scanner(dataFile);

        this.controlData.add(new ArrayList<Wine>());
        this.controlData.add(new ArrayList<Wine>());
        this.controlData.add(new ArrayList<Wine>());

        String[] wineData;

        while (scanDataFile.hasNextLine()) {
            String dataLine = scanDataFile.nextLine();
            wineData = dataLine.split(",", 0);

            Wine wine = new Wine();
            for (int i=1; i<wineData.length; i++) {
                wine.set(i, Double.parseDouble(wineData[i]));
            } wines.add(wine);

            if (Integer.parseInt(wineData[0]) == 1)
                this.controlData.get(0).add(wine);
            else if (Integer.parseInt(wineData[0]) == 2)
                this.controlData.get(1).add(wine);
            else if (Integer.parseInt(wineData[0]) == 3)
                this.controlData.get(2).add(wine);
        }
    }
}
