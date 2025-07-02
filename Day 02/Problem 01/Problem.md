
# Plus One

[Link](https://leetcode.com/problems/plus-one/)


You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.

Increment the large integer by one and return the resulting array of digits.

 

Example 1:

Input: digits = [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Incrementing by one gives 123 + 1 = 124.
Thus, the result should be [1,2,4].
Example 2:

Input: digits = [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
Incrementing by one gives 4321 + 1 = 4322.
Thus, the result should be [4,3,2,2].
Example 3:

Input: digits = [9]
Output: [1,0]
Explanation: The array represents the integer 9.
Incrementing by one gives 9 + 1 = 10.
Thus, the result should be [1,0].
 

Constraints:

    1 <= digits.length <= 100
    0 <= digits[i] <= 9
    digits does not contain any leading 0's.

## Solution approach

There is four possible scenerio

1. Most simple one. Last digit is less than 9, so we just increment the last digit of the array and return it.
2. Most tricky situation. All digits are 9. In this case, the sum will have one extra digit, therefore the array to be returned will have length one more than the digits. So we can check if the sum of all digits is equal to the digits.length * 9. We can then create a newArray, fill it with 0s except the most significat digit which will be 1 and return it.
    ```
    digits = [9, 9, 9];
    sum = 9 + 9 + 9 = 27;
    digits.length (3) * 9 = 27;
    sum + 1 = 1000;
    o/p = [1, 0, 0, 0];
    ```
3. Third scenerio, last digit is 9. Then we update the last the digit before.
4. Fourth and last scenerio, there are multiple 9 (continuous flow) in the digits. So we, put zero in the place of nine and increment the digit before. Then we break the loop. Because third scenerio gets covered in this, we don't need to implement that individually.
   ```
    Case - 1
    i/p = [1, 9, 1, 9];
    o/p = [1, 9, 2, 0];
    Case - 2
    i/p = [1, 9, 9, 9];
    o/p = [2, 0, 0, 0];
    Case - 3
    i/p = [1, 8, 9, 9];
    o/p = [1, 9, 0, 0];
    And so on...
    ```
    A little caveat in the solution, while going through the we are increasing the previous value too, but if the previous value is 8 and gets incremented to 9 then it will return false answer. This is a simple bug in the solution so we can add a little condition to check whether the previous digit is 8 (before incrementing) or 9 a(after incrementing). If the condition is met we can break the loop there.