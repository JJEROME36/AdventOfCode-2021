import java.awt.image.AreaAveragingScaleFilter;
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
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
            System.exit(1);
        }

        int[][] data = new int[10][10];
        int columns = 0;
        int row = 0;
        while (sc.hasNextLine())
        {
            String line = sc.nextLine();
            row = 0;

            for(String number : line.split("(?!^)"))
            {
                data[row][columns] = Integer.parseInt(number);
                row++;
            }
            columns++;
        }


        int step = 100;
        int  flashed = 0;
        for(int i = 0; i < step; i++)
        {
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    data[x][y]++;
                }
            }

            boolean[][] alreadyIncrement = new boolean[10][10];
            while (noMoreFlashes(data,alreadyIncrement)) {
                for (int y = 0; y < 10; y++) {
                    for (int x = 0; x < 10; x++) {
                        if(data[x][y] > 9 && !alreadyIncrement[x][y])
                        {
                            alreadyIncrement[x][y] = true;
                            if(y - 1 < 0 )
                            {
                                if (x - 1 < 0)
                                {
                                    data[x+1][y]++;
                                    data[x+1][y+1]++;
                                    data[x][y+1]++;
                                }
                                else if (x + 1 >= 10)
                                {
                                    data[x-1][y]++;
                                    data[x][y+1]++;
                                    data[x-1][y+1]++;
                                }
                                else
                                {
                                    data[x][y+1]++;
                                    data[x-1][y]++;
                                    data[x+1][y]++;
                                    data[x-1][y+1]++;
                                    data[x+1][y+1]++;
                                }
                            }
                            else if(y + 1  >= 10)
                            {
                                if (x - 1 < 0)
                                {
                                    data[x+1][y-1]++;
                                    data[x+1][y]++;
                                    data[x][y-1]++;
                                }
                                else if (x + 1 >= 10)
                                {
                                    data[x-1][y-1]++;
                                    data[x-1][y]++;
                                    data[x][y-1]++;
                                }
                                else
                                {
                                    data[x][y-1]++;
                                    data[x-1][y]++;
                                    data[x+1][y]++;
                                    data[x-1][y-1]++;
                                    data[x+1][y-1]++;
                                }
                            }
                            else
                            {
                                if (x - 1 < 0)
                                {
                                    data[x+1][y]++;
                                    data[x+1][y+1]++;
                                    data[x][y+1]++;
                                    data[x][y-1]++;
                                    data[x+1][y-1]++;
                                }
                                else if (x + 1 >= 10)
                                {
                                    data[x-1][y]++;
                                    data[x-1][y+1]++;
                                    data[x][y+1]++;
                                    data[x][y-1]++;
                                    data[x-1][y-1]++;
                                }
                                else
                                {
                                    data[x-1][y]++;
                                    data[x+1][y]++;
                                    data[x][y-1]++;
                                    data[x-1][y-1]++;
                                    data[x+1][y-1]++;
                                    data[x][y+1]++;
                                    data[x-1][y+1]++;
                                    data[x+1][y+1]++;
                                }

                            }
                        }
                    }
                }
            }
            for (int y = 0; y < 10; y++) {
                for (int x = 0; x < 10; x++) {
                    if (data[x][y] > 9) {
                        data[x][y] = 0;
                        flashed++;
                    }
                }
            }
        }

        System.out.println(flashed);
    }

    static boolean noMoreFlashes(int[][] data, boolean[][] alreadyIncrement)
    {
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                if(data[i][j] > 9 && !alreadyIncrement[i][j])
                {
                    return true;
                }
            }
        }
        return false;
    }
}
