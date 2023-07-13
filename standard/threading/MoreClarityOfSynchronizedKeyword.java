package threading;

/*
*   lock is taken/acquired by the thread on the object which is
*   calling the method or object written as synchronized(obj)
*   and not on which Thread is created as say Thread t = new Thread(someObj)
*/
public class MoreClarityOfSynchronizedKeyword {
    public static void main(String[] args) throws InterruptedException {
        //MoreClarityOfSynchronizedKeyword m = new MoreClarityOfSynchronizedKeyword();
        A a1 = new A();
        A a2 = new A();
        Thread t1 = new Thread(a1, "t1");
        Thread t2 = new Thread(a2, "t2");
        Thread t3 = new Thread(a1, "t3");
        t1.start();
        t2.start();
        t3.start();
        t3.join();
        t1.join();
        t2.join();
    }

    //initialization block
    {
        execute();
    }

    void execute()
    {
        System.out.println("Called from init block");
    }
}

class A implements Runnable{
    static B objB = new B();
    @Override
    public void run() {
        objB.print();
    }
}

class B{

    public void print()
    {
        synchronized (this)   //this will always be on B object
        {
            System.out.println("I am run by - " + Thread.currentThread().getName());
            System.out.println("sleeping for 5 second");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Done sleeping by - " + Thread.currentThread().getName());
        }
    }

    public synchronized void sameasAboveprint()
    {
        System.out.println("I am run by - " + Thread.currentThread().getName());
        System.out.println("sleeping for 5 second");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Done sleeping by - " + Thread.currentThread().getName());

    }
}
