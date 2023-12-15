package ru.t1.probation;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.t1.probation.controller.TextProcessorController;
import ru.t1.probation.service.TextProcessorService;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ProbationApplicationTest {

    @Autowired
    private TextProcessorController textProcessorController;

    @Autowired
    private TextProcessorService textProcessorService;

    @Test
    void contextLoads() {
        assertThat(textProcessorController).isNotNull();
        assertThat(textProcessorService).isNotNull();
    }

}