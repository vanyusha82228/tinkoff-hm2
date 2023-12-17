package edu.project3;

import java.util.List;

public interface ReportGenerator {
    void saveToMarkdownFile(List<LogEntry> logEntries, String outputPath);
}
