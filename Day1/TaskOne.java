import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskOne
{
    public static void main(String[] args)
    {
        result();
    }

    public static void result()
    {
        File file = new File("data.txt");
        Scanner sc = null;
        try
        {
            sc = new Scanner(file);
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        List<Integer> data = new ArrayList<Integer>();
        while (sc.hasNextLine())
        {
            data.add(Integer.parseInt(sc.nextLine()));
        }
        int result = 0;
        for(int i = 1; i < data.size(); i++)
        {
            if(data.get(i-1) < data.get(i))
            {
                result++;
            }
        }

        System.out.println(result);
    }

}
