import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class MaxTemperature {

    public CSVRecord getLargestOfTwo(CSVRecord currentRow, CSVRecord largestSoFar) {
        if (largestSoFar == null) {
            largestSoFar = currentRow;
        } else {
            double currentTemp = Double.parseDouble(currentRow.get("TemperatureF"));
            double largestTemp = Double.parseDouble(largestSoFar.get("TemperatureF"));
            if (currentTemp > largestTemp) {
                largestSoFar = currentRow;
            }
        }
        return largestSoFar;
    }

    public CSVRecord hottestHourInFile(CSVParser parser) {
        CSVRecord largestSoFar = null;
        for (CSVRecord currentRow : parser) {
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }

    public void testHottestInDay() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord largest = hottestHourInFile(parser);
        System.out.println("Hottest temperature was: " + largest.get("TemperatureF") + "F at " + largest.get("DateUTC"));

    }

    public CSVRecord hottestInManyDays() {
        CSVRecord largestSoFar = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVRecord currentRow = hottestHourInFile(fr.getCSVParser());
            largestSoFar = getLargestOfTwo(currentRow, largestSoFar);
        }
        return largestSoFar;
    }

    public void testHottestInManyDays() {
        CSVRecord largest = hottestInManyDays();
        System.out.println("Hottest temperature was: " + largest.get("TemperatureF") + "F at " + largest.get("DateUTC"));

    }

    
    public static void main(String[] args) {
        MaxTemperature max = new MaxTemperature();
        max.testHottestInManyDays();
    }
}
