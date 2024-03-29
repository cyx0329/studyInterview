package com.study.interview.microsoft.VO2021;

public class MedianOfTwoSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(m > n) return findMedianSortedArrays(nums2, nums1);

        int imin = 0;
        int imax = m;
        int mid = (m+n+1)/2;
        while(imin <= imax) {
            int i = imin+(imax-imin)/2;
            int j = mid-i; //because i increase, j decrease
            if(i < imax && nums2[j-1] > nums1[i]) {
                imin = i + 1;
            } else if(i > imin && nums1[i-1] > nums2[j]) {
                imax = i - 1;
            } else {
                int maxLeft = 0;
                if(i == 0) maxLeft = nums2[j-1];
                else if(j == 0) maxLeft = nums1[i-1];
                else maxLeft = Math.max(nums1[i-1], nums2[j-1]);
                if((m+n) % 2 != 0) return maxLeft;

                int minRight = 0;
                if(i == m) minRight = nums2[j];
                else if(j == n) minRight = nums1[i];
                else minRight = Math.max(nums1[i], nums2[j]);
                return (maxLeft+minRight)/2.0;
            }
        }
        return 0.0;
    }

    public static void main(String []args){
        int[] nums1 = {1, 3};
        int[] nums2 = {4, 5};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);
    }

//          left_part          |        right_part
//    A[0], A[1], ..., A[i-1]  |  A[i], A[i+1], ..., A[m-1]
//    B[0], B[1], ..., B[j-1]  |  B[j], B[j+1], ..., B[n-1]

}
