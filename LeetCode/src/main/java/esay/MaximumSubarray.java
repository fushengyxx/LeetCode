package esay;

/**
 * Created by yixinxin on 17/3/12.
 *
 * 53. Maximum Subarray
 *
 Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

 For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 the contiguous subarray [4,-1,2,1] has the largest sum = 6.

 If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 */
public class MaximumSubarray {
    /*
        17ms
        use dp
        maxSubArray(int A[], int i) means the maxSubArray for A[0:i], A[i] is the last element

        maxSubArray(A, i) =
        maxSubArray(A, i - 1) > 0 ? maxSubArray(A, i - 1) : 0 + A[i]

        O(n) time, O(n) space
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // dp: the maximum subarray ending with A[i]
        int[] dp = new int[n];
        dp[0] = nums[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    /*
       simplified dp
       O(n) time, O(1) space
     */
    public int maxSubArray1(int[] A) {
        int res = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = Math.max(sum, 0) + A[i];
            res = Math.max(res, sum);
        }
        return res;
    }

    // no dp
    // 17ms
    public int maxSubArray2(int[] nums){
        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0)
                sum = nums[i];
            else
                sum += nums[i];
            if (sum > max)
                max = sum;
        }
        return max;
    }

    // Basically, keep adding each integer to the sequence until the sum drops below 0.
    // If sum is negative, then should reset the sequence.
    // 18ms
    public int maxSubArray3(int[] nums){
        int n = nums.length;
        int max = nums[0];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            max = Math.max(sum, max);
            sum = Math.max(sum, 0);
        }
        return max;
    }

    // divide and conquer
    /*
        Step1. Select the middle element of the array.
        So the maximum subarray may contain that middle element or not.

        Step 2.1 If the maximum subarray does not contain the middle element, then we can apply the same algorithm to the the subarray to the left of the middle element and the subarray to the right of the middle element.

        Step 2.2 If the maximum subarray does contain the middle element, then the result will be simply the maximum suffix subarray of the left subarray plus the maximum prefix subarray of the right subarray

        Step 3 return the maximum of those three answer.
     */
    public int maxSubArray4(int[] A){
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = A.length;
        if(n==0) return 0;
        return maxSubArrayHelperFunction(A,0,n-1);
    }

    public int maxSubArrayHelperFunction(int A[], int left, int right) {
        if(right == left) return A[left];
        int middle = (left+right)/2;
        int leftans = maxSubArrayHelperFunction(A, left, middle);
        int rightans = maxSubArrayHelperFunction(A, middle+1, right);
        int leftmax = A[middle];
        int rightmax = A[middle+1];
        int temp = 0;
        for(int i=middle;i>=left;i--) {
            temp += A[i];
            if(temp > leftmax) leftmax = temp;
        }
        temp = 0;
        for(int i=middle+1;i<=right;i++) {
            temp += A[i];
            if(temp > rightmax) rightmax = temp;
        }
        return Math.max(Math.max(leftans, rightans),leftmax+rightmax);
    }

    public static void main(String[] args){
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] A = {-4,-5,-2,-1};
        int[] B = {1};
        System.out.println(maximumSubarray.maxSubArray3(nums));
    }
}
