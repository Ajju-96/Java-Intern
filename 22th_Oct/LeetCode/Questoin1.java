//414. Third Maximum Number
/*
You are given an integer array nums.

Return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.

Example 1:
        Input: nums = [3,2,1]
        Output: 1
        Explanation:
        The first distinct maximum is 3.
        The second distinct maximum is 2.
        The third distinct maximum is 1.
Example 2:
        Input: nums = [1,2]
        Output: 2
        Explanation:
        The first distinct maximum is 2.
        The second distinct maximum is 1.
        The third distinct maximum does not exist, so the maximum (2) is returned instead.
Example 3:
        Input: nums = [2,2,3,1]
        Output: 1
        Explanation:
        The first distinct maximum is 3.
        The second distinct maximum is 2 (both 2's are counted together since they have the same value).
        The third distinct maximum is 1.
*/

class Solution {
    public int thirdMax(int[] nums) {

        Integer largest = null;
        Integer secondLargest = null;
        Integer thirdLargest = null;

        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];

            // Ignore duplicate values
            if ((largest != null && num == largest) ||
                    (secondLargest != null && num == secondLargest) ||
                    (thirdLargest != null && num == thirdLargest)) {
                continue;
            }

            // Find the largest
            if (largest == null || num > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = num;
            }

            // Find the second largest
            else if (secondLargest == null || num > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = num;
            }

            // Find the third largest
            else if (thirdLargest == null || num > thirdLargest) {
                thirdLargest = num;
            }
        }

        // If the third distinct maximum doesn't exist,
        // return the overall maximum
        if (thirdLargest == null) {
            return largest;
        }

        return thirdLargest;
    }
}