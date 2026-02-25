import java.io.*;
import java.util.*;

public class Solution {

    public static int marsExploration(String s) {
        int changes = 0;
        String pattern = "SOS";
        
        for (int i = 0; i < s.length(); i++) {
            // Check the character at index i against the pattern SOS
            // i % 3 gives us 0, 1, or 2 repeatedly
            if (s.charAt(i) != pattern.charAt(i % 3)) {
                changes++;
            }
        }
        
        return changes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        
        int result = marsExploration(s);
        System.out.println(result);
        
        scanner.close();
    }
}
