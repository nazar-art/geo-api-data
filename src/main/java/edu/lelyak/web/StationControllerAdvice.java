package edu.lelyak.web;

import edu.lelyak.utills.exception.WeatherStationNotFoundException;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StationControllerAdvice {

    @ResponseBody
    @ExceptionHandler(WeatherStationNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    VndErrors userNotFoundExceptionHandler(WeatherStationNotFoundException ex) {
        return new VndErrors("error", ex.getMessage());
    }
}
