
# Find Smallest Letter Greater Than Target

[Problem Link](https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/)

You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.

Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.

Example 1:

Input: letters = ["c","f","j"], target = "a"\
Output: "c"\
Explanation: The smallest character that is lexicographically greater than 'a' in letters is 'c'.

Example 2:

Input: letters = ["c","f","j"], target = "c"\
Output: "f"\
Explanation: The smallest character that is lexicographically greater than 'c' in letters is 'f'.

Example 3:

Input: letters = ["x","x","y","y"], target = "z"\
Output: "x"\
Explanation: There are no characters in letters that is lexicographically greater than 'z' so we return letters[0].

Constraints:

- 2 <= letters.length <= 104
- letters[i] is a lowercase English letter.
- letters is sorted in non-decreasing order.
- letters contains at least two different characters.
- target is a lowercase English letter.

## Solution Approach

This is same as finding ceiling. We look for the next item that is just greater than the target.

```java
char nextGreatestLetter(char[] letters, char target) {
        int lowerBound = 0;
        int upperBound = letters.length - 1;
        if (target < letters[lowerBound] || target >= letters[upperBound]) {
            return letters[lowerBound];
        }
        while (lowerBound <= upperBound) {
            int mid = (upperBound + lowerBound) / 2;
            if (letters[mid] <= target) {
                lowerBound = mid + 1;
            } else if (letters[mid] > target) {
                upperBound = mid - 1;
            }
        }

        return letters[lowerBound];
    }
```

That's it.
