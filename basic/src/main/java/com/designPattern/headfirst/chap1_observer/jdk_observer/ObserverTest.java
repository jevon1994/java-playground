package com.designPattern.headfirst.chap1_observer.jdk_observer;

/**
 * @author mujian
 * @Desc
 * @date 2019/8/30 13:43
 */
public class ObserverTest {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(1, 2, 3);
    }
}
