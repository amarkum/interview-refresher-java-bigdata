

# Java Programming Challenges

Here are a series of programming questions designed to test your problem-solving skills in Java. Each question is accompanied by a hint to guide you toward a solution.

## 1. Balanced Parentheses
**Question**:  
Write a program that checks whether a given string containing various types of parentheses `()`, `[]`, `{}` is balanced. A string is considered balanced if every opening parenthesis has a corresponding closing parenthesis in the correct order.

**Hint**:  
Use a stack to keep track of opening parentheses. When you encounter a closing parenthesis, check if it matches the type of the last opening parenthesis on the stack.

---

## 2. Character Count in a String
**Question**:  
Develop a program that counts the number of occurrences of each character in a given string and displays the counts.

**Hint**:  
Utilize a HashMap where the key is the character and the value is the count of its occurrences.

---

## 3. Find Pairs with Target Difference
**Question**:  
Given an array of integers and a target number, find all pairs of integers in the array whose difference equals the target number.

**Hint**:  
Sort the array to simplify finding pairs. Alternatively, use a HashSet to store elements and check if element ± target exists in the set.

---

## 4. Subarrays Summing to Zero
**Question**:  
Write a program to find all contiguous subarrays within a given array of integers that sum up to zero.

**Hint**:  
Use a HashMap to store the cumulative sum at each index. If the same cumulative sum appears more than once, the subarray between the indices sums to zero.

---

## 5. Minimum Number for Given Sum and Digits
**Question**:  
Given a target sum and a number of digits, find the smallest possible number with the given number of digits whose digits add up to the target sum.

**Hint**:  
Start filling the number from the most significant digit. Assign the smallest possible digit to each position while ensuring the total sum of the digits equals the target sum.

---

## 6. Sum of Non-Repetitive Numbers
**Question**:  
Calculate the sum of all non-repetitive (unique) numbers in a given array of integers.

**Hint**:  
Use a HashMap or HashSet to keep track of the frequency of each number. Sum only the numbers that appear exactly once.

---

## 7. Next Greatest Element
**Question**:  
For each element in an array of integers, find the next greatest element to its right. If there is no greater element, assign -1 to that position.

**Hint**:  
Traverse the array using a stack to keep track of indices whose next greater element hasn't been found yet.

---

## 8. Find Pairs with Given Sum
**Question**:  
Given an array of integers and a target sum, find all unique pairs of numbers that add up to the target sum.

**Hint**:  
Use a HashSet to store elements and check if the complement (target sum minus the current element) exists.

---

## 9. Check for Pangram
**Question**:  
Write a program to determine if a given string is a pangram. A pangram is a sentence that contains every letter of the alphabet at least once.

**Hint**:  
Use a boolean array or a HashSet to keep track of the letters present in the string.

---

## 10. Find Repeated Numbers
**Question**:  
Identify all numbers that are repeated in a given array of integers.

**Hint**:  
Use a HashMap to count the occurrences of each number and collect those with a count greater than one.

---

## 11. Second Largest Element
**Question**:  
Find the second largest element in an unsorted array of integers.

**Hint**:  
Iterate through the array while keeping track of the largest and second-largest elements.

---

## 12. Sorted Squares of Numbers
**Question**:  
Given a sorted array of integers (which may include negative numbers), create a new array containing the squares of each number, also sorted in ascending order.

**Hint**:  
Use two pointers starting from the ends of the array to compare squares and fill the new array from the highest index down.

---

## 13. Find Consecutive Number Sequences Summing to N
**Question**:  
Given a positive integer `N`, find all sequences of consecutive positive integers that sum up to `N`.

**Hint**:  
Use a sliding window approach with two pointers to find all such sequences.

---

## 14. Greatest Common Factor of a List
**Question**:  
Write a program to compute the Greatest Common Factor (GCF) of a list of positive integers.

**Hint**:  
Use the Euclidean algorithm iteratively on the list by finding the GCF of pairs of numbers.

---

## 15. Highest Version Number
**Question**:  
Given a list of software version numbers (e.g., "1.2.3", "1.2.10", "1.3.0"), determine the highest version number.

**Hint**:  
Split each version string by the dot delimiter and compare each segment numerically.

---

## 16. Merge Two Sorted Arrays
**Question**:  
Merge two sorted arrays of integers into a single sorted array without duplicates.

**Hint**:  
Use two pointers to traverse both arrays and compare elements, adding the smaller one to the new array and skipping duplicates.

---

## 17. Split Messages with Character Limit
**Question**:  
Given a long message and a maximum character limit per message (including a suffix like (1/3)), split the message into multiple parts without breaking words, ensuring each part is within the character limit.

**Hint**:  
While splitting, account for the length of the suffix. Use string manipulation to ensure words aren't split between messages.

---

## 18. Minimum Difference Permutation
**Question**:  
Given two arrays of equal length, permute one array so that the sum of absolute differences between corresponding elements of the two arrays is minimized.

**Hint**:  
Sort both arrays in ascending order and then calculate the sum of absolute differences.

---

## 19. First Non-Repeating Character
**Question**:  
Find the first non-repeating character in a given string.

**Hint**:  
Use a LinkedHashMap to preserve insertion order while counting character occurrences.

---

## 20. Element Repeated N Times
**Question**:  
An array of size `2N` contains `N+1` unique elements, where one element is repeated `N` times. Find the element that is repeated.

**Hint**:  
Use a HashMap or a HashSet to track element frequencies. The element with a count of `N` is your answer.

---

## 21. Word Count in Text
**Question**:  
Write a program that counts the number of occurrences of each word in a given text.

**Hint**:  
Normalize the text by converting it to lowercase and removing punctuation. Use a HashMap where keys are words and values are their counts.
