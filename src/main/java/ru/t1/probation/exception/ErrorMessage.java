package ru.t1.probation.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.util.Date;

@Getter
@AllArgsConstructor
@Value
public class ErrorMessage {
    Date timestamp;
    int statusCode;
    String error;
    String path;
}
