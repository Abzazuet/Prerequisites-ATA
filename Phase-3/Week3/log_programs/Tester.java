package log_programs;

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer analyzer = new LogAnalyzer();
        analyzer.readFile("./logs/weblog2_log");  
        //System.out.println("All entries: ");
        //analyzer.printAll();
        int ips = analyzer.countUniqueIPs();
        System.out.println("The amount of unique IP address are: "+ips);
        int code = 400;
        System.out.println("Entries with number higher than: "+code);
        analyzer.printAllHigherThanNum(code);
        String date = "Mar 17";
        System.out.println("Visits on "+date);
        analyzer.uniqueIPVisitsOnDay(date);
        System.out.println(analyzer.countUniqueIPsInRange(400, 499));
    }
    public void testCounts(){
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("./logs/weblog2_log");
        int counts = la.mostNumberVisitsByIP();
        System.out.println(counts);
    }
    public void testMostVisits(){
        LogAnalyzer la = new LogAnalyzer(); 
        la.readFile("./logs/weblog2_log");
        HashMap<String, ArrayList<String>> ipsDays = la.iPsForDays();
        ArrayList<String> daysWitMostVisits = la.iPsWithMostVisitsOnDay(ipsDays, "Sep 30");
        System.out.println(daysWitMostVisits);
    }

    public static void main(String[] args) {
        Tester tests = new Tester();
        tests.testMostVisits();
    }
}
