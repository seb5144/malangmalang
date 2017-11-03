import static java.lang.System.out;
import static java.util.Arrays.*;

import java.util.Scanner;

public class NineDwarfsSimple
{
    public static final int NUM_DWARFS = 9;
    public static final int TOTAL_WEIGHT = 100;
    private static final int NUM_REAL_DWARFS = 7;

    private static int[] findSevenDwarfs(int[] heights)
    {
        int sumOfFakes = sum(heights) - TOTAL_WEIGHT;

        sort(heights);

        int i=0, j=heights.length-1;
        while(i < j)
        {
            int comp = heights[i] + heights[j] - sumOfFakes;

            if(comp == 0)
                return removeFakes(heights, heights[i], heights[j]);
            else if(comp < 0)
                i++;
            else
                j--;
        }

        return new int[0];
    }

    private static int[] removeFakes(int[] heights, int heightOfSuspectA, int heightOfSuspectB)
    {
        int[] result = new int[NUM_REAL_DWARFS];
        int i = 0;

        for(int height: heights)
            if(height != heightOfSuspectA && height != heightOfSuspectB)
                result[i++] = height;

        return result;
    }

    private static int sum(int[] heights)
    {
        int sum = 0;
        for(int h: heights) sum += h;
        return sum;
    }

    public static void main(String[] args)
    {
        printHeights(findSevenDwarfs(readInput()));
    }

    private static int[] readInput()
    {
        try (Scanner scanner = new Scanner(System.in))
        {
            int[] heights = new int[NUM_DWARFS];
            for(int i = 0; i < NUM_DWARFS; i++)
                heights[i] = scanner.nextInt();

            return heights;
        }
    }

    private static void printHeights(int[] heights)
    {
        for(int height: heights) out.println(height);
    }
}
