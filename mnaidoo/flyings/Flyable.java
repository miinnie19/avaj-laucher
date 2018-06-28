package mnaidoo.flyings;

import mnaidoo.weather.WeatherTower;

public interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);

}
