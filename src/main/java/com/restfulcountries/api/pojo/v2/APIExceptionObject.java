package com.restfulcountries.api.pojo.v2;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record APIExceptionObject(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {
}
