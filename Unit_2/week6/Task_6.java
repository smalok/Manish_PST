import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // Frequency arrays for 'a'-'z'
        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill the frequency for string p and the first window of s
        for (int i = 0; i < p.length(); i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Check if the first window is an anagram
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Start sliding the window
        int left = 0;
        for (int right = p.length(); right < s.length(); right++) {
            // Add the new character to the window
            sCount[s.charAt(right) - 'a']++;
            // Remove the character that is no longer in the window
            sCount[s.charAt(left) - 'a']--;
            
            left++; // Move the window start

            // Compare the frequency arrays
            if (Arrays.equals(pCount, sCount)) {
                result.add(left);
            }
        }

        return result;
    }
}
