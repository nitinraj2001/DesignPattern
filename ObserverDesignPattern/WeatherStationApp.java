package DesignPattern.ObserverDesignPattern;

public class WeatherStationApp {

    public static void main(String[] args){

        // Create an instance of WeatherData with initial values
        WeatherData weatherData = new WeatherData(30.0f, 1013.0f, 70.0f);
        // Created an instances of weather observers and added them to the list of observers
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        StatsDisplay statsDisplay = new StatsDisplay();
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.addObserver(currentConditionDisplay);
        weatherStation.addObserver(statsDisplay);
        // Now let's notify the current weather data to all observers
        weatherStation.setMeasurements(weatherData);

        // Create an instance of WeatherData with initial values
        WeatherData weatherData2 = new WeatherData(20.0f, 1018.0f, 70.0f);
        // Now let's remove the currentConditionDisplay observer from the list of observers
        // and notify the new weather data to all observers
        weatherStation.removeObserver(currentConditionDisplay);
        weatherStation.setMeasurements(weatherData2);

    }
}
