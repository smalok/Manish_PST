import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            String s = sc.next();
            int n = s.length();
            
            // Extract the two halves
            String left = s.substring(0, n / 2);
            String right = s.substring((n + 1) / 2); // Skips middle char if odd
            
            // Sort characters to compare content regardless of order
            char[] leftArr = left.toCharArray();
            char[] rightArr = right.toCharArray();
            Arrays.sort(leftArr);
            Arrays.sort(rightArr);
            
            if (Arrays.equals(leftArr, rightArr)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
