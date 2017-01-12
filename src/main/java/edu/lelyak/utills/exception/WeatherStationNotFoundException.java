package edu.lelyak.utills.exception;

import edu.lelyak.utills.common.StringUtilities;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class WeatherStationNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final String STATION_NOT_FOUND_EXCEPTION = "Station, with id: [%0$s] is not found on mocked DB.";

    public WeatherStationNotFoundException() {
        super();
    }

    public WeatherStationNotFoundException(String description, Throwable reason) {
        super(StringUtilities.appendStrings(STATION_NOT_FOUND_EXCEPTION, description, reason.getMessage()), reason);
    }

    public WeatherStationNotFoundException(String description) {
        super(StringUtilities.appendStrings(STATION_NOT_FOUND_EXCEPTION, description));
    }

    public WeatherStationNotFoundException(Throwable exceptionMessage) {
        super(exceptionMessage);
    }
}
