package mnaidoo.weather;

import mnaidoo.flyings.Coordinates;

import java.util.Random;

public class WeatherProvider
{
    private static WeatherProvider weatherProvider = new WeatherProvider();

    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){}

    public static WeatherProvider getProvider()
    {
        return (WeatherProvider.weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        Random randWeather = new Random();

        int rWeather = 0;
        rWeather = randWeather.nextInt(4);
        return (weather[rWeather]);

    }
}
