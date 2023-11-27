package ru.t1.probation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TextProcessorController {
    private static final Logger log = LoggerFactory.getLogger(TextProcessorController.class);

    @GetMapping()
    public String compute() {
        log.info("compute results");
        return "compute results";
    }
}
