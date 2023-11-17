package edu.hm6.task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private static final String HACKER_NEWS_API_URL = "https://hacker-news.firebaseio.com/v0/topstories.json";
    private static final String NEWS_ITEM_URL_FORMAT = "https://hacker-news.firebaseio.com/v0/item/%d.json";

    public long[] hackerNewsTopStories() {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(HACKER_NEWS_API_URL))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String[] ids = response.body().replaceAll("\\[|\\]", "").split(",");
                long[] topStories = new long[ids.length];
                for (int i = 0; i < ids.length; i++) {
                    topStories[i] = Long.parseLong(ids[i].trim());
                }
                return topStories;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new long[0];
    }

    public String news(long id) {
        String newsItemUrl = String.format(NEWS_ITEM_URL_FORMAT, id);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(newsItemUrl))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                // Используем регулярное выражение для извлечения названия новости
                Pattern pattern = Pattern.compile("\"title\":\"(.*?)\"");
                Matcher matcher = pattern.matcher(response.body());
                if (matcher.find()) {
                    return matcher.group(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "News not found";

    }
}
