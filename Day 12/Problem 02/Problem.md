
# Find Target Indices After Sorting Array

[Problem Link(https://leetcode.com/problems/find-target-indices-after-sorting-array/)]

You are given a 0-indexed integer array nums and a target element target.

A target index is an index i such that nums[i] == target.

Return a list of the target indices of nums after sorting nums in non-decreasing order. If there are no target indices, return an empty list. The returned list must be sorted in increasing order.

Example 1:

Input: nums = [1,2,5,2,3], target = 2\
Output: [1,2]\
Explanation: After sorting, nums is [1,2,2,3,5].\
The indices where nums[i] == 2 are 1 and 2.

Example 2:

Input: nums = [1,2,5,2,3], target = 3\
Output: [3]\
Explanation: After sorting, nums is [1,2,2,3,5].\
The index where nums[i] == 3 is 3.

Example 3:

Input: nums = [1,2,5,2,3], target = 5\
Output: [4]\
Explanation: After sorting, nums is [1,2,2,3,5].\
The index where nums[i] == 5 is 4.

Constraints:

1 <= nums.length <= 100\
1 <= nums[i], target <= 100

## Solution Approach

There are two ways we can approach. First we can sort the array then check the indices. In this case, time complexity will be at least `O(nlogn)`, in worst case it will be `O(n^2)`. In second case, we will check how many elements are smaller elements than the target and how many target appears in the array. If there are `k` number of smaller elements and target appears `m` times, then the stating index for target is `k` (since array is 0-Indexed) and the ending index is `k + m - 1`. In this case time complexity will be `O(n)`.

### First Approach

This is a brute force approach to solve the problem. It is very inefficient.

Time Complexity: `O(nlogn)` or `O(n^2)`\
Space Complexity: `O(1)`

```java
// Bubble sort to sort the array
void sort(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] > nums[j]) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}

// Function to find the target indices
List<Integer> targetIndices(int[] nums, int target) {
    List<Integer> range = new ArrayList<>();
    sort(nums);
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
            range.add(i);
        }
    }
    return range;
}
```

### Second Approach

This approach is better than the previous. Little bit more efficient.

Time Complexity: `O(n)`\
Space Complexity: `O(n)`

```java
List<Integer> targetIndices(int[] nums, int target) {
    List<Integer> range = new ArrayList<>();
    int smallerElementCount = 0;
    int instancesOfTargetElement = 0;
    for(int i = 0; i < nums.length; i++) {
        // Checking how many elements are smaller than the target.
        if(nums[i] < target) {
            smallerElementCount++;
        }
        // Checking how many elements are equal to the target.
        if(nums[i] == target) {
            instancesOfTargetElement++;
        }
    }

    // Adding the target indices to the list the number of times it appear.
    for(int i = 0; i < instancesOfTargetElement; i++) {
        range.add(smallerElementCount);
        smallerElementCount++;
    }
    return range;
}
```
