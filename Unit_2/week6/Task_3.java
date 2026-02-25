import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {

    public static String twoStrings(String s1, String s2) {
        // Create a set to store unique characters of s1
        Set<Character> charsInS1 = new HashSet<>();
        
        // Add all characters of s1 to the set
        for (char c : s1.toCharArray()) {
            charsInS1.add(c);
        }
        
        // Check if any character in s2 exists in the set
        for (char c : s2.toCharArray()) {
            if (charsInS1.contains(c)) {
                return "YES";
            }
        }
        
        // No common characters found
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of test cases
        if (scanner.hasNextInt()) {
            int t = scanner.nextInt();
            while (t-- > 0) {
                String s1 = scanner.next();
                String s2 = scanner.next();
                System.out.println(twoStrings(s1, s2));
            }
        }
        scanner.close();
    }
}
