import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    public static void matrixRotation(List<List<Integer>> matrix, int r) {
        int m = matrix.size();
        int n = matrix.get(0).size();
        int numLayers = Math.min(m, n) / 2;

        // Create a 2D array for easier indexing during reconstruction
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = matrix.get(i).get(j);
            }
        }

        for (int layer = 0; layer < numLayers; layer++) {
            List<Integer> flatLayer = new ArrayList<>();
            
            // Define boundaries for current layer
            int top = layer, bottom = m - 1 - layer;
            int left = layer, right = n - 1 - layer;

            // 1. Extract layer elements into a 1D list
            for (int i = left; i <= right; i++) flatLayer.add(res[top][i]); // Top row
            for (int i = top + 1; i <= bottom; i++) flatLayer.add(res[i][right]); // Right col
            for (int i = right - 1; i >= left; i--) flatLayer.add(res[bottom][i]); // Bottom row
            for (int i = bottom - 1; i > top; i--) flatLayer.add(res[i][left]); // Left col

            // 2. Rotate the 1D list
            int size = flatLayer.size();
            int rotation = r % size;
            List<Integer> rotatedLayer = new ArrayList<>(Collections.nCopies(size, 0));
            for (int i = 0; i < size; i++) {
                // Counter-clockwise rotation: (i + rotation) % size
                rotatedLayer.set(i, flatLayer.get((i + rotation) % size));
            }

            // 3. Put rotated elements back into the matrix
            int count = 0;
            for (int i = left; i <= right; i++) res[top][i] = rotatedLayer.get(count++);
            for (int i = top + 1; i <= bottom; i++) res[i][right] = rotatedLayer.get(count++);
            for (int i = right - 1; i >= left; i--) res[bottom][i] = rotatedLayer.get(count++);
            for (int i = bottom - 1; i > top; i--) res[i][left] = rotatedLayer.get(count++);
        }

        // Output the result
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(res[i][j]).append(j == n - 1 ? "" : " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}

public class Task_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
        int m = Integer.parseInt(firstMultipleInput[0]);
        int n = Integer.parseInt(firstMultipleInput[1]);
        int r = Integer.parseInt(firstMultipleInput[2]);

        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            matrix.add(
                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList())
            );
        }

        Result.matrixRotation(matrix, r);
        bufferedReader.close();
    }
}
