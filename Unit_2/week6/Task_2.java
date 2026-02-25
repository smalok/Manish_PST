class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        // i represents the length of the potential repeating substring
        for (int i = 1; i <= n / 2; i++) {
            // Only check if the total length is divisible by the prefix length
            if (n % i == 0) {
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                
                // Append the substring (n/i) times
                for (int j = 0; j < n / i; j++) {
                    sb.append(substring);
                }
                
                if (sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
