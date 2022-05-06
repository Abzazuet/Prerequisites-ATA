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
}
