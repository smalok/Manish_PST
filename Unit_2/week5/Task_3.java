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
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        // 1. Max Subarray Sum (Kadane's Algorithm)
        int maxSubarraySum = arr.get(0);
        int currentSubarraySum = arr.get(0);

        // 2. Max Subsequence Sum
        int maxSubsequenceSum = 0;
        int maxElement = arr.get(0);
        boolean hasPositive = false;

        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            
            // Logic for Subarray (Kadane's) - start from index 1 for comparison
            if (i > 0) {
                currentSubarraySum = Math.max(num, currentSubarraySum + num);
                maxSubarraySum = Math.max(maxSubarraySum, currentSubarraySum);
            }

            // Logic for Subsequence
            if (num > 0) {
                maxSubsequenceSum += num;
                hasPositive = true;
            }
            
            // Keep track of the largest element in case all are negative
            if (num > maxElement) {
                maxElement = num;
            }
        }

        // If no positive numbers were found, the max subsequence is the largest element
        if (!hasPositive) {
            maxSubsequenceSum = maxElement;
        }

        List<Integer> result = new ArrayList<>();
        result.add(maxSubarraySum);
        result.add(maxSubsequenceSum);
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        
        // Setup output path for HackerRank or local console
        String outputPath = System.getenv("OUTPUT_PATH");
        BufferedWriter bufferedWriter;
        if (outputPath != null) {
            bufferedWriter = new BufferedWriter(new FileWriter(outputPath));
        } else {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

                bufferedWriter.write(
                    result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                    + "\n"
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
