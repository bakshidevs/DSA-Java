
# Two Sum II - Input Array Is Sorted

[Problem Link](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.

Example 1:

Input: numbers = [2,7,11,15], target = 9\
Output: [1,2]\
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:

Input: numbers = [2,3,4], target = 6\
Output: [1,3]\
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:

Input: numbers = [-1,0], target = -1\
Output: [1,2]\
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:

2 <= numbers.length <= 3 * 104
-1000 <= numbers[i] <= 1000
numbers is sorted in non-decreasing order.
-1000 <= target <= 1000
The tests are generated such that there is exactly one solution.

## Solution Approach

We can try the Brute force Method which is usually applicable for unsorted array and try the two pointer approach.

### Brute Force Approach

Take each element from the array and find the other element (subtract the first element from target) in the array.

Time Complexity: O(n^2)\
Space Complexity: O(1)

```java
int[] twoSum(int[] nums, int target) {
    int[] range = {-1, -1};
    for(int i = 0; i < nums.length; i++) {
        // Since ith element has already been checked we don't need to check it again starting from 0. That's why j = i + 1.
        for(int j = i + 1; j < nums.length; j++) {
            // Here we are checking for each value of i which number is the required number to get the target.
            if(nums[i] + nums[j] == target) {
                // once the number is found we return the indices. Since it is 1-indexed array we return i + 1 and j + 1. For usual cases we simply return i and j.
                range[0] = i + 1;
                range[1] = j + 1;
                return range;
            }
        }
    }
    // It is stated that the array will always contain such pair that adds up to the target, so we can break the loop when both the elements are found and return the range directly outside the loop. But this is more generalized solution. Where we are uncertain whether the input array has such pair or not.
    return new int[]{-1, -1};
}
```

This is the brute force method.

### Two Pointer Approach (Only for Sorted Arrays)

This can be applied in two situations where the array is sorted or we choose to sort the unsorted array. We will assume only the first instance, since the problem states that the array is sorted.

In this method, we pick the first and last element of the array and add them. If the the sum is equal we simply return the indices after adding 1 to both. If the sum is less we increment start index by 1 and if the sum is greater we decrement the end index by 1.

Time Complexity: O(n)\
Space Complexity: O(1)

```java
int[] twoSum(int[] numbers, int target) {
    int start = 0;
    int end = numbers.length - 1;
    int[] range = {0, 0};
    while(start < end) {
        int sum = numbers[start] + numbers[end];
        if(sum == target) {
            range[0] = start + 1;
            range[1] = end + 1;
            // If we don't break the loop here it will go on forever checking the same start and end index.
            break;
        } else if (sum < target) {
            // If the sum is less we increment the start index by 1. Because the array is sorted in a non-decreasing order to get the next bigger element we need to check the next element. 
            start++;
        } else {
            // If the sum is greater we decrement the end index by 1. Because we need smaller element, so we need to check the previous element.
            end--;
        }
    }
    return range;
}
```

This is the two pointer approach.
