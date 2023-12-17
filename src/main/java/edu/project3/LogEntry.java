package edu.project3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class LogEntry {
    private static final int MINIMUM_PARTS_REQUIRED = 12;
    private static final int IP_ADDRESS_COLUMN = 0;
    private static final int DATE_COLUMN_START = 3;
    private static final int DATE_COLUMN_END = 4;
    private static final int METHOD_COLUMN = 5;
    private static final int RESOURCE_COLUMN = 6;
    private static final int RESPONSE_CODE_COLUMN = 8;
    private static final int RESPONSE_SIZE_COLUMN = 9;
    private String ipAddress;
    private Date date;
    private String method;
    private String resource;
    private int responseCode;
    private int responseSize;

    public LogEntry(String ipAddress, Date date, String method, String resource, int responseCode, int responseSize) {
        this.ipAddress = ipAddress;
        this.date = date;
        this.method = method;
        this.resource = resource;
        this.responseCode = responseCode;
        this.responseSize = responseSize;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public Date getDate() {
        return date;
    }

    public String getMethod() {
        return method;
    }

    public String getResource() {
        return resource;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public static LogEntry parseFromLogLine(String line) {
        String[] parts = line.split(" ");
        if (parts.length < MINIMUM_PARTS_REQUIRED) {
            return null;
        }

        String ipAddress = parts[IP_ADDRESS_COLUMN];
        String dateString = parts[DATE_COLUMN_START] + " " + parts[DATE_COLUMN_END];
        Date date = parseDate(dateString);
        String method = parts[METHOD_COLUMN].replace("\"", "");
        String resource = parts[RESOURCE_COLUMN];
        int responseCode = Integer.parseInt(parts[RESPONSE_CODE_COLUMN]);
        int responseSize = Integer.parseInt(parts[RESPONSE_SIZE_COLUMN]);

        return new LogEntry(ipAddress, date, method, resource, responseCode, responseSize);
    }

    private static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("[dd/MMM/yyyy:HH:mm:ss Z]", Locale.ENGLISH);
        try {
            return dateFormat.parse(dateString);
        } catch (ParseException e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
