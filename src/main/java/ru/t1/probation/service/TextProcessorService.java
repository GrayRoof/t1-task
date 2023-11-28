package ru.t1.probation.service;

import java.util.List;
import java.util.Map;

public interface TextProcessorService {

    /**
     * Реализует подсчет символов в строке.
     * Формирует список с указанием количества вхождений каждого символа в заданную строку.
     * @param text строка, в которой требуется произвести подсчет
     * @param ignoreCase указывает, следует ли игнорировать регистр
     * @return список пар ключ-значение (Map.Entry), где
     * <ul>
     * <li>Ключ Character - символ
     * <li>Значение Integer - количество вхождений символа в заданную строку
     * <ul/>
     */
    List<Map.Entry<Character, Integer>> getFrequencyOfChar(String text, boolean ignoreCase);
}
