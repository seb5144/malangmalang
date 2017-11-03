package com.woowahan;

import static java.lang.System.out;
import static java.util.Arrays.*;

import java.util.Scanner;

public class NineDwarfs
{
    public static final int NUM_DWARFS = 9;
    public static final int TOTAL_WEIGHT = 100;

    private static int[] findSevenDwarfs(int[] heights)
    {
        int[] sorted = copyOf(heights, heights.length);
        sort(sorted);

        int sum = stream(heights).sum();
        int sumOfFakes = sum - TOTAL_WEIGHT;

        for(int weightOfSuspectA: sorted)
        {
            int weightOfSuspectB = sumOfFakes - weightOfSuspectA;

            if(binarySearch(sorted, weightOfSuspectB) >= 0)
                return stream(sorted).filter(w -> w != weightOfSuspectA && w != weightOfSuspectB).toArray();
        }
        return new int[0];
    }

    public static void main(String[] args)
    {
        int[] heights = readInput();
        printResult(findSevenDwarfs(heights));
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

    private static void printResult(int[] sevenDwarfs)
    {
        stream(sevenDwarfs).forEach(out::println);
    }
}
