public class Task_4{
    public static void main(String[] args) {
        int[] numbers = {12, 45, 7, 92, 31, 5};
        
        // Assume the first element is the maximum
        int max = numbers[0];

        // Loop through the array starting from the second element
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i]; // Update max if a larger value is found
            }
        }

        System.out.println("The maximum element is: " + max);
    }
}