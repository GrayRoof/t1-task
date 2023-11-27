package ru.t1.probation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.probation.service.TextProcessorService;

import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
public class TextProcessorController {

    private final TextProcessorService textProcessorService;

    @GetMapping()
    public Map<Character, Integer> process(@RequestParam(defaultValue = "") String text) {
        log.info("processing given text...");
        return textProcessorService.getFrequencyOfChar("ppaaaayyrttttt");
    }
}
