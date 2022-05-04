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
        analyzer.readFile("./logs/short-test_log");  
        analyzer.printAll();
        int ips = analyzer.countUniqueIPs();
        System.out.println("The amount of unique IP address are: "+ips);
        int code = 302;
        System.out.println("Entries with number higher than: "+code);
        analyzer.printAllHigherThanNum(code);
    }
    public static void main(String[] args) {
        Tester tests = new Tester();
        tests.testLogAnalyzer();
    }
}
