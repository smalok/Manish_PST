public class Task_6{
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4};
        int n = numbers.length;

        System.out.println("All possible pairs:");

        // Outer loop picks the first element of the pair
        for (int i = 0; i < n; i++) {
            
            // Inner loop picks the second element of the pair
            for (int j = 0; j < n; j++) {
                System.out.print("(" + numbers[i] + ", " + numbers[j] + ") ");
            }
            
            System.out.println(); // Move to next line for better readability
        }
    }
}