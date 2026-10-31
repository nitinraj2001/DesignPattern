package DesignPattern.ObserverDesignPattern;

public class StatsDisplay implements WeatherObserver{
    @Override
    public void updateWeather(WeatherData weatherData) {
        float computeHeatIndex = weatherData.getTemperature() + weatherData.getTemperature() * weatherData.getHumidity() * 0.1f;
        System.out.println("[StatsDisplay]: " + weatherData.getTemperature() + "F degrees, " + weatherData.getPressure()
                + " Pa, " + weatherData.getHumidity() + "% humidity");
        System.out.println("[StatsDisplay]: Heat index is " + computeHeatIndex);
    }
}
