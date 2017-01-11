package edu.lelyak.utills.exception;

import edu.lelyak.utills.common.StringUtilities;

public class WeatherStationIdIsNotUniqueException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private static final String CONTROL_IS_NOT_UNIQUE_EXCEPTION = "Station with the same id: [%0$s] is already defined at DB";

    public WeatherStationIdIsNotUniqueException(String id) {
        super(StringUtilities.appendStrings(CONTROL_IS_NOT_UNIQUE_EXCEPTION, id));
    }
}
