import java.util.Scanner;

public class StringSimilarity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int t = sc.nextInt();
            while (t-- > 0) {
                String s = sc.next();
                System.out.println(calculateSimilaritySum(s));
            }
        }
        sc.close();
    }

    public static long calculateSimilaritySum(String s) {
        int n = s.length();
        int[] z = new int[n];
        long sum = n; // The similarity of the string with itself (prefix at index 0)

        // Z-algorithm variables for the [L, R] window
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                // Try to use previously computed values
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            // Manually match characters to extend the Z-box
            while (i + z[i] < n && s.charAt(z[i]) == s.charAt(i + z[i])) {
                z[i]++;
            }
            // Update the window [L, R] if we found a match further to the right
            if (i + z[i] - 1 > r) {
                l = i;
                r = i + z[i] - 1;
            }
            sum += z[i];
        }
        return sum;
    }
}
