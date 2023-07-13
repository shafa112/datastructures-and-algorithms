package threading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueStuckTestResolved {
    BlockingQueue<Runnable> queue = new ArrayBlockingQueue(10);
    public static void main(String[] args) {
        BlockingQueueStuckTestResolved stuckTestResolved = new BlockingQueueStuckTestResolved();

        System.out.println("I am free in main");
        for(int i = 1 ; i <= 10; i++)
        {
            stuckTestResolved.submitTask(new MyTasks("task-" + i));
        }

        List<Integer> l = new ArrayList<>();

        System.out.println("MAIN IS DONE");
    }
    //initialization block
    {
        /*
            class SomeTask implements Runnable{
            @override
            run()
            {
                executeMe();
            }
            }

            Thread t = new Thread(new SomeTask());
            t.start();
         */

        new Thread(new Runnable() {
            @Override
            public void run() {
                executeMe();
            }
        }, "ShafaThread").start();

        /*
        // Anonymous function
        Runnable r = new Runnable() {
            @Override
            public void run() {
                executeMe();
            }
        };

        new Thread(r , "shafaThread").start();
        */

        //OR...............
        //using lambda expression
        //new Thread(()-> executeMe(), "shafaThread").start();


        /*
        int y  = () -> {
            ....
            sout()
            return x;
        }
         */

    }

    private void executeMe() {
        int count = 1;
        int executed = 1;
        while (true)
        {
            System.out.println("In executeMe - " + Thread.currentThread().getName());

            try {
                Runnable r = queue.take();
                //one thread per task
                new Thread(r, "newCustom Thread" + count++).start();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("executed task " + executed++ );
        }
    }

    public void submitTask(Runnable task)
    {
        try {
            queue.put(task);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}

class MyTasks implements Runnable{

    String name;
    MyTasks(String name)
    {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(name + " is run by " + Thread.currentThread().getName());
    }
}
