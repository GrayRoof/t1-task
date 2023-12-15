package ru.t1.probation.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.t1.probation.service.TextProcessorService;

import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TextProcessorController.class)
class TextProcessorControllerTest {

    @MockBean
    private TextProcessorService textProcessorService;

    @Autowired
    private MockMvc mvc;

    @Test
    void shouldReturn200WithList() throws Exception {
        List<Map.Entry<Character, Integer>> result = new ArrayList<>(Map.of('a', 5).entrySet());
        when(textProcessorService.getFrequencyOfChar(anyString(), anyBoolean()))
                .thenReturn(result);
        mvc.perform(get("/frequency")
                        .param("text", "bbaaaaa")
                        .param("ignoreCase", "true"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.[0].a", is(5)));
    }

    @Test
    void shouldReturn400WhenTooLongText() throws Exception {
        ValidationException exception = new ConstraintViolationException("ValidationException", new HashSet<>());

        when(textProcessorService.getFrequencyOfChar(anyString(), anyBoolean()))
                .thenThrow(exception);
        mvc.perform(
                get("/frequency")
                        .param("text", "bbaaaaa")
                        .param("ignoreCase","true")
                )
                .andExpect(status().isBadRequest());
    }
}