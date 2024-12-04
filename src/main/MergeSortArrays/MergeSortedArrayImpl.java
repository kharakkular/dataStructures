package MergeSortArrays;

public class MergeSortedArrayImpl {

    // public static void main(String[] args) {
    //     System.out.println("Hello World");

    //     int[] num1 = { 1,2,3,0,0,0 };
    //     int[] num2 = { 2,5,6 };
    //     merge(num1, 3, num2, 3);

    //     for(int i=0; i< num1.length; i++) {
    //         System.out.println(num1[i]);
    //     }
    // }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m-1;
        int p2 = n-1;
        int mainIndex = m+n-1;

        while(p1 >=0 && p2 >= 0) {
            if(nums1[p1] > nums2[p2]) {
                nums1[mainIndex--] = nums1[p1--];
            } else {
                nums1[mainIndex--] = nums2[p2--];
            }
        }

        while(p2 >= 0) {
            nums1[mainIndex--] = nums2[p2--];
        }
    }
}