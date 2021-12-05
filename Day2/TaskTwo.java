import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskTwo
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

        List<String> command = new ArrayList<String>();
        List<Integer> value = new ArrayList<Integer>();

        while(sc.hasNextLine())
        {
            command.add(sc.next());
            value.add(Integer.parseInt(sc.next()));
        }

        int depth = 0;
        int position = 0;
        int aim = 0;
        for(int i = 0; i < command.size(); i++)
        {
            if(command.get(i).equals("up"))
            {
                aim -= value.get(i);
            }
            else if(command.get(i).equals("down"))
            {
                aim += value.get(i);
            }
            else
            {
                position += value.get(i);
                depth += aim * value.get(i);
            }
        }

        long result = position*depth;
        System.out.println(result);
    }
}
