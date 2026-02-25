import java.io.*;
import java.util.*;

public class Solution {

    public static int palindromeIndex(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            // If characters mismatch, we must remove one
            if (s.charAt(i) != s.charAt(j)) {
                // Try removing char at index i
                if (isPalindrome(s, i + 1, j)) {
                    return i;
                }
                // Try removing char at index j
                if (isPalindrome(s, i, j - 1)) {
                    return j;
                }
                // If neither works, no single removal can fix it
                return -1;
            }
            i++;
            j--;
        }
        
        // Already a palindrome
        return -1;
    }

    // Helper method to check if a substring is a palindrome
    private static boolean isPalindrome(String s, int low, int high) {
        while (low < high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while (q-- > 0) {
            String s = scanner.next();
            System.out.println(palindromeIndex(s));
        }
        scanner.close();
    }
}
