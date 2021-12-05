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

        List<Integer> data = new ArrayList<Integer>();
        while (sc.hasNextLine())
        {
            data.add(Integer.parseInt(sc.nextLine()));
        }

        int A = 0;
        int B = 0;
        int result = 0;

        for(int i = 0; i < data.size()-3; i++)
        {
            A += data.get(i);
            B += data.get(i+3);

            if(A < B)
            {
                result++;
            }
            A = 0;
            B = 0;
        }
        System.out.println(result);
    }

}
