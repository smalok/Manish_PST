import java.util.Arrays;

public class Task_5{
    public static void main(String[] args) {
        int[] numbers = {12, 3, 5, 7, 19};
        int k = 2; // We want to find the 2nd smallest element

        // 1. Sort the array (becomes: 3, 5, 7, 12, 19)
        Arrays.sort(numbers);

        // 2. Access the element at index k-1
        int result = numbers[k - 1];

        System.out.println("The " + k + "th smallest element is: " + result);
    }
}