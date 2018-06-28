package mnaidoo.simulator;

import mnaidoo.flyings.Flyable;
import mnaidoo.weather.WeatherTower;
import java.io.*;
import java.lang.*;
import java.util.*;
import mnaidoo.flyings.AircraftFactory;

public class Simulator
{
    private static WeatherTower weatherTower;
    private static List<Flyable> flyables = new ArrayList<Flyable>();
    public static void main(String args[])
    {

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();
            if (line != null)
            {
                weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                System.out.println(simulations);
                if (simulations < 0)
                {
                    System.out.println("Invalid simulations count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null)
                {
                    //ParseInt will throw the exception
                    Flyable flyable = AircraftFactory.newAircraft(line.split(" ")[0], line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));

                    if (flyable != null)
                    {
                        flyables.add(flyable);
                    }
                }
                for (Flyable flyable : flyables) {
                    flyable.registerTower(weatherTower);
                }
                for (int i = 1; i <= simulations; i++) {
                    //WriteToFile.printOut("simulation: " + i);
                    weatherTower.changeWeather();
                    //WriteToFile.printOut("");
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Could not find file " + args[0]);
        } catch (IOException e) {
            System.out.println("There was an error whilst reading the file " + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Please specify simulation file");
        } catch (NullPointerException e) {
            System.out.println("value is null");
        } catch (NumberFormatException e) {
            System.out.println("A number entered is not valid in file");
        }
        finally {
            WriteToFile.closeFile();
        }
    }
}
