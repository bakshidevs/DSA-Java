
# Search in Rotated Sorted Array

[Problem Link](https://leetcode.com/problems/search-in-rotated-sorted-array/)

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0\
Output: 4

Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3\
Output: -1

Example 3:

Input: nums = [1], target = 0\
Output: -1

Constraints:

1 <= nums.length <= 5000\
-104 <= nums[i] <= 104\
All values of nums are unique.\
nums is an ascending array that is possibly rotated.\
-104 <= target <= 104

## Solution Approach

As usual it has at least two solutions. One is brute force or linear, checking indidually and sending the index back, in this case time complexity is `O(n)` and space complexity is `O(1)`. And the other is modified binary search, in this approach time complexity is `O(log n)` and space complexity is `O(1)`.

### Brute Force : Linear Search

Checking each individial items whether it matches the target then returning the index matched index.

```java
int search(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) {
            return i;
        }
    }
    return -1;
}
```

This is the simplest solution possible.

### Modified Binary Search

In Binary Search the given array is sorted which means the elements in the array will either be in ascending order or in descending order. But, when it is rotated, the elements are sorted but with a twist. After certain index the last elements come first, depending on the number of rotation.

```pseudo
nums = [1, 2, 3, 4, 5, 6, 7, 8, 9]

After one rotation
nums = [2, 3, 4, 5, 6, 7, 8, 9, 1]

After two rotation
nums = [3, 4, 5, 6, 7, 8, 9, 1, 2]

After three rotation
nums = [4, 5, 6, 7, 8, 9, 1, 2, 3]

After four rotation
nums = [5, 6, 7, 8, 9, 1, 2, 3, 4]

After five rotation
nums = [6, 7, 8, 9, 1, 2, 3, 4, 5]

And so on...
```

Now that the idea of rotated sorted array is clear let's move on to Modified Binary Search. Now if we look at the rotated array we can see when the array is divided into two equal halves one half is sorted and the other is unsorted. In this binary search we will as usual check for the middle element, if it matches we will return the index. If middle element is greater than the target and also greater than first element, this means the left half of the array is sorted and the right half is unsorted. So we will check for the target in left half. If it does not exist, then it will be in the right half and vice versa.

#### Algorithm

Step - 1 : Check Middle, if it matches return index.\
Step - 2 : Check which part is sorted, if left we check in the left first, if right we check in the right first. If the target is in sorted half we return the index.\
Step - 3 : If the target is not in the sorted half we discard that half and repeat the same process for the other half.

Repeating this, we will find the element and return the index.

```java
int searchInRotatedArray(int[] nums, int target) {
    int lowerBound = 0;
    int upperBound = nums.length - 1;
    while (lowerBound <= upperBound) {
        int mid = lowerBound + (upperBound - lowerBound) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        // Checking if the left half is sorted or not
        if (nums[lowerBound] <= nums[mid]) {
            // Checking if the target is in the left half or not
            if (target >= nums[lowerBound] && target < nums[mid]) {
                upperBound = mid - 1;
            } else {
                // If the target is not in left half then it is in right half, lower bound is therefore updated
                lowerBound = mid + 1;
            }
        } else {
            // Checking whether the target is in the right half or not
            if (target >= nums[mid] && target <= nums[upperBound]) {
                lowerBound = mid + 1;
            } else {
                // If the target is not in right half then it is in left half, upper bound is therefore updated
                upperBound = mid - 1;
            }
        }
    }
    // In the end, if the element if not found, it is concluded that the element is not present in the array. There we return -1.
    return -1;
}
```
