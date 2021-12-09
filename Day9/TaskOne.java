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

        ArrayList<String> data = new ArrayList<String>();

        while (sc.hasNextLine())
        {
            data.add(sc.nextLine());
        }

        int result = 0;
        for(int i = 0; i < data.size(); i++)
        {
            for (int j = 0; j < data.get(0).length(); j++)
            {
                int center, right , left, top, bottom;
                center = data.get(i).charAt(j) - 48;
                if(i + 1 == data.size())
                {
                    if(j + 1 == data.get(0).length())
                    {
                        top = data.get(i-1).charAt(j) - 48;
                        left = data.get(i).charAt(j-1) - 48;
                        if (center < Math.min(top,left))
                        {
                            result += center + 1;
                        }

                    }
                    else if(j - 1 < 0)
                    {
                        top = data.get(i-1).charAt(j) - 48;
                        right = data.get(i).charAt(j+1) - 48;
                        if (center < Math.min(top,right))
                        {
                            result += center + 1;
                        }
                    }
                    else
                    {
                        top = data.get(i-1).charAt(j) - 48;
                        left = data.get(i).charAt(j-1) - 48;
                        right = data.get(i).charAt(j+1) - 48;
                        if (center < Math.min(right,Math.min(top,left)))
                        {
                            result += center + 1;
                        }
                    }
                }
                else if(i  - 1 < 0)
                {
                    if(j + 1 == data.get(0).length())
                    {
                        bottom = data.get(i+1).charAt(j) - 48;
                        left = data.get(i).charAt(j-1) - 48;
                        if (center < Math.min(bottom,left))
                        {
                            result += center + 1;
                        }
                    }
                    else if(j - 1 < 0)
                    {
                        bottom = data.get(i+1).charAt(j) - 48;
                        right = data.get(i).charAt(j+1) - 48;
                        if (center < Math.min(bottom,right))
                        {
                            result += center + 1;
                        }
                    }
                    else
                    {
                        bottom = data.get(i+1).charAt(j) - 48;
                        left = data.get(i).charAt(j-1) - 48;
                        right = data.get(i).charAt(j+1) - 48;
                        if (center < Math.min(right,Math.min(bottom,left)))
                        {
                            result += center + 1;
                        }
                    }
                }
                else
                {
                    if(j + 1 == data.get(0).length())
                    {
                        top = data.get(i-1).charAt(j) - 48;
                        bottom = data.get(i+1).charAt(j) - 48;
                        left = data.get(i).charAt(j-1) - 48;
                        if (center < Math.min(top,Math.min(bottom,left)))
                        {
                            result += center + 1;
                        }
                    }
                    else if(j - 1 < 0)
                    {
                        top = data.get(i-1).charAt(j) - 48;
                        bottom = data.get(i+1).charAt(j) - 48;
                        right = data.get(i).charAt(j+1) - 48;
                        if (center < Math.min(top,Math.min(bottom,right)))
                        {
                            result += center + 1;
                        }
                    }
                    else
                    {
                        top = data.get(i-1).charAt(j) - 48;
                        bottom = data.get(i+1).charAt(j) - 48;
                        left = data.get(i).charAt(j-1) - 48;
                        right = data.get(i).charAt(j+1) - 48;

                        int tmp = Math.min(top,bottom);
                        int tmp2 = Math.min(left,right);

                        if(center < Math.min(tmp,tmp2))
                        {
                            result += center + 1;
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
