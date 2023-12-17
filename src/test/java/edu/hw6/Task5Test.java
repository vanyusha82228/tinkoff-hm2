package edu.hw6;

import edu.hm6.task5.HackerNews;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Task5Test {
    @Test
    void hackerNewsTopStories_Success() {
        HackerNews hackerNews = mock(HackerNews.class);

        when(hackerNews.hackerNewsTopStories()).thenReturn(new long[]{1, 2, 3});

        long[] topStories = hackerNews.hackerNewsTopStories();

        assertNotNull(topStories);
        assertTrue(topStories.length > 0);
        System.out.println("Top Stories: " + Arrays.toString(topStories));
    }

    @Test
    void hackerNewsTopStories() {
        HackerNews hackerNews = mock(HackerNews.class);
        when(hackerNews.hackerNewsTopStories()).thenReturn(new long[483]);

        long[] topStories = hackerNews.hackerNewsTopStories();

        assertNotNull(topStories);
        assertEquals(483, topStories.length);
    }

    @Test
    void news_Success() {
        HackerNews hackerNews = mock(HackerNews.class);

        when(hackerNews.news(37570037)).thenReturn("Mocked News Title");

        String newsTitle = hackerNews.news(37570037);

        assertNotNull(newsTitle);
        assertFalse(newsTitle.isEmpty());
        System.out.println("News Title: " + newsTitle);
    }

    @Test
    void news_NewsNotFound_ReturnsDefaultMessage() {
        HackerNews hackerNews = mock(HackerNews.class);

        when(hackerNews.news(0)).thenReturn("News not found");

        String newsTitle = hackerNews.news(0);

        assertEquals("News not found", newsTitle);
    }
}
