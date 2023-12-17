package edu.project3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class MarkdownReportGenerator implements ReportGenerator {

    private static final int ERROR_200 = 200;
    private static final int ERROR_404 = 404;
    private static final int ERROR_500 = 500;
    private static final String TABLE_ROW_SEPARATOR = " | \n";

    private String getFormattedDate(List<LogEntry> logEntries, boolean isStartDate) {

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    private long calculateAverageResponseSize(List<LogEntry> logEntries) {
        long totalSize = 0;
        for (LogEntry entry : logEntries) {
            totalSize += entry.getResponseSize();
        }
        return logEntries.isEmpty() ? 0 : totalSize / logEntries.size();
    }

    @Override
    public void saveToMarkdownFile(List<LogEntry> logEntries, String outputPath) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {
            writer.write("#### Общая информация \n\n");
            writer.write("|        Метрика        |     Значение | \n");
            writer.write("|:---------------------:|-------------:| \n");
            writer.write("|       Файл(-ы)        | `access.log` | \n");
            writer.write("|    Начальная дата     |   " + getFormattedDate(logEntries, true)
                + TABLE_ROW_SEPARATOR);
            writer.write("|     Конечная дата     |   " + getFormattedDate(logEntries, false)
                + TABLE_ROW_SEPARATOR);
            writer.write("|  Количество запросов  |       " + logEntries.size() + " |\n");
            writer.write("| Средний размер ответа |       " + calculateAverageResponseSize(logEntries) + "b | \n\n");

            writer.write("#### Запрашиваемые ресурсы \n\n");
            writer.write("|     Ресурс      | Количество | \n");
            writer.write("|:---------------:|-----------:| \n");

            Map<String, Integer> resourceCounts = countResources(logEntries);
            List<Map.Entry<String, Integer>> sortedResources = sortMapByValue(resourceCounts);

            for (Map.Entry<String, Integer> entry : sortedResources) {
                writer.write(String.format("|  `%s`  |      %,d | \n", entry.getKey(), entry.getValue()));
            }

            writer.write("\n#### Коды ответа\n\n");
            writer.write("| Код |          Имя          | Количество | \n");
            writer.write("|:---:|:---------------------:|-----------:| \n");

            Map<Integer, Integer> responseCodeCounts = countResponseCodes(logEntries);
            List<Map.Entry<Integer, Integer>> sortedResponseCodes = sortMapByValue(responseCodeCounts);

            for (Map.Entry<Integer, Integer> entry : sortedResponseCodes) {
                writer.write(String.format(
                    "|  %d  |          %s           |       %,d | \n",
                    entry.getKey(),
                    getResponseCodeName(entry.getKey()),
                    entry.getValue()
                ));
            }

        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private Map<String, Integer> countResources(List<LogEntry> logEntries) {
        Map<String, Integer> resourceCounts = new HashMap<>();
        for (LogEntry entry : logEntries) {
            resourceCounts.merge(entry.getResource(), 1, Integer::sum);
        }
        return resourceCounts;
    }

    private Map<Integer, Integer> countResponseCodes(List<LogEntry> logEntries) {
        Map<Integer, Integer> responseCodeCounts = new HashMap<>();
        for (LogEntry entry : logEntries) {
            responseCodeCounts.merge(entry.getResponseCode(), 1, Integer::sum);
        }
        return responseCodeCounts;
    }

    private <K, V extends Comparable<? super V>> List<Map.Entry<K, V>> sortMapByValue(Map<K, V> map) {
        return map.entrySet()
            .stream()
            .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
            .collect(Collectors.toList());
    }

    private String getResponseCodeName(int responseCode) {
        return switch (responseCode) {
            case ERROR_200 -> "OK";
            case ERROR_404 -> "Not Found";
            case ERROR_500 -> "Internal Server Error";
            default -> "Unknown";
        };
    }
}
