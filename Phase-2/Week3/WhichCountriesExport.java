import edu.duke.*;
import org.apache.commons.csv.*;

public class WhichCountriesExport {
    public void listExporters(CSVParser parser, String exportOfInterest) {

        for (CSVRecord record : parser) {
            String export = record.get("Exports");
            if (export.contains(exportOfInterest)) {
                String country = record.get("Country");
                System.out.println(country);
            }
        }
    }

    public String countryInfo(CSVParser parser, String country) {
        for (CSVRecord record : parser) {
            String countryInterest = record.get("Country");
            if (countryInterest.contains(country)) {
                return (countryInterest + ": " + record.get("Exports") + ": " + record.get("Value (dollars)"));
            }
        }
        return "NOT FOUND";
    }

    public void listExportersTwoProducts(CSVParser parser, String exportItem1, String exportItem2) {
        for (CSVRecord record : parser) {
            String exports = record.get("Exports");
            if (exports.contains(exportItem1) && exports.contains(exportItem2)) {
                System.out.println(record.get("Country"));
            }
        }
    }

    public int numberOfExporters(CSVParser parser, String exportItem) {
        int counter = 0;
        for (CSVRecord record : parser) {
            if (record.get("Exports").contains(exportItem)) {
                counter++;
            }
        }
        return counter;
    }

    public void bigExporters (CSVParser parser, String dollarsSign){
        for (CSVRecord record: parser){
            if (dollarsSign.length() < record.get("Value (dollars)").length()){
                System.out.println(record.get("Country")+" "+record.get("Value (dollars)"));
            }
        }
    }

    public void whoExportsCoffee() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExporters(parser, "coffee");
    }

    public void testCountryInfo() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(countryInfo(parser, "Nauru"));

    }

    public void exportsTwoItems() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        listExportersTwoProducts(parser, "cotton", "flowers");
    }

    public void countCountriesExporting() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        System.out.println(numberOfExporters(parser, "cocoa"));

    }
    public void testBigExporters() {
        FileResource fr = new FileResource();
        CSVParser parser = fr.getCSVParser();
        bigExporters(parser, "$999,999,999,999");

    }

    public static void main(String[] args) {
        WhichCountriesExport countries = new WhichCountriesExport();
        countries.testBigExporters();
    }
}