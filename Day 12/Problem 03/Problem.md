
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

There are different approaches, one is counting sort, other is Dutch National Flag Algorithm and we can also use some sorting algorithms like bubble sort with time complexity of `O(n^2)` or merge sort with time complexity of `O(nlogn)`.

Here we will see first two approaches.

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

1-Pass means we can access the array only once. In DNF Algorithm (Dutch National Flag Algorithm) array is divided into four parts with three pointers, low, mid and high. From index 0 to low - 1 all elements are 0s, from low to mid - 1 all elements are 1s and from mid to high - 1 all elements unsorted and from high to nums.length - 1 all elements are 2s.

Let's assume we have an array `nums=[2,0,2,1,1,0]`. Since this is unsorted it fall in the middle (from mid to high - 1). We sort this by swapping the array elements. If the element is 0, we swap at the starting index of 1, which is low. If the element is 2, we swap at the start of 2s, which is high.

Algorithm:

1. Initialize low = 0, mid = 0, high = nums.length - 1.
2. Run a loop till mid <= high. (Because when mid > high, we are done and sorting space become zero. There are no elements left to sort.)
3. If nums[mid] is 0, swap it with nums[low] and increment both low and mid. (Because we are swapping, end index of zero and start index of unsorted changing.)
4. If nums[mid] is 1, increment mid. (We don't need to swap here, because once the array is sorted the 1s are supposed in the middle).
5. If nums[mid] is 2, swap it with nums[high] and decrement high. (Because we are moving from the end to middle, we need high to be decreasing. To both the pointer meet, start have to move forward and end has to move backward.)

```java
void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
}
void dutchNationalFlagAlgorithm(int[] arr) {
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;

        while (mid <= high) {
                // 
                if (arr[mid] == 0) {
                        swap(arr, low, mid);
                        low++;
                        mid++;
                } else if (arr[mid] == 1) {
                        mid++;
                } else {
                        swap(arr, mid, high);
                        high--;
                }
        }
}
```

That's it. That's the Dutch National Flag Algorithm.
