import java.util.Arrays;

public class Solution7 {
    public static void main(String[] args){

        int[] movie_duration1 = {110,110,110,110};
        int d1 = 250;
        int[] movie_duration2 = {90, 85, 75, 60, 155, 150, 125};
        int d2 = 250;
        int[] movie_duration3 = {90, 85, 75, 60, 120,110, 110, 150, 125};
        int d3 = 250;
        System.out.println(Arrays.toString(longestMovie(movie_duration1, d1)));
        System.out.println(Arrays.toString(longestMovie(movie_duration2, d2)));
        System.out.println(Arrays.toString(longestMovie(movie_duration3, d3)));

    }

    public static int[] longestMovie(int[] movieDurations,int d){

        if(movieDurations==null || movieDurations.length<=1){
            return new int[]{-1,-1};
        }

        int[] movieDurationsCopy = movieDurations.clone();
        Arrays.sort(movieDurationsCopy);
        int left = 0;
        int right = movieDurations.length-1;
        int cur_best = Integer.MAX_VALUE;
        int[] best_combo = new int[2];

        while(left<right){

            int cur_d = movieDurationsCopy[left]+movieDurationsCopy[right];
            if( cur_d<= d - 30){

                int cur = d-30-cur_d;
                if(cur<cur_best){
                    cur_best = cur;
                    best_combo[0] = left;
                    best_combo[1] = right;
                }
                left++;
            }
            else{
                right--;
            }
        }

        int[] output = new int[2];

        for(int i = 0; i<movieDurations.length;i++){
            if(movieDurations[i] == movieDurationsCopy[best_combo[1]]){
                output[1] = i;
            }
        }
        for(int i = movieDurations.length-1;i>=0;i--){
            if(movieDurations[i] == movieDurationsCopy[best_combo[0]]){
                output[0] = i;
            }
        }

        return output;
    }
}
