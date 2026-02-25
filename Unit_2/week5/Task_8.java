import java.util.*;

class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (matches(word, pattern)) {
                result.add(word);
            }
        }
        
        return result;
    }

    private boolean matches(String word, String pattern) {
        // Map pattern character to word character
        char[] pToW = new char[26];
        // Map word character to pattern character (to ensure bijection)
        char[] wToP = new char[26];

        for (int i = 0; i < word.length(); i++) {
            char p = pattern.charAt(i);
            char w = word.charAt(i);

            // If mapping doesn't exist yet, create it
            if (pToW[p - 'a'] == 0 && wToP[w - 'a'] == 0) {
                pToW[p - 'a'] = w;
                wToP[w - 'a'] = p;
            } 
            // If mapping exists, it must match the current characters
            else if (pToW[p - 'a'] != w || wToP[w - 'a'] != p) {
                return false;
            }
        }

        return true;
    }
}
