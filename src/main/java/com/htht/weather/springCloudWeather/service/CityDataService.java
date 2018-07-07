package com.htht.weather.springCloudWeather.service;

import com.htht.weather.springCloudWeather.vo.City;

import java.util.List;

/**
 *  City Data Service
 */
public interface CityDataService {

    List<City> listCity() throws Exception;
}
