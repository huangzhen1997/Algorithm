//LeetCode # 215

public class KthLargestElementInAnArray {
    public static void main(String[] args){
        int[] input = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(input,0));
    }


    //使用堆排序，默认前k 是最大的 前k 个数，如果接下来的loop里的数 大于 kth大的数（即nums[0]）, insert这个数到 root
    public static int findKthLargest(int[] nums,int k){

        if(nums.length==1){
            return nums[0];
        }

        for(int i = k-1; i>=0 ; i--){
            heapify(nums,k,i);
        }

        for(int i = k; i< nums.length; i++){
            if(nums[i] > nums[0]){
                nums[0] = nums[i];
                heapify(nums,k,0);
            }
        }

        return nums[0];
    }

    public static void heapify(int[] array, int size, int root){

        int smallest = root;
        int left = root*2 + 1;
        int right =root*2 + 2;

        if( left < size  && array[left] < array[smallest]){
            smallest = left;
        }

        if (right < size && array[right] < array[smallest]){
            smallest = right;
        }

        if(smallest!=root){
            int temp = array[smallest];
            array[smallest] = array[root];
            array[root] = temp;
            heapify(array,size, smallest);
        }
    }
}
