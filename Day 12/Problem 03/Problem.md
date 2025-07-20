
# Sort Colors

[Problem Link](https://leetcode.com/problems/sort-colors/description/)

Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.

Example 1:

Input: nums = [2,0,2,1,1,0]\
Output: [0,0,1,1,2,2]

Example 2:

Input: nums = [2,0,1]\
Output: [0,1,2]

Constraints:

n == nums.length\
1 <= n <= 300\
nums[i] is either 0, 1, or 2.

## Solution Approach

There are two approaches, one is counting sort and other is Dutch National Flag Algorithm.

### Approach 1 - Counting Sort

Since it is just 0, 1 & 2. We start by counting the number times they occur, and update the array accordingly.

In this approach we are replacing all the values with new values.

```java
void sortColors(int[] nums) {
    // Counting the number of zeros, ones and twos(nums.length - noOfZeros - noOfOnes).
    int noOfZeros = 0;
    int noOfOnes = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0)
            noOfZeros++;
        if (nums[i] == 1)
            noOfOnes++;
    }

    // Inserting based on the count.
    for (int i = 0; i < nums.length; i++) {
        // Array is 0 indexed so we start from zero to noOfZeros - 1 index.
        if (i < noOfZeros) {
            nums[i] = 0;
        }
        // Here we start from noOfZeros to (noOfZeros + noOfOnes) - 1 index.
        if (i >= noOfZeros && i < noOfZeros + noOfOnes) {
            nums[i] = 1;
        }
        // Also, here we start from (noOfZeros + noOfOnes) to nums.length - 1 index.
        if (i >= noOfZeros + noOfOnes && i < nums.length) {
            nums[i] = 2;
        }
    }
}
```

### Approach 2 - Dutch National Flag Algorithm (1-Pass Alorithm)

1-Pass means we can access the array only once.
