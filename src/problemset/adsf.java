class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int x = m-1;
        int y =   n-1;
        int count = nums1.length-1;

        while (y>=0){
            if(x>=0){
                nums1[count--] = nums1[x]<nums2[y] ? nums2[y--] : nums1[x--];
            }
            else{
                nums1[count--] = nums2[y--];
            }
        }

    }
}