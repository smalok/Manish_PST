import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */
    public static int diagonalDifference(List<List<Integer>> arr) {
        int primarySum = 0;
        int secondarySum = 0;
        int n = arr.size();

        for (int i = 0; i < n; i++) {
            // Primary diagonal: row index == column index
            primarySum += arr.get(i).get(i);
            
            // Secondary diagonal: row index + column index == n - 1
            secondarySum += arr.get(i).get(n - 1 - i);
        }

        // Return the absolute difference
        return Math.abs(primarySum - secondarySum);
    }

}

public class Task_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        // Handle local testing or environment variable for output
        String outputPath = System.getenv("OUTPUT_PATH");
        BufferedWriter bufferedWriter;
        if (outputPath != null) {
            bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        } else {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
