import java.util.StringTokenizer;

public class Testing {
    public static void main(String[] args){
        String a = "1B 2C,2D 4D";
        StringTokenizer tokenizer = new StringTokenizer(a);
        System.out.println(tokenizer.nextToken(","));

    }
}
