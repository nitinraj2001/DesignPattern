package DesignPattern.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStation implements WeatherObservables{

    private final List<WeatherObserver> observers;

    public WeatherStation(){
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(WeatherObserver weatherObserver) {
        if(weatherObserver != null){
            this.observers.add(weatherObserver);
            System.out.println("-----New observer added to the list of observers---------");
        }
    }

    @Override
    public void removeObserver(WeatherObserver weatherObserver) {
        if(weatherObserver != null){
            this.observers.remove(weatherObserver);
            System.out.println("----Observer removed from the list of observers-------");
        }

    }

    @Override
    public void notifyObservers(WeatherData weatherData) {
        System.out.println("----Notifying all observers about the change in weather data-----");
        for(WeatherObserver weatherObserver : this.observers){
            weatherObserver.updateWeather(weatherData);
        }
    }

    /**
     * This method is used to set the measurements of the weather data
     * and notify all observers about the change in weather data
     * @param weatherData it represents the weather data that is to be set
     */
    public void setMeasurements(WeatherData weatherData){
        notifyObservers(weatherData);
    }
}
