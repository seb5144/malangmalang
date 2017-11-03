import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;

class Helloworld {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println("sum: " + sum);

        // 20,7,23,19,10,8,13,15,25
        Arrays.sort(arr);
        // 7,8,10,13,15,19,20,23,25
        int start = 0, end = 8;

        while (arr[start] + arr[end] != sum - 100) {
              if (arr[start] + arr[end] > sum - 100)
                  end--;
              else
                  start++;
        }

        int result = sum - (arr[start] + arr[end]); // always 100
        System.out.println("result: " + result);
    }
}
