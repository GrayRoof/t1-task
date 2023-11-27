package ru.t1.probation.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TextProcessorServiceImpl implements TextProcessorService {

    @Override
    public Map<Character, Integer> getFrequencyOfChar(String text) {
        Map<Character, Integer> result = new HashMap<>();

        for (char c : text.toCharArray()) {
            result.put(c, result.getOrDefault(c, 0) + 1);
        }
        return result;
    }
}
