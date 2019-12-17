public class QuickSort {

    public static void main(String[] args){
        
        int[] array = {2,4,1,6,41234,123,10,6,3,7,9,0};
        
        quicksort(array,0,array.length-1);
        String output = outputformat(array);
        System.out.println(output);
    }

   public static void quicksort(int[] array,int low, int high){
        if(low < high){
            int pivot_index= partition(array,low,high);
            quicksort(array,low,pivot_index-1);
            quicksort(array,pivot_index+1,high);
        }
   }

    public static int partition(int[] array, int low, int high){

        int leftWall = low;
        int pivot= array[low];
        int pivot_index= low;//could be optimize by selecting three-medium

        for(int i = low+1; i <=high ; i++){

            if(array[i]<pivot){

                //These two if-conditions are just simply keeping track of where the pivot goes.
                if (leftWall==pivot_index){
                    pivot_index=i;
                }
                else if (i == pivot_index){
                    pivot_index=leftWall;
                }
                
                //swap the leftWall so that everything on the LHS of it are smaller and RHS are bigger
                swap(array,i,leftWall);
                leftWall=leftWall+1;

            }

        }

        swap(array,leftWall,pivot_index);
        return leftWall;
    }

    public static void swap(int[] array,int pos1,int pos2){

        int temp = array[pos1];
        array[pos1]=array[pos2];
        array[pos2]=temp;

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
