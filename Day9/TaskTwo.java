import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskTwo
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

        ArrayList<String> data = new ArrayList<String>();
        while (sc.hasNextLine())
        {
            data.add(sc.nextLine());
        }
        
        boolean[][] alreadyCheck = new boolean[data.size()][data.get(0).length()];
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < data.size(); i++)
        {
            for (int j = 0; j < data.get(0).length(); j++)
            {
               int tmp =  recursion(data,j,i,alreadyCheck);
               if(tmp > 0)
               {
                   result.add(tmp);
               }
            }
        }
        Collections.sort(result, Collections.reverseOrder());

        System.out.println(result.get(0) * result.get(1) * result.get(2));
    }

    static int recursion(ArrayList<String> data, int indexX, int indexY, boolean[][] alreadyCheck)
    {
        if((indexX > data.get(0).length() - 1 || indexX < 0) || (indexY > data.size() - 1 || indexY < 0))
        {
            return 0;
        }
        else if(data.get(indexY).charAt(indexX) == '9' || alreadyCheck[indexY][indexX] == true)
        {
            alreadyCheck[indexY][indexX] = true;
            return 0;
        }
        else
        {
            alreadyCheck[indexY][indexX] = true;
            return 1 + recursion(data, indexX+1, indexY, alreadyCheck) + recursion(data, indexX-1, indexY, alreadyCheck) + recursion(data, indexX, indexY+1, alreadyCheck) + recursion(data, indexX, indexY-1, alreadyCheck);
        }
    }
}
