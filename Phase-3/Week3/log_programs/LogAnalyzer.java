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
        System.out.println(uniqueIPs.size());
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

    public int mostNumberVisitsByIP() {
        HashMap<String, Integer> map = countVisitsPerIP();
        int current = 0;
        for (String key : map.keySet()) {
            if (map.get(key) > current) {
                current = map.get(key);
            }
        }
        return current;
    }

    public ArrayList<String> iPsMostVisits() {
        ArrayList<String> ipAddresses = new ArrayList<String>();
        HashMap<String, Integer> map = countVisitsPerIP();
        int mostVisits = mostNumberVisitsByIP();
        for (String key : map.keySet()) {
            if (map.get(key) == mostVisits) {
                ipAddresses.add(key);
            }
        }
        return ipAddresses;
    }

    public HashMap<String, ArrayList<String>> iPsForDays() {
        HashMap<String, ArrayList<String>> day_ips = new HashMap<String, ArrayList<String>>();
        ArrayList<String> ips = new ArrayList<String>();
        for (LogEntry le : records) {
            String date = le.getAccessTime().toString().substring(4, 10);
            String ipAddress = le.getIpAddress();
            if (!day_ips.containsKey(date)) {
                ips.add(ipAddress);
                day_ips.put(date, ips);
            } else {
                ips = day_ips.get(date);
                ips.add(ipAddress);
                day_ips.put(date, ips);
            }
            ips = new ArrayList<String>();
        }
        return day_ips;
    }

    public String daysWitMostVisits(HashMap<String, ArrayList<String>> days) {
        String day = "";
        int maxVisits = 0;
        int size = 0;
        for (String key : days.keySet()) {
            size = days.get(key).size(); 
            if (size>maxVisits){
                maxVisits = size;
                day = key;
            }
        }
        return day;
    }

    public ArrayList<String> iPsWithMostVisitsOnDay(HashMap<String, ArrayList<String>> days, String day) {
        ArrayList<String> ips = new ArrayList<String>();
        
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        
        HashMap<String, ArrayList<String>> visits = new HashMap<String, ArrayList<String>>();
        visits.put(day, days.get(day));
        
        for (String visit : visits.get(day)) {
            String ip = visit;
            if (!counts.containsKey(ip)) {
                counts.put(ip, 1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        
        int max = 0;
        for (String ip : counts.keySet()){
            if(counts.get(ip)>max){
                max = counts.get(ip);
            }
        }
        for (String ip : counts.keySet()){
            if(counts.get(ip)==max){
                ips.add(ip);
            }
        }
        

        return ips;
    }

}
