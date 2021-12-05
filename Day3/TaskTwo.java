import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskTwo
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
        ArrayList<String> oxygen = new ArrayList<String>();
        ArrayList<String> co2 = new ArrayList<String>();

        while(sc.hasNextLine())
        {
            data.add(sc.next());
        }

        int number = greaterNumber(data,0,1);
        for (String record : data)
        {
            if(number == 1 && record.charAt(0) == '1')
            {
                oxygen.add(record);
            }
            else if(number == 0 && record.charAt(0) == '0')
            {
                oxygen.add(record);
            }
            else
            {
                co2.add(record);
            }
        }

        String oxygenBinaryNumber = lastManStand(oxygen,1);
        String co2BinaryNumber = lastManStand(co2,2);

        int oxygenNumber = Integer.parseInt(oxygenBinaryNumber,2);
        int co2Number = Integer.parseInt(co2BinaryNumber,2);

        System.out.println(oxygenNumber*co2Number);
    }

    private static int greaterNumber(ArrayList<String> data,int index, int mode)
    {
        int one = 0;
        int zero = 0;

        for(String x : data)
        {
            if(x.charAt(index) == '1')
            {
                one++;
            }
            else
            {
                zero++;
            }
        }
        if(mode == 1)
        {
            return (one >= zero) ? 1 : 0;
        }
        else
        {
            return (one < zero) ? 1 : 0;
        }
    }

    private static String lastManStand(ArrayList<String> data , int mode)
    {
        int size = data.get(0).length();
        for(int i = 1; i < size && data.size() > 1; i++)
        {
            int number = 0;
            if(mode == 1)
            {
                number = greaterNumber(data, i, 1);
            }
            else
            {
                number = greaterNumber(data, i, 2);
            }
            for (int j = 0; j < data.size() && data.size() > 1; j++)
            {
                if ((number == 1 && (data.get(j).charAt(i) == '1')) || (number == 0 && (data.get(j).charAt(i) == '0')))
                {
                    continue;
                }
                else
                {
                    data.remove(j);
                    j--;
                }
            }
        }
        return data.get(0);
    }
}
