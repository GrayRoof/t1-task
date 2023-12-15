package ru.t1.probation.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TextProcessorServiceImplTest {

    @Autowired
    private TextProcessorServiceImpl textProcessorService;

    @Test
    @DisplayName("Should return list with first entry 'u' when given more 'u'")
    void shouldReturnListU() {
        List<Map.Entry<Character, Integer>> expected = new ArrayList<>();
        expected.add(Map.entry('u', 9));
        expected.add(Map.entry('y', 8));

        List<Map.Entry<Character, Integer>> actual = textProcessorService
                .getFrequencyOfChar("yuyuyuyyyuuyuyuuu", true);
        assertEquals(expected,actual);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    @DisplayName("Should return list with first entry 'y' when given more 'y'")
    void shouldReturnListY() {
        List<Map.Entry<Character, Integer>> expected = new ArrayList<>();
        expected.add(Map.entry('y', 4));
        expected.add(Map.entry('u', 2));
        List<Map.Entry<Character, Integer>> actual = textProcessorService
                .getFrequencyOfChar("uyuyyy", true);
        assertEquals(expected, actual);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    @DisplayName("Should return empty list when given empty text")
    void shouldReturnEmptyList() {
        List<Map.Entry<Character, Integer>> expected = new ArrayList<>();

        List<Map.Entry<Character, Integer>> actual = textProcessorService
                .getFrequencyOfChar("", true);
        assertEquals(expected,actual);
        assertTrue(actual.isEmpty());
    }

    @Test
    @DisplayName("Should return ordered result list case sensitive")
    void shouldReturnOrderedCaseSensitive() {
        List<Map.Entry<Character, Integer>> expected = new ArrayList<>();
        expected.add(Map.entry('u', 7));
        expected.add(Map.entry('y', 7));
        expected.add(Map.entry('U', 2));
        expected.add(Map.entry('Y', 1));

        List<Map.Entry<Character, Integer>> actual = textProcessorService
                .getFrequencyOfChar("yuyuYuyyyUUyuyuuu", false);
        assertEquals(expected,actual);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    @DisplayName("Should return one entry list when given one letter")
    void shouldReturnListOneEntry() {
        List<Map.Entry<Character, Integer>> expected = new ArrayList<>();
        expected.add(Map.entry('y', 1));

        List<Map.Entry<Character, Integer>> actual = textProcessorService
                .getFrequencyOfChar("y", true);
        assertEquals(expected, actual);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    @DisplayName("Should return one entry list when given four whitespaces")
    void shouldReturnListOneEntryWhenFourWhitespaces() {
        List<Map.Entry<Character, Integer>> expected = new ArrayList<>();
        expected.add(Map.entry(' ', 4));

        List<Map.Entry<Character, Integer>> actual = textProcessorService
                .getFrequencyOfChar("    ", true);
        assertEquals(expected, actual);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    @DisplayName("Should return two entries list when given a(eng) and a(rus)")
    void shouldReturnListTwoEntriesWhenDiffLang() {
        List<Map.Entry<Character, Integer>> expected = new ArrayList<>();
        expected.add(Map.entry('а', 3));
        expected.add(Map.entry('a', 3));

        List<Map.Entry<Character, Integer>> actual = textProcessorService
                .getFrequencyOfChar("aaaааа", true);
        assertEquals(expected, actual);
        assertEquals(expected.toString(),actual.toString());
    }

    @Test
    @DisplayName("Should return sorted list when given non-letter characters")
    void shouldReturnListWhenNonLetter() {
        List<Map.Entry<Character, Integer>> expected = new ArrayList<>();
        expected.add(Map.entry('}', 5));
        expected.add(Map.entry('[', 4));
        expected.add(Map.entry('%', 3));
        expected.add(Map.entry('$', 2));
        expected.add(Map.entry('(', 2));
        expected.add(Map.entry(')', 2));
        expected.add(Map.entry('*', 2));
        expected.add(Map.entry('@', 1));
        expected.add(Map.entry('#', 1));
        expected.add(Map.entry('&', 1));
        expected.add(Map.entry('\n', 1));
        expected.add(Map.entry('№', 1));
        expected.add(Map.entry('\\', 1));
        expected.add(Map.entry('^', 1));
        expected.add(Map.entry('?', 1));

        List<Map.Entry<Character, Integer>> actual = textProcessorService
                .getFrequencyOfChar("@#$*&^$№%%%\n\\?*(())[[[[}}}}}", true);
        assertEquals(expected, actual);
        assertEquals(expected.toString(),actual.toString());
    }
}