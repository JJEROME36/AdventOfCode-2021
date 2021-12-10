import java.awt.image.AreaAveragingScaleFilter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TaskOne
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
        int illegalPoints = 0;
        for(String line : data)
        {
            corruptedFound = false;
            Stack last = new Stack();
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

                        if(closeChunks.get(indexClose) == ')')
                        {
                            illegalPoints += 3;
                        }
                        else if(closeChunks.get(indexClose) == ']')
                        {
                            illegalPoints += 57;
                        }
                        else if(closeChunks.get(indexClose) == '}')
                        {
                            illegalPoints += 1197;
                        }
                        else if(closeChunks.get(indexClose) == '>')
                        {
                            illegalPoints += 25137;
                        }
                    }
                }
            }
        }
        System.out.println(illegalPoints);
    }
}
