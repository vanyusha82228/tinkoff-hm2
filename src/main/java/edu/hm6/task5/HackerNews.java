package edu.hm6.task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HackerNews {
    private static final String HACKER_NEWS_API_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String NEWS_ITEM_URL_FORMAT = "https://hacker-news.firebaseio.com/v0/item/%d.json";
    private static final int HTTP_OK_STATUS_CODE = 200;
    private final HttpClient client;

    public HackerNews() {
        this.client = HttpClient.newHttpClient();
    }

    public long[] hackerNewsTopStories() {
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(HACKER_NEWS_API_URL))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HTTP_OK_STATUS_CODE) {
                String[] ids = response.body().replaceAll("\\[|\\]", "").split(",");
                long[] topStories = new long[ids.length];
                for (int i = 0; i < ids.length; i++) {
                    topStories[i] = Long.parseLong(ids[i].trim());
                }
                return topStories;
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return new long[0];
    }

    public String news(long id) {
        String newsItemUrl = String.format(NEWS_ITEM_URL_FORMAT, id);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(newsItemUrl))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == HTTP_OK_STATUS_CODE) {
                Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
                Matcher matcher = pattern.matcher(response.body());
                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return "News not found";

    }

    public void closeHttpClient() {
        client.close();
    }
}
