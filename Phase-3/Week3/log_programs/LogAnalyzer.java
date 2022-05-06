package log_programs;

import java.util.*;
import edu.duke.*;

public class LogAnalyzer {
    private ArrayList<LogEntry> records;

    public LogAnalyzer() {
        records = new ArrayList<LogEntry>();
    }

    public void readFile(String filename) {
        FileResource file = new FileResource(filename);
        new WebLogParser();
        for (String line : file.lines()) {
            LogEntry entry = WebLogParser.parseEntry(line);
            records.add(entry);
        }
    }

    public int countUniqueIPs() {

        ArrayList<String> uniqueIPs = new ArrayList<String>();

        for (LogEntry le : records) {
            String ipAddr = le.getIpAddress();
            if (!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }
        return uniqueIPs.size();
    }

    public void printAllHigherThanNum(int num) {
        ArrayList<LogEntry> statusCodes = new ArrayList<LogEntry>();

        for (LogEntry le : records) {
            int statusCode = le.getStatusCode();
            if (statusCode > num) {
                statusCodes.add(le);
            }
        }
        for (LogEntry le : statusCodes) {
            System.out.println(le);
        }

    }

    public void uniqueIPVisitsOnDay(String someday) {
        ArrayList<String> uniqueIPs = new ArrayList<String>();

        for (LogEntry le : records) {

            String logDate = le.getAccessTime().toString();

            if (logDate.contains(someday)) {
                String ipAddr = le.getIpAddress();

                if (!uniqueIPs.contains(ipAddr)) {
                    uniqueIPs.add(ipAddr);
                }
            }
        }
        for (String s : uniqueIPs) {
            System.out.println(s);
        }
    }

    public int countUniqueIPsInRange(int num1, int num2) {
        ArrayList<LogEntry> statusCodes = new ArrayList<LogEntry>();
        ArrayList<String> uniqueIPs = new ArrayList<String>();
        for (LogEntry le : records) {
            int statusCode = le.getStatusCode();
            if (statusCode >= num1 && statusCode <= num2) {
                statusCodes.add(le);
                String ipAddr = le.getIpAddress();

                if (!uniqueIPs.contains(ipAddr)) {
                    uniqueIPs.add(ipAddr);
                }
            }
        }
        return uniqueIPs.size();
    }

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }

    public HashMap<String, Integer> countVisitsPerIP() {
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        for (LogEntry le : records) {
            String ip = le.getIpAddress();
            if (!counts.containsKey(ip)) {
                counts.put(ip, 1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
    }

    public int mostNumberVisitsByIP(){
        return 0;
    }
    public  ArrayList<String> iPsMostVisits(){
        ArrayList<String> ipAddresses = new ArrayList<String>();
        
        return ipAddresses;
    }

    public HashMap<String, ArrayList<String>> iPsForDays(){
        HashMap<String, ArrayList<String>> day_ips = new HashMap<String, ArrayList<String>>();

        return day_ips;
    }

    public String daysWitMostVisits(HashMap<String, ArrayList<String>> days){
        String day = "";

        return day;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> days, String day){
        ArrayList<String> ips = new ArrayList<String>();

        return ips;
    }

}
