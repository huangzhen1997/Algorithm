package multi;
public class Prime {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
       for(int i = 0 ; i<10;i++){

           //increase the problem size to see difference between parallel vs sequential thread version (not single thread vs multi-thread but similar)
            PrimeThread p = new PrimeThread("thread"+((Integer) i).toString(),i*100+1,i*100+100);
            p.start();
            //sequential if remove the comment below
            //p.join();
       }

        long endTime = System.nanoTime() - startTime;
       System.out.println(endTime);
    }
}

class PrimeThread implements Runnable{
    Thread primeThread;
    static int index;
    static int output[] = new int[1000];
    private String threadName;
    private int start;
    private int end;
    PrimeThread(String name,int s, int e){
        threadName = name;
        start=s;
        end=e;
    }

    @Override
    public synchronized void run() {
        //System.out.println(this.primeThread.getId()+": "+"The start is "+start+" and the end is "+end);
        for (int i = start; i<=end; i++){
            if (i==1) continue;
            boolean flag = true;
            for(int j = 2; j<=i/2; j++){
                if(i%j == 0){
                    flag = false;
                    break;
                }
            }

            if(flag) output[index++]=i;
        }

        //print the array when there is
        if(index>160){
            for(int i =0; i<168;i++){
                System.out.println(output[i]);
            }
        }
    }
    public void start(){
        primeThread = new Thread(this,threadName);
        //System.out.println( this.primeThread.getId()+": Thread started");
        primeThread.start();
    }

//    public void join(){
//        try{
//            primeThread.join();
//        }
//
//        catch (InterruptedException ie){
//            ie.printStackTrace();
//        }
//    }
}


