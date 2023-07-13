package threading;

public class SyncIssue implements Runnable{

    int count;
    public static void main(String[] args) throws InterruptedException {

        SyncIssue syncIssue = new SyncIssue();
        Thread t1 = new Thread(syncIssue);
        Thread t2 = new Thread(syncIssue);
        t1.start();
        t2.start();
        //before this line both t1 and t2 has started and running

        t1.join(); //until t1 has not finished, next line won't execute
        t2.join(); //until t2 has not finished, next line won't execute
        // both t1 and t2 finished before SOP()
        System.out.println("Final value of count = " + syncIssue.count);
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 100 ; i++){
            increment();
        }
    }

    void increment()
    {
        System.out.println("increment called by : " + Thread.currentThread().getName());
        count++;
    }
}
