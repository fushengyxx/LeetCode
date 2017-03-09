package esay;

/**
 * Created by yixinxin on 17/3/9.
 *
 * 26. Remove Duplicates from Sorted Array
 *
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.

 Subscribe to see which companies asked this question.
 *
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int duplicates = 0;
        int preLength = nums.length;

        if(preLength <= 1)
            return preLength;

        for(int i = 1; i < preLength; i++){
            if(nums[i - 1] == nums[i]){
                duplicates++;
            }
        }

        return preLength - duplicates;
    }


    // return the length and the array
    // 重复的数不计入内，把非重复的数重新排列
    public int removeDuplicates2(int[] nums){
        int preLength = nums.length;

        if(preLength < 2)
            return preLength;

        int id = 1;
        for(int i = 1; i < preLength; i++){
            if(nums[i] != nums[i - 1])
                nums[id++] = nums[i];
        }
        return id;

    }

    public static void main(String[] args){
        RemoveDuplicatesFromSortedArray removeDuplicatesFromSortedArray = new RemoveDuplicatesFromSortedArray();

        int[] nums = {1,1,2,2,3};
        System.out.print(removeDuplicatesFromSortedArray.removeDuplicates(nums));
    }

}
