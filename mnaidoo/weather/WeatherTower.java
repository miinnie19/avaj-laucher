package mnaidoo.weather;

import mnaidoo.flyings.Coordinates;

public class WeatherTower extends Tower
{
    public String getWeather(Coordinates coordinates)
    {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

     public void changeWeather()
     {
         this.conditionsChanged();
     }

}
