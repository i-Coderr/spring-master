package ch.sh.springmaster.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

//Record gives us private final, getter, public constructor, equals & hashcode and toString
public record ApiException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime zonedDateTime) {

}
