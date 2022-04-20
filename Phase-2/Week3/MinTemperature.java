import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;

public class MinTemperature {

    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar, String parameter) {
        if (smallestSoFar == null) {
            smallestSoFar = currentRow;
        } else {
            double current = Double.parseDouble(currentRow.get(parameter));
            double largest = Double.parseDouble(smallestSoFar.get(parameter));
            if (current < largest) {
                smallestSoFar = currentRow;
            }
        }
        return smallestSoFar;
    }

    public CSVRecord coldestHourInFile(CSVParser parser) {
        CSVRecord smallestSoFar = null;
        for (CSVRecord currentRow : parser) {
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "TemperatureF");
        }
        return smallestSoFar;
    }

    public void testColdestInDay() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord smallest = coldestHourInFile(parser);
        System.out
                .println(
                        "Coldest temperature was: " + smallest.get("TemperatureF") + "F at " + smallest.get("DateUTC"));

    }

    public String fileWithColdestTemperature(CSVRecord smallestSoFar) {
        String smallestTemperatureFile = ("weather-" + smallestSoFar.get("DateUTC").substring(0, 10) + ".csv");
        String route = ("nc_weather/" + smallestSoFar.get("DateUTC").substring(0, 4) + "/" + smallestTemperatureFile);
        System.out.println("Coldest day was in file " + smallestTemperatureFile);
        System.out.println("All the temperatures on the coldest day were:");
        FileResource fr = new FileResource(route);
        for (CSVRecord record : fr.getCSVParser()) {
            System.out.println(record.get("DateUTC") + ": " + record.get("TemperatureF"));
        }
        return route;
    }

    public CSVRecord coldestInManyDays() {
        CSVRecord smallestSoFar = null;
        CSVRecord currentRow = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser csvFr = fr.getCSVParser();
            currentRow = coldestHourInFile(csvFr);
            if (Double.parseDouble(currentRow.get("TemperatureF")) == -9999) {
                continue;
            }
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "TemperatureF");
        }
        return smallestSoFar;
    }

    public void testColdestInManyDays() {
        CSVRecord smallest = coldestInManyDays();
        System.out
                .println(
                        "Coldest temperature on that day was " + smallest.get("TemperatureF") + "F at "
                                + smallest.get("DateUTC"));
        fileWithColdestTemperature(smallest);
    }

    public CSVRecord lowestHumidityInFile(CSVParser parser) {
        CSVRecord smallestSoFar = null;
        for (CSVRecord currentRow : parser) {
            
            if (currentRow.get("Humidity").contains("N/A")) {
                continue;
            }
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "Humidity");
        }
        return smallestSoFar;
    }

    public void testLowestHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        CSVRecord csv = lowestHumidityInFile(parser);
        System.out.println("Lowest humidity was " + csv.get("Humidity") + " at " + csv.get("DateUTC"));
    }

    public CSVRecord lowestHumidityInManyFiles() {
        CSVRecord smallestSoFar = null;
        CSVRecord currentRow = null;
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser csvFr = fr.getCSVParser();
            currentRow = lowestHumidityInFile(csvFr);
            smallestSoFar = getSmallestOfTwo(currentRow, smallestSoFar, "Humidity");
        }
        return smallestSoFar;
    }

    public void testLowestHumidityInManyFiles() {
        CSVRecord lowest = lowestHumidityInManyFiles();
        System.out.println("Lowest humidity was " + lowest.get("Humidity") + " at " + lowest.get("DateUTC"));
    }

    public double averageTemperature(CSVParser parser) {
        double average = 0;
        double counter = 0;
        for (CSVRecord record : parser) {
            average += Double.parseDouble(record.get("TemperatureF"));
            counter++;
        }

        return average / counter;
    }

    public void testAverageTemperature() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println("Average temperature in file is " + averageTemperature(parser));
    }

    public double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value) {
        double average = 0;
        double counter = 0;
        for (CSVRecord record : parser) {
            int humidity = Integer.parseInt(record.get("Humidity"));
            if (humidity > value) {
                average += Double.parseDouble(record.get("TemperatureF"));
                counter++;
            }
        }
        if (average == 0) {
            return 0;
        }
        return average / counter;
    }

    public void testAverageTemperatureWithHighHumidityInFile() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        double average = averageTemperatureWithHighHumidityInFile(parser, 80);
        if (average == 0) {
            System.out.println("No temperatures with that humidity");
        } else {
            System.out.println("Average temperature when high humidity is " + average);
        }
    }

    public static void main(String[] args) {
        MinTemperature min = new MinTemperature();
        min.testColdestInManyDays();
    }
}
