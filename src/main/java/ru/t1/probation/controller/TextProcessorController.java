package ru.t1.probation.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.t1.probation.service.TextProcessorService;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
public class TextProcessorController {

    private final TextProcessorService textProcessorService;


    @GetMapping("/frequency")
    public List<Map.Entry<Character, Integer>> process(@Valid
                                               @RequestParam(defaultValue = "")
                                               @Size(max = 100, message = "length must be no more than 100 characters")
                                               String text,
                                                       @RequestParam(defaultValue = "true") boolean ignoreCase) {
        log.info("SERVER FREQUENCY GET, text is {}, ignoreCase is {}", text, ignoreCase);
        return textProcessorService.getFrequencyOfChar(text, ignoreCase);
    }
}
