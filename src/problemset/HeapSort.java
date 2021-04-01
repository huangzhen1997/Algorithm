public class HeapSort {

    public static void main(String[] args){
        int[] array = {3,2,5,1,7,6,10,4};
        heapsort(array);

        String out= outputformat(array);
        System.out.println(out);
    }

    public static void heapify(int[] array,int size, int root){

        int left=root*2+1;
        int right=root*2+2;
        int largest = root;

        if (left<size&&array[left]>array[largest]){
            largest=left;
        }

        if (right<size&&array[right]>array[largest]){
            largest=right;
        }

        if (largest!=root){
            int temp= array[root];
            array[root]=array[largest];
            array[largest]=temp;
            heapify(array,size,largest);
        }
    }

    public static void heapsort(int[] array){

        int n = array.length;

        for(int i = n/2-1; i >= 0; i--){
            heapify(array,n,i);
        }

        for(int i=n-1;i>=0;i--){

            //pop the max at the root level and put it at the end.
            int temp = array[i];
            array[i]=array[0];
            array[0]=temp;

            heapify(array,i,0);
        }
    }

    public static String outputformat(int[] array){
        String output = "[";
        for(int i=0;i<array.length;i++){
            output = output+(Integer.valueOf(array[i]));
            if(i!=array.length-1){
                output = output+",";
            }
            else{
                output=output+"]";
            }
        }
        return output;
    }
}
