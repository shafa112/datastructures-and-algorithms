package threading;

/**
 * In a producer consumer problem , synchronization issue between two group of people
 * say group A and group B , who are doing say workA and workB
 * on same object is solved...Here synchronization is needed among the same group and
 * between different group people(thread) as well
 *
 * Here t1, t2 belongs to same group who are doing same kind of work
 * so synchronization here is needed only among the same group of people
 * synchronized keyword here is only allowing one member of same group in increment method
 */
public class SyncIssueSolved implements Runnable{
    int count;
    public static void main(String[] args) throws InterruptedException {

        SyncIssue syncIssue = new SyncIssue();

        //every object by default is child of class Object
        //syncIssue.toString()
        //syncIssue.wait();    this.wait()
        //syncIssue.notify();   this.notify()
        //syncIssue.notifyAll();
        //syncIssue.wait(1000);

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
        for(int i = 0 ; i < 10000 ; i++){
            increment();
        }
    }

    synchronized void increment()
    {
        System.out.println("increment called by : " + Thread.currentThread().getName());
        count++;
    }

   /* synchronized on a method is same as
    void increment()
    {
        synchronized(this)
        {
         System.out.println("increment called by : " + Thread.currentThread().getName());
         count++
        }
   }*/

}
