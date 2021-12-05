import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TaskOne
{
    public static void main(String[] args)
    {
        result();
    }

    private static void result()
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
        ArrayList<String> data = new ArrayList<String>();
        while(sc.hasNextLine())
        {
            data.add(sc.next());
        }

        int size = data.get(0).length();
        int[] sum = new int[size];

        for (String record : data)
        {
            for(int i = 0; i < record.length(); i++)
            {
                if('1' == record.charAt(i))
                {
                    sum[i]++;
                }
            }
        }

        String gammaRate = "";
        String epsilonRate = "";
        for(int i = 0; i < sum.length; i++)
        {
            if(sum[i] > data.size()/2)
            {
                gammaRate += "1";
                epsilonRate += "0";
            }
            else
            {
                gammaRate += "0";
                epsilonRate += "1";
            }
        }
        int gammaRateDecimal = Integer.parseInt(gammaRate,2);
        int epsilonRateDecimal = Integer.parseInt(epsilonRate,2);

        System.out.println(gammaRateDecimal*epsilonRateDecimal);
    }
}
