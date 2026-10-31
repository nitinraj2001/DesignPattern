package DesignPattern.ObserverDesignPattern;

public class CurrentConditionDisplay implements WeatherObserver {

    private float temperature;

    private float pressure;

    private float humidity;

    @Override
    public void updateWeather(WeatherData weatherData) {
        this.temperature = weatherData.getTemperature();
        this.pressure = weatherData.getPressure();
        this.humidity = weatherData.getHumidity();
        display();
    }

    public void display(){
        System.out.println("[CurrentConditionDisplay]" + " Current conditions: " + temperature +
                "F degrees, " + pressure + " Pa, " + humidity + "% humidity");
    }
}
