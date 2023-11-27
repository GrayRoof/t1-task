package ru.t1.probation.service;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;

@Service
public class TextProcessorServiceImpl implements TextProcessorService {

    @Override
    public Map<Character, Integer> getFrequencyOfChar(String text, boolean ignoreCase) {
        final char[] charsToProcess;
        Map<Character, Integer> result = new TreeMap<>();

        if (ignoreCase) {
            charsToProcess = text.toLowerCase().toCharArray();
        } else {
            charsToProcess = text.toCharArray();
        }

        for (char c : charsToProcess) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}
