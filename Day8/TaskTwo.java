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

        int resultInt = 0;

        while (sc.hasNextLine())
        {
            String[] split = sc.nextLine().split("\\|");
            String[] eachRecord = split[0].split(" ");
            String[] numberRecord = split[1].split(" ");
            String[] codeNumber = new String[10];
            for(String i : eachRecord)
            {
                if(i.length() == 2)
                {
                    codeNumber[1] = i;
                }
                else if(i.length() == 4)
                {
                    codeNumber[4] = i;
                }
                else if(i.length() == 7)
                {
                    codeNumber[8] = i;
                }
                else if(i.length() == 3)
                {
                    codeNumber[7] = i;
                }
            }

            for(String i : eachRecord)
            {
                if(i.length() == 2 || i.length() == 4 || i.length() == 7 || i.length() == 3)
                {
                    continue;
                }
                if(i.length() == 5) // consider 5,2,3
                {
                    List<String> list = new ArrayList<String>(Arrays.asList(i.split("(?!^)")));
                    List<String> numberTmp = new ArrayList<String>(Arrays.asList(codeNumber[4].split("(?!^)")));
                    List<String> numberTmp2 = new ArrayList<String>(Arrays.asList(codeNumber[1].split("(?!^)")));
                    numberTmp.removeAll(numberTmp2);

                    if( list.containsAll(numberTmp) && codeNumber[5] == null)
                    {
                        codeNumber[5] = i;
                        continue;
                    }

                    numberTmp = new ArrayList<String>(Arrays.asList(codeNumber[8].split("(?!^)")));
                    numberTmp2 = new ArrayList<String>(Arrays.asList(codeNumber[4].split("(?!^)")));
                    numberTmp.removeAll(numberTmp2);

                    if( list.containsAll(numberTmp) && codeNumber[2] == null)
                    {
                        codeNumber[2] = i;
                        continue;
                    }
                    else
                    {
                        codeNumber[3] = i;
                    }

                }
                else    // consider 6,9,0
                {
                    List<String> list = new ArrayList<String>(Arrays.asList(i.split("(?!^)")));
                    List<String> numberTmp= new ArrayList<String>(Arrays.asList(codeNumber[7].split("(?!^)")));
                    List<String> numberTmp2 = new ArrayList<String>(Arrays.asList(codeNumber[4].split("(?!^)")));

                    if( list.containsAll(numberTmp2) && list.containsAll(numberTmp) && codeNumber[9] == null)
                    {
                        codeNumber[9] = i;
                        continue;
                    }

                    numberTmp = new ArrayList<String>(Arrays.asList(codeNumber[8].split("(?!^)")));
                    numberTmp2 = new ArrayList<String>(Arrays.asList(codeNumber[1].split("(?!^)")));
                    numberTmp.removeAll(numberTmp2);

                    if( list.containsAll(numberTmp) && codeNumber[6] == null)
                    {
                        codeNumber[6] = i;
                        continue;
                    }
                    else
                    {
                        codeNumber[0] = i;
                    }
                }
            }

            String result = "";
            for(String i : numberRecord)
            {
                List<String> list = new ArrayList<String>(Arrays.asList(i.split("(?!^)")));
                for(int j = 0; j < codeNumber.length; j++)
                {
                    List<String> codeNumberTmp = new ArrayList<String>(Arrays.asList(codeNumber[j].split("(?!^)")));
                    if(list.containsAll(codeNumberTmp) && codeNumberTmp.containsAll(list))
                    {
                        result += String.valueOf(j);
                    }
                }
            }
            resultInt += Integer.parseInt(result);
        }

        System.out.println(resultInt);

    }
}
