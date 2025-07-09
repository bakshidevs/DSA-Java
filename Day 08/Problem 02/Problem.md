
# Reverse Integer

[Problem Link](https://leetcode.com/problems/reverse-integer/description/)

Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.

Assume the environment does not allow you to store 64-bit integers (signed or unsigned).

Example 1:

Input: x = 123\
Output: 321

Example 2:

Input: x = -123\
Output: -321

Example 3:

Input: x = 120\
Output: 21

Constraints:

-231 <= x <= 231 - 1

## Solution Approach

In this problem there three possible scenerios. The number is positive, negative or it is single digit number. If the number is single digit number we simply return it.

Case - 1 : The number is positive

We initialize a new int and assign it 0. Then we keep dividing the given integer by 10 (it will reduce the value by right shifting its digits) and add the last digit(by taking remainder) to the new number after multiplying it by 10 (Because multiplying it by 10 will shift the number by one digit towards left making the rightmost digit zero).

```pseudo
target = 123
newNum = 0
Step - 1
newNum = 0 * 10 + 123 % 10 = 0 + 3 = 3
target = 123/10 = 12

Step - 2
newNum = 3 * 10 + 12 % 10 = 30 + 2 = 32
target = 12/10 = 1

Step - 3
newNum = 32 * 10 + 1 % 10 = 320 + 1 = 321
target = 1/10 = 0

Loop terminates and we get the value.

```

Case - 2 : The numbe is negative

We do the same thing as the first case.

Special Case : When the reversed number / new number becomes greater and less that max int value

We simple return 0.

If the newNum is greater than Integer.MAX_VALUE / 10, we return 0. Because no matter what we put in the next digit it will be greater than Integer.MAX_VALUE.

```example
Case - 1
max = 2147483647
newNum = 214748365 (greater than max/10)
No matter what we put there it will be at least 2147483650, greater than 47, hence unusual behaviour.

Case - 2
max = 2147483647
newNum = 214748364 (equal to max/10)
Now if the last digit is greater than 7, newNum becomes greater than 2147483647, again unusual behaviour.
```

Same thing happen when dealing with negative integers. Hence a condition is applied, if it matches those condition 0 is returned.

Code

```java
 int reverseInteger(int x) {
        int newNum = 0;
        while (x != 0) {
            int currentDigit = x % 10;
            x = x / 10;
            
            if (newNum > Integer.MAX_VALUE / 10 || (newNum == Integer.MAX_VALUE / 10 && currentDigit > 7)) {
                return 0;
            }
            if (newNum < Integer.MIN_VALUE / 10 || (newNum == Integer.MIN_VALUE / 10 && currentDigit < -8)) {
                return 0;
            }
            newNum = newNum * 10 + currentDigit;
        }
        return newNum;
    }
```

That's it.
