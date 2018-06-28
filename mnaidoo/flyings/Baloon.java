package mnaidoo.flyings;


import mnaidoo.weather.WeatherTower;

public class Baloon extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;


    Baloon(String name, Coordinates coordinates)
    {
        super(name, coordinates);
    }

    public void updateConditions()
    {
        String weatherCoordinates = weatherTower.getWeather(this.coordinates);
        switch (weatherCoordinates)
        {
            case "SUN": this.coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                writings.printOut("Baloon" + "#" + this.name  + "(" + this.id + "):" + " Its so hot that the burner lit up by itself say whaaaaaaaat?");
                break;

            case "RAIN": this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                writings.printOut("Baloon" + "#" + this.name  + "(" + this.id + "):" + " Rain Rain go away come back another day");
                break;

            case "FOG": this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                writings.printOut("Baloon" + "#" + this.name  + "(" + this.id + "):" + " What type of cloud is so lazy that it will never get up? *FOG*!");
                break;

            case "SNOW": this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                writings.printOut("Baloon" + "#" + this.name  + "(" + this.id + "):" + " Don't FREEZE.....I never FREEZE!");
                break;

            default:break;
        }

        if (this.coordinates.getHeight() <= 0)
        {
            writings.printOut("Baloon" + "#" + this.name  + "(" + this.id + ")" + " landing.");
            this.weatherTower.unregister(this);
            writings.printOut("Tower says: " +  "Baloon" + "#" + this.name  +  "(" + this.id + ")" + " unregistered from weather tower.");
        }


    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        writings.printOut("Tower says: " +  "Baloon" + "#" + this.name  +  "(" + this.id + ")" + " registered to weather tower.");
    }
}
