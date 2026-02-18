import java.util.HashSet;

class Task_4 {
    public boolean containsDuplicate(int[] nums) {
        // Create a Set to store unique numbers
        HashSet<Integer> seen = new HashSet<>();
        
        for (int num : nums) {
            // If the number is already in the set, we found a duplicate
            if (seen.contains(num)) {
                return true;
            }
            // Otherwise, add the number to the set
            seen.add(num);
        }
        
        // No duplicates found after checking all elements
        return false;
    }
}
