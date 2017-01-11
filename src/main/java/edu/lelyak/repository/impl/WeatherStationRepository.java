package edu.lelyak.repository.impl;

import edu.lelyak.model.WeatherStation;

public interface WeatherStationRepository /*extends CrudRepository<WeatherStation, String>*/ {

    WeatherStation findById(String id);

    WeatherStation findByName(String name);
}
