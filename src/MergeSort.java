public class MergeSort{

    public static void main(String[] args){

        int[] array={22,24,45,20,56,65,};
        //mergeSort(array,0,7);
        mergeSort(array,0,7);
        String output= outputformat(array);
        System.out.println(output);

    }


    public static void merge(int[] array,int left,int right,int middle){

        int left_size = middle-left;
        int right_size= right-middle+1;
        int[] left_array=new int[left_size];
        int[] right_array=new int[right_size];

        for(int i = left;i<middle;i++){
            left_array[i-left]=array[i];
        }

        for(int i = middle;i<=right;i++){
            right_array[i-middle]=array[i];
        }

        int a,b,c;
        a = 0;
        b = 0;
        c = left; //important


        while(a<left_size && b<right_size){

            if(left_array[a]<right_array[b]){
                array[c]=left_array[a];
                a++;
                c++;

            }
            else{
                array[c]=right_array[b];
                b++;
                c++;
            }
        }

        while(a<left_size){
            array[c]=left_array[a];
            a++;
            c++;
        }

        while(b<right_size){
            array[c]=right_array[b];
            b++;
            c++;
        }
    }


    public static void mergeSort(int[] array,int L, int R){


        if (L==R){  //base case
            return;
        }

        else{ //recursive call
            int M=(R+L)/2;
            mergeSort(array,L,M);
            mergeSort(array,M+1,R);
            merge(array,L,R,M+1);
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

