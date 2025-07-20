
import java.util.ArrayList;
import java.util.List;

public class TargetIndicesAfterSorting {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 5, 2, 3 };
        int target = 2;
        List<Integer> range = targetIndices(nums, target);
        System.out.println(range);
    }

    static List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> range = new ArrayList<>();
        int smallerElementCount = 0;
        int instancesOfTargetElement = 0;
        for (int i = 0; i < nums.length; i++) {
            // Checking how many elements are smaller than the target.
            if (nums[i] < target) {
                smallerElementCount++;
            }
            // Checking how many elements are equal to the target.
            if (nums[i] == target) {
                instancesOfTargetElement++;
            }
        }

        // Adding the target indices to the list the number of times it appear.
        for (int i = 0; i < instancesOfTargetElement; i++) {
            range.add(smallerElementCount);
            smallerElementCount++;
        }
        return range;
    }
}
