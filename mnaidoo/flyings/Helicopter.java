package mnaidoo.flyings;

import mnaidoo.weather.WeatherTower;

public class Helicopter extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weatherCoordinates = weatherTower.getWeather(this.coordinates);
        switch (weatherCoordinates)
        {
            case "SUN": this.coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                writings.printOut("Helicopter" + "#" + this.name  + "(" + this.id + "):" + " Melting!!!!We are all Melting");
                break;


            case "RAIN": this.coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                writings.printOut("Helicopter" + "#" + this.name  + "(" + this.id + "):" + " OH SHIT the wipers aren't working");
                break;

            case "FOG": this.coordinates = new Coordinates(coordinates.getLongitude() + 1, coordinates.getLatitude(), coordinates.getHeight());
                writings.printOut("Helicopter" + "#" + this.name  + "(" + this.id + "):" + " How do you wrap up some *FOG*? With a rainbow...");
                break;

            case "SNOW": this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                writings.printOut("Helicopter" + "#" + this.name  + "(" + this.id + "):" + " How do you find Will Smith in the SNOW? You look for Fresh Prints!!");
                break;

            default:break;
        }

        if (this.coordinates.getHeight() <= 0)
        {
            writings.printOut("Helicopter" + "#" + this.name  + "(" + this.id + ")" + " landing.");
            this.weatherTower.unregister(this);
            writings.printOut("Tower says: " + "Helicopter" + "#" + this.name  + "(" + this.id + ")" + " unregistered from weather tower.");
        }

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        writings.printOut("Tower says: " + "Helicopter" + "#" + this.name  + "(" + this.id + ")" + " registered to weather tower.");

    }
}
