package TwoPointer;


/*
* https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
*/
public class MergeSortedArray {


    /* 
    0ms Beats 100.00% 
    */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int i=m-1, j=n-1, k=m+n-1;
        while(i>=0 && j>=0){
            nums1[k--] = nums1[i]>nums2[j] ? nums1[i--] : nums2[j--];
        }
        while(j>=0){
            nums1[k--] = nums2[j--];
        }
    }

    /*
     * Wrong Answer 17 / 59 testcases passed
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0){
            return;
        }
        int temp=0;
        int i=0, j=0;
        while(i<m && j<n){    
            if(nums1[i]>nums2[j]){
                temp = nums1[i];
                nums1[i++] = nums2[j];
                nums2[j] = temp;
            } 
        }
        if(j<n){
            nums1[i++] = nums2[j]; 
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3; 
        int[] nums2 = {2,5,6};
        int n = 3;

        merge2(nums1, m, nums2, n);

        for(int num: nums1){
            System.out.println(num);
        }
    }
}