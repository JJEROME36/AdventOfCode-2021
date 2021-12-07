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

        List<String> data = new ArrayList<String>();
        List<Integer> dataNumber = new ArrayList<Integer>();

        while (sc.hasNextLine())
        {
            data.add(sc.next());
        }

        data = Arrays.asList(data.get(0).split(","));
        for(String s : data) dataNumber.add(Integer.valueOf(s));

        int max = Collections.max(dataNumber);
        int[] allPoints =  new int[max];

        for(int i = 0; i < max; i++)
        {
            for(int j = 0; j < dataNumber.size(); j++)
            {
                if(i < dataNumber.get(j))
                {
                    allPoints[i] += dataNumber.get(j) - i;
                }
                else if(i > dataNumber.get(j))
                {
                    allPoints[i] += i - dataNumber.get(j);
                }
            }
        }

        int min = allPoints[0];
        int index = 0;
        for (int i = 1; i < allPoints.length; i++)
        {
            if (allPoints[i] <= min){
                min = allPoints[i];
                index = i;
            }
        }
        System.out.println(allPoints[index]);
    }
}
