import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args){
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        obj.addNum(3);
        obj.addNum(4);
        System.out.println(obj.findMedian());
//        obj.addNum(2);
    }

    PriorityQueue<Integer> descending ;
    PriorityQueue<Integer> ascending ;
    boolean even;
    /** initialize your data structure here. */
    public MedianFinder() {
        descending = new PriorityQueue<>(Collections.reverseOrder());
        ascending = new PriorityQueue<>();
        even = true;
    }

    public void addNum(int num) {
        if(even){
            descending.offer(num);
            ascending.offer(descending.poll());
            even = false;
        }
        else{
            ascending.offer(num);
            descending.offer(ascending.poll());
            even = true;
        }
    }

    public double findMedian() {
        if(even){
            return (descending.peek() + ascending.peek())/2.0;
        }
        else{
            return (double) ascending.peek();
        }

    }

}
