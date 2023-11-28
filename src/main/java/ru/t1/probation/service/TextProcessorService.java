package ru.t1.probation.service;

import java.util.List;
import java.util.Map;

public interface TextProcessorService {

    List<Map.Entry<Character, Integer>> getFrequencyOfChar(String text, boolean ignoreCase);
}
