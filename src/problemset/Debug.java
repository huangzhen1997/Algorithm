import java.util.PriorityQueue;

public class Debug {
    public static void main(String[] args){

//        System.out.println(calculateSumOfNumbersInString("12asdfa1"));
//
//        System.out.println("123".indexOf("23"));

//        String[] array = new String[]{"Hello","ni hao","yes"};
//        Arrays.sort(array, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o2.length()-o1.length();
//            }
//        });
//        for (String i : array){
//            System.out.println(i);
//        }
//
//        HashSet<Integer> set = new HashSet<>();
//        System.out.println(set.add(12));
//
//        System.out.println(set.add(12));

//        Comparator<Integer> sorter = new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2-o1;
//            }
//        };

        PriorityQueue<Integer> pQueue = new PriorityQueue();

        // Adding items to the pQueue using add()
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(15);
        pQueue.add(100);

        // Printing the top element of PriorityQueue
        pQueue.remove();
        System.out.println(pQueue.peek());

    }
    public static int calculateSumOfNumbersInString(String inputString) {
        String temp = "";
        int sum = 0;
        for(int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            if(Character.isDigit(ch))
                temp += ch;
            else{
                sum += Integer.parseInt(temp);
                temp ="0";
            }
        }
        return sum + Integer.parseInt(temp);
    }
}
