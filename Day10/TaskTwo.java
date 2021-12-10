import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskTwo
{
    public static void main(String[] args) {
        result();
    }

    private static void result() {
        File file = new File("data.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        ArrayList<String> data = new ArrayList<>();
        while (sc.hasNextLine())
        {
            data.add(sc.nextLine());
        }

        ArrayList<Character> openChunks = new ArrayList<Character>(Arrays.asList('(','[','{','<'));
        ArrayList<Character> closeChunks = new ArrayList<Character>(Arrays.asList(')',']','}','>'));
        boolean corruptedFound = false;
        long illegalPoints = 0;
        ArrayList<Long> results = new ArrayList<>();
        for(String line : data)
        {
            corruptedFound = false;
            Stack last = new Stack();
            illegalPoints = 0;
            for(int i = 0; i < line.length() && !corruptedFound; i++)
            {
                if(openChunks.contains(line.charAt(i)))
                {
                    last.add(line.charAt(i));
                }
                else
                {
                    int indexOpen = openChunks.indexOf(last.pop());
                    int indexClose = closeChunks.indexOf(line.charAt(i));
                    if(indexClose != indexOpen)
                    {
                        corruptedFound = true;
                    }
                }
            }
            if(!corruptedFound && !last.isEmpty())
            {
                int size = last.size();
                for(int i = 0; i < size; i++)
                {
                    int indexOpen = openChunks.indexOf(last.pop());
                    illegalPoints = 5*illegalPoints + indexOpen+1;
                }
                results.add(illegalPoints);
            }
        }
        Collections.sort(results);
        System.out.println(results.get(results.size()/2));
    }
}
