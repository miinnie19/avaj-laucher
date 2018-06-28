package mnaidoo.flyings;

import mnaidoo.weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super (name, coordinates);
    }

    public void updateConditions()
    {
        String weatherCoordinates =  weatherTower.getWeather(this.coordinates);
//        System.out.println(weatherCoordinates);
        switch(weatherCoordinates)
        {
            case "SUN": this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 10, coordinates.getHeight() + 2);
                writings.printOut("JetPlane" + "#" + this.name  + "(" + this.id + "):" + " Its so hot the Plane is gonna expand hehe");
                break;


            case "RAIN": this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                writings.printOut("JetPlane" + "#" + this.name  + "(" + this.id + "):" + " ABORT ABORT its RAINING");
                break;

            case "FOG": this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                writings.printOut("JetPlane" + "#" + this.name  + "(" + this.id + "):" + " I tried to catch some *FOG* but I mist.");
                break;

            case "SNOW": this.coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                writings.printOut("JetPlane" + "#" + this.name  + "(" + this.id + "):" + " Ahh the Snow...now I want to build an OLAF");
                break;

            default:break;
        }

        if(this.coordinates.getHeight() <= 0)
        {
            writings.printOut("JetPlane" + "#" + this.name  + this.id + " landing.");
            this.weatherTower.unregister(this);
            writings.printOut("Tower says: " +  "JetPlane" + "#" + this.name  +  "(" + this.id + ")" + " unregistered from weather tower.");
        }

    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
        writings.printOut("Tower says: " +  "JetPlane" + "#" + this.name  + "(" + this.id + ")" + " registered to weather tower.");
    }

}
