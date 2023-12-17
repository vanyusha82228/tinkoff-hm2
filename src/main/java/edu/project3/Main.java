package edu.project3;


public class Main {
    private Main() {
    }

    public static void main(String[] args) {
        String logPath = "F:\\Tinkoff2\\src\\main\\java\\edu\\project3\\logs\\logs.txt";
        String fromDate = "17/May/2015:00:00:00 +0000";
        String toDate = "17/May/2015:23:59:59 +0000";
        String outputFormat = "markdown";

        LogAnalyzer logAnalyzer = new LogAnalyzer(logPath, fromDate, toDate, outputFormat);
        logAnalyzer.analyze();
    }
}
