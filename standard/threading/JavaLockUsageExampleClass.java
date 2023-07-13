package threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class JavaLockUsageExampleClass implements Runnable{
    //I can define states for a Runnable also
    public static void main(String[] args) throws InterruptedException {
            JavaLockUsageExampleClass jl = new JavaLockUsageExampleClass();
            Thread t1 = new Thread(jl);
            Thread t2 = new Thread(jl);
            t1.start();
            t2.start();
            t1.join();
            t2.join();
    }
    @Override
    public void run() {
        MyDummyClass.printme();   //This MyDummyClass can be anywhere
    }
}

class MyDummyClass{

        static Lock lock = new ReentrantLock();
    /*  This will be initialised only once because it is class variable
        Moment any object is created or moment any static method of MyDummyClass
        is called.
        Any thread calling will always use this same lock object irrespective
        of how any thread is created or any object of MyDummyClass is created
        on which printme is called.
    */
    static void printme() {

        lock.lock();
        System.out.println("Locked Inside thread "+ Thread.currentThread().getName());
        System.out.println("sleeping ");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Unlocked by " + Thread.currentThread().getName());
        lock.unlock();
        //ArrayBlockingQueue

    }
}
