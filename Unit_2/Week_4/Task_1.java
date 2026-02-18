class Task_1 {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int mid = s.length() / 2;
        int count = 0;

        for (int i = 0; i < mid; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) count++;
            if (vowels.indexOf(s.charAt(i + mid)) != -1) count--;
        }

        return count == 0;
    }
}
