package com.designPattern.headfirst.chap1_observer.jdk_observer;

import java.util.Observable;
import java.util.Observer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author mujian
 * @Desc
 * @date 2019/8/31 11:53
 */
@Slf4j
public class CurrentConditionsDisplay implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionsDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        log.info("{}        {}        ",temperature,temperature);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData) o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
