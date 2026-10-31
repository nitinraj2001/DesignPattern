package DesignPattern.ObserverDesignPattern;

public interface WeatherObservables {

    // This method is used to add an observer to the list of observers
    public void addObserver(WeatherObserver weatherObserver);

    // This method is used to remove an observer from the list of observers
    public void removeObserver(WeatherObserver weatherObserver);

    // This method is used to notify all observers about the change in weather data
    public void notifyObservers(WeatherData weatherData);
}
