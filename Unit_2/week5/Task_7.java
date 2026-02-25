import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        // Map to store the last seen index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 'left' is the start of the current sliding window
        for (int left = 0, right = 0; right < n; right++) {
            char currentChar = s.charAt(right);
            
            // If the character was seen before, move the left pointer
            if (map.containsKey(currentChar)) {
                // We move left to the position after the last occurrence, 
                // but only if that position is ahead of our current left pointer.
                left = Math.max(left, map.get(currentChar) + 1);
            }
            
            // Update the last seen index of the character
            map.put(currentChar, right);
            
            // Calculate the window size and update maxLength
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
