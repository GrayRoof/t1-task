package ru.t1.probation.service;

import java.util.Map;

public interface TextProcessorService {

    Map<Character, Integer> getFrequencyOfChar(String text, boolean ignoreCase);
}
