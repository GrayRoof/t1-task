package ru.t1.probation.service;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
public class TextProcessorServiceImpl implements TextProcessorService {

    @Override
    public List<Map.Entry<Character, Integer>> getFrequencyOfChar(String text, boolean ignoreCase) {
        final char[] charsToProcess;
        Comparator<Map.Entry<Character, Integer>> comparatorByValue = Map.Entry.comparingByValue();
        final List<Map.Entry<Character, Integer>> result = new ArrayList<>();

        if (!text.isEmpty()) {
            final HashMap<Character, Integer> frequency = new HashMap<>();

            if (ignoreCase) {
                charsToProcess = text.toLowerCase().toCharArray();
            } else {
                charsToProcess = text.toCharArray();
            }

            for (char c : charsToProcess) {
                frequency.put(c, frequency.getOrDefault(c, 0) + 1);
            }
            result.addAll(frequency
                    .entrySet()
                    .stream()
                    .sorted(comparatorByValue.reversed())
                    .collect(Collectors.toList()));
        }
        return result;
    }
}
