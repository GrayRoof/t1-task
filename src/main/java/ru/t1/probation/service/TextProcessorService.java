package ru.t1.probation.service;

import java.util.List;
import java.util.Map;

public interface TextProcessorService {

    /**
     * Реализует подсчет символов в строке.
     * Формирует список с указанием количества вхождения каждого символа
     * @param text строка, в которой требуется произвести подсчет
     * @param ignoreCase указывает следует ли игнорировать регистр
     * @return список Map.Entry<Character, Integer>. Key - символ, Value - количество вхождений
     */
    List<Map.Entry<Character, Integer>> getFrequencyOfChar(String text, boolean ignoreCase);
}
