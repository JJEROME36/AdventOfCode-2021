import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class TaskTwo
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        ArrayList<String> data = new ArrayList<String>();

        while (sc.hasNextLine()) {
            data.add(sc.next());
        }

        data.removeIf(value -> value.equals("->"));
        ArrayList<Integer> numberData = new ArrayList<Integer>();
        for (int i = 0; i < data.size(); i = i + 2)
        {
            String[] line1 = data.get(i).split(",");
            int[] point1 = {Integer.parseInt(line1[0]), Integer.parseInt(line1[1])};
            String[] line2 = data.get(i + 1).split(",");
            int[] point2 = {Integer.parseInt(line2[0]), Integer.parseInt(line2[1])};

            numberData.add(point1[0]);
            numberData.add(point1[1]);
            numberData.add(point2[0]);
            numberData.add(point2[1]);
        }

        int max = Collections.max(numberData) + 1;
        int[][] board = new int[max][max];

        for (int i = 0; i < numberData.size(); i = i + 4)
        {
            int x1 =numberData.get(i);
            int y1 = numberData.get(i+1);

            int x2 = numberData.get(i+2);
            int y2 = numberData.get(i+3);
            if(x1 == x2)
            {
                int smaller =  (y1 <= y2) ? y1 : y2;
                int bigger =  (y1 >= y2) ? y1 : y2;
                for (int z = smaller; z <= bigger; z++ )
                {
                    board[x1][z]++;
                }
            }
            else if(y1 == y2)
            {
                int smaller =  (x1 <= x2) ? x1 : x2;
                int bigger =  (x1 >= x2) ? x1 : x2;
                for (int z = smaller; z <= bigger; z++ )
                {
                    board[z][y1]++;
                }
            }
            else
            {
                int leftX =  (x1 <= x2) ? x1 : x2;
                int leftY =  (x1 <= x2) ? y1 : y2;

                int rightX =  (x1 >= x2) ? x1 : x2;
                int rightY =  (x1 >= x2) ? y1 : y2;

                int z = 0;
                int X = leftX;
                int Y = leftY;
                while(X != rightX && Y != rightY)
                {
                    if (rightY < leftY)
                    {
                        X++;
                        Y--;
                        board[leftX+z][leftY-z]++;
                    }
                    else
                    {
                        X++;
                        Y++;
                        board[leftX+z][leftY+z]++;
                    }
                    z++;
                }
                board[rightX][rightY]++;
            }
        }

        int result = 0;
        for(int i = 0; i < max; i++)
        {
            for(int j = 0; j < max; j++)
            {
                if(board[i][j] >= 2)
                {
                    result++;
                }

            }
        }
        System.out.println(result);
    }
}
