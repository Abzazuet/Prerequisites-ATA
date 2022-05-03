package log_programs;


import java.io.File;
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

    public void printAll() {
        for (LogEntry le : records) {
            System.out.println(le);
        }
    }
}
