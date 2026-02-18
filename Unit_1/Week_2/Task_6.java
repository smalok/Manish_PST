public class Task_6{
    public int allDigitsCountEfficient(int input1) {
        // Convert to string and get the length.
        // Handles negative signs correctly if you remove them first.
        String numberString = String.valueOf(input1);
        if (input1 < 0) {
            return numberString.length() - 1; // Exclude the '-' sign
        }
        return numberString.length();
    }
}
