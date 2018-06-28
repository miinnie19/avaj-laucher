package mnaidoo.simulator;

import java.io.*;

public class WriteToFile {
    private static File file = null;
    private static FileWriter fileWriter = null;
    private static BufferedWriter bufferedWriter = null;

    public WriteToFile()
    {
        try
        {
            file = new File("simulation.txt");
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
        }
        catch (IOException exc){ }
    }

    public static void printOut(String str)
    {
        try
        {
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }catch (IOException exc)
        {
            exc.printStackTrace();
        }
    }

    public static void closeFile()
    {
        try
        {
            if (bufferedWriter != null)
                bufferedWriter.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
