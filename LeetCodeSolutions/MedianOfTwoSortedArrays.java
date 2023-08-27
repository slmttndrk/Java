package LeetCodeSolutions;

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] res = new int[nums1.length + nums2.length];
        int i=0, j=0, k=0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] <= nums2[j]){
                res[k] = nums1[i];
                i++;
            }
            else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }

        if(i == nums1.length){
            while(j<nums2.length){
                res[k] = nums2[j];
                k++;
                j++;
            }
        }
        else{
            while(i<nums1.length){
                res[k] = nums1[i];
                k++;
                i++;
            }
        }

        if(res.length % 2 == 0) {
            return (double) (res[(res.length-1) / 2] + res[res.length / 2]) / 2;
        }
        else{
            return res[res.length / 2];
        }
    }
}

public class MedianOfTwoSortedArrays {
}
