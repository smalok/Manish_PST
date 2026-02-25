import java.util.*;

class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        
        // Iterate through each word to see if it's a substring
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                // Don't compare a word with itself
                if (i == j) continue;
                
                // If words[i] is found inside words[j]
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    // Break the inner loop once a match is found 
                    // to avoid adding the same word multiple times
                    break;
                }
            }
        }
        
        return result;
    }
}
