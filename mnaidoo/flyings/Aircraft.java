package mnaidoo.flyings;

import mnaidoo.simulator.WriteToFile;

public class Aircraft
{
    protected long id = 0;
    protected String name;
    protected Coordinates coordinates;
    protected WriteToFile writings = new WriteToFile();

    private static long idCounter ;

    protected Aircraft(String name, Coordinates coordinates)
    {
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }


    private long nextId()
    {
        return ++Aircraft.idCounter;
    }
}
