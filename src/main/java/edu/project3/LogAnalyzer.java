package edu.project3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogAnalyzer {
    private String logPath;
    private String fromDate;
    private String toDate;
    private String outputFormat;

    public LogAnalyzer(String logPath, String fromDate, String toDate, String outputFormat) {
        this.logPath = logPath;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.outputFormat = outputFormat;
    }

    public void analyze() {
        List<LogEntry> logEntries = parseLog();
        if (logEntries.isEmpty()) {
            log.info("Нет данных для анализа.");
            return;
        }

        String outputPath = "F:\\Tinkoff2\\src\\main\\java\\edu\\project3\\logs\\output.md";

        ReportGenerator reportGenerator = getReportGenerator();
        reportGenerator.saveToMarkdownFile(logEntries, outputPath);
    }

    public List<LogEntry> parseLog() {
        List<LogEntry> logEntries = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(logPath))) {
            String line;
            while ((line = br.readLine()) != null) {
                LogEntry entry = LogEntry.parseFromLogLine(line);
                if (entry != null) {
                    logEntries.add(entry);
                }
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }

        return logEntries;
    }

    private ReportGenerator getReportGenerator() {
        return new MarkdownReportGenerator();
    }
}
