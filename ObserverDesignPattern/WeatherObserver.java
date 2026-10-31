package DesignPattern.ObserverDesignPattern;

public interface WeatherObserver {

    // This method is used to update the observer with the latest weather data
    public void updateWeather(WeatherData weatherData);
}
