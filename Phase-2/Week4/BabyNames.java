import edu.duke.*;

import java.io.File;

import org.apache.commons.csv.*;

public class BabyNames {

    public void printNames() {
        FileResource fr = new FileResource();

        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) + " Gender " + rec.get(1) + " Num born " + rec.get(2));
            }
        }
    }

    public void totalBirths(FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int totalNames = 0;
        int totalBoysNames = 0;
        int totalGirlNames = 0;
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                totalBoysNames++;
            } else {
                totalGirls += numBorn;
                totalGirlNames++;
            }
        }
        totalNames = totalGirlNames + totalBoysNames;
        System.out.println("Total births = " + totalBirths);
        System.out.println("Total boys = " + totalBoys);
        System.out.println("Total girls = " + totalGirls);
        System.out.println("Total names = " + totalNames);
        System.out.println("Total boys names = " + totalBoysNames);
        System.out.println("Total girls names = " + totalGirlNames);
    }

    public void testTotalBirths() {
        FileResource fr = new FileResource();
        totalBirths(fr);
    }

    public int getRank(int year, String name, String gender) {
        String file = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(file);
        int rank = 0;
        boolean nameFound = false;
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                rank++;
                if (record.get(0).equals(name)) {
                    nameFound = true;
                    break;
                }

            }
        }
        if (!nameFound) {
            rank = -1;
        }
        return rank;
    }

    public String getName(int year, int rank, String gender) {
        String file = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(file);
        boolean nameFound = false;
        String name = "";
        int contRank = 0;
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(1).equals(gender)) {
                contRank++;
                if (contRank == rank) {
                    name = record.get(0);
                    nameFound = true;
                    break;
                }
            }
        }
        if (!nameFound) {
            name = "Name not found";
        }
        return name;
    }

    public void whatIsNameInYear(String name, int year, int newYear, String gender) {
        int getRank = getRank(year, name, gender);
        String getName = getName(newYear, getRank, gender);
        System.out.println(name + " born in " + year + " would be " + getName + " if she was born in " + newYear);
    }

    public int highestOfTwo(int currentRank, int highestRank) {
        if (highestRank < 0) {
            highestRank = currentRank;

        } else if (highestRank > currentRank) {
            highestRank = currentRank;
        }
        return highestRank;
    }

    public int yearOfHighestRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        int highestRank = 0;
        int highestYear = 0;
        int year = 0;
        int getRank = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser csvFr = fr.getCSVParser();
            year = Integer.parseInt(f.getName().substring(3, 7));
            getRank = getRank(year, name, gender);
            highestRank = highestOfTwo(getRank, highestRank);
            if (getRank == -1) {
                continue;
            }
            if (getRank <= highestRank) {
                highestYear = year;
            }
        }
        if (getRank == -1 && highestYear == 0) {
            highestYear = -1;
        }
        return highestYear;
    }

    public double getAverageRank(String name, String gender) {
        DirectoryResource dr = new DirectoryResource();
        double average = 0;
        int year = 0;
        int counter = 0;
        for (File f : dr.selectedFiles()) {
            FileResource fr = new FileResource(f);
            CSVParser csvFr = fr.getCSVParser();
            year = Integer.parseInt(f.getName().substring(3, 7));
            average += getRank(year, name, gender);
            counter++;
        }
        return average / counter;
    }

    public int getTotalBirthsRankedHigher(int year, String name, String gender) {
        int totalBirths = 0;
        String file = "us_babynames/us_babynames_by_year/yob" + year + ".csv";
        FileResource fr = new FileResource(file);
        for (CSVRecord record : fr.getCSVParser(false)) {
            if (record.get(0).contains(name) && record.get(1).equals(gender)) {
                break;
            }
            if (record.get(1).equals(gender)) {
                totalBirths += Integer.parseInt(record.get(2));
            }
        }
        return totalBirths;
    }

    public static void main(String[] args) {
        BabyNames babies = new BabyNames();
        System.out.println(babies.getTotalBirthsRankedHigher(1990, "Drew", "M"));

    }
}