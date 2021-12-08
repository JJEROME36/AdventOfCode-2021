import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskOne
{
    public static void main(String[] args) {
        result();
    }

    private static void result()
    {
        File file = new File("data.txt");
        Scanner sc = null;
        try
        {
            sc = new Scanner(file);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        int result = 0;
        while (sc.hasNextLine())
        {
            String[] split = sc.nextLine().split("\\|");
            String[] eachRecord = split[1].split(" ");
            for(String i : eachRecord)
            {
                if(i.length() == 2 || i.length() == 4 || i.length() == 3 || i.length() == 7)
                {
                    result++;
                }
            }
        }

        System.out.println(result);



    }
}
