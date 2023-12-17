package edu.project3;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProjectTest {
    @Test
    void parseFromLogLine_ValidLogEntry_ReturnsLogEntryObject() {
        String logLine = "80.91.33.133 - - [17/May/2015:08:05:14 +0000] \"GET /downloads/product_1 HTTP/1.1\" 304 0 \"-\" \"Debian APT-HTTP/1.3 (0.8.16~exp12ubuntu10.16)\"";
        LogEntry logEntry = LogEntry.parseFromLogLine(logLine);

        assertNotNull(logEntry);
        assertEquals("80.91.33.133", logEntry.getIpAddress());
        assertNotNull(logEntry.getDate());
        assertEquals("GET", logEntry.getMethod());
        assertEquals("/downloads/product_1", logEntry.getResource());
        assertEquals(304, logEntry.getResponseCode());
        assertEquals(0, logEntry.getResponseSize());
    }

    @Test
    void parseFromLogLine_InvalidLogEntry_ReturnsNull() {
        String logLine = "192.168.0.1 - - [21/Nov/2023:12:00:00 +0000] \"GET /example HTTP/1.1\" 200";
        LogEntry logEntry = LogEntry.parseFromLogLine(logLine);

        assertNull(logEntry);
    }


    @Test
    void analyze_ValidLogFile_DoesNotThrowException() {
        // Assuming you have a valid log file for testing
        String logPath = "path/to/your/log/file.log";
        LogAnalyzer logAnalyzer = new LogAnalyzer(logPath, "fromDate", "toDate", "outputFormat");

        assertDoesNotThrow(() -> logAnalyzer.analyze());
    }
}
