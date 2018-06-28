package mnaidoo.weather;

import mnaidoo.flyings.Flyable;

import java.util.ArrayList;
import java.util.List;

public class Tower
{
    private  List<Flyable> observers = new ArrayList<>();
    private  List<Flyable> unregistered = new ArrayList<>();


    public void register(Flyable flyable)
    {
        if (observers.contains(flyable))
            return;
        else
            observers.add(flyable);
    }

    public void unregister(Flyable flyable)
    {
        if (unregistered.contains(flyable))
            return;
        else
            unregistered.add(flyable);
    }

    protected void conditionsChanged()
    {
        for (Flyable flyable : observers)
            flyable.updateConditions();
        observers.removeAll(unregistered);
    }

}