class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is longer than haystack, it can't be found
        if (needle.length() > haystack.length()) {
            return -1;
        }

        // We only need to iterate up to the point where the remaining 
        // characters in haystack are at least as long as the needle.
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            
            // Check if the substring starting at i matches needle
            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;
            }
        }

        return -1;
    }
}
