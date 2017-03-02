package hard;

/**
 * Created by yixinxin on 17/2/26.
 * <p>
 * Median 中位数。对于有限的数集，可以通过把所有观察值高低排序后找出正中间的一个作为中位数。如果观察值有偶数个，通常取最中间的两个数值的平均数作为中位数。
 * Mean   平均数
 * <p>
 * <p>
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays
 * . The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArray {
    public double findMedian(int[] nums){
        if(nums.length == 0 || nums == null) {
            return 0;
        }else{
            if(nums.length % 2 == 0){
                return (nums[nums.length/2] + nums[nums.length/2 -1]) / 2.0;
            }else{
                return nums[nums.length/2];
            }
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0 && nums2.length == 0)
            return 0;

        if(nums1.length == 0)
            return this.findMedian(nums2);
        if(nums2.length == 0)
            return this.findMedian(nums1);

        // merge sort
        int length = nums1.length + nums2.length;
        int[] sorted = new int[length];
        int j = 0,k = 0;

        for(int i = 0; i < length; i++){
            if(j >= nums1.length){
                sorted[i] = nums2[k];
                k++; // 需后移
                continue; // not break
            }

            if(k >= nums2.length){
                sorted[i] = nums1[j];
                j++;
                continue;
            }

            if(nums1[j] > nums2[k]){
                sorted[i] = nums2[k];
                k++;
            }else{
                sorted[i] = nums1[j];
                j++;
            }
        }

        return this.findMedian(sorted);
    }

    public static void main(String[] args){
        MedianOfTwoSortedArray medianOfTwoSortedArray = new MedianOfTwoSortedArray();

        int[] a = {1};
        int[] b = {2,3,4};

        System.out.print(medianOfTwoSortedArray.findMedianSortedArrays(a, b));
    }
}
