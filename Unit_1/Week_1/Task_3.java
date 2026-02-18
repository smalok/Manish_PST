import java.util.Arrays;

public class Task_3{
    public static void main(String[] args) {
        int[] numbers = {10, 20, 30, 40, 50}; // Array must be sorted
        int target = 40;

        // One-line search command
        int index = Arrays.binarySearch(numbers, target);

        if (index >= 0) {
            System.out.println("Found " + target + " at index: " + index);
        } else {
            System.out.println("Element not found.");
        }
    }
}