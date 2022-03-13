package DecesionTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TreeDataset {
    private final String filePath;

    public TreeDataset (String filePath) {
        this.filePath = filePath;
    }

    private void parseDataset() throws FileNotFoundException {
        File dataFile = new File(filePath);
        Scanner scanDataFile = new Scanner(dataFile);

        String[] wineData;

        while (scanDataFile.hasNextLine()) {
            String dataLine = scanDataFile.nextLine();
            wineData = dataLine.split(",", 0);
        }

    }
}
