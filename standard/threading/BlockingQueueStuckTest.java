package threading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueStuckTest {
    BlockingQueue<Runnable> queue = new ArrayBlockingQueue(10);
    public static void main(String[] args) {
    BlockingQueueStuckTest stuck = new BlockingQueueStuckTest();
    //code will be stuck in executeMe method after run

    //WE HAVE TO FREE THE MAIN METHOD.................Look at BlockingQueueStuckTestResolved class

    System.out.println("I am free in main");
    for(int i = 0 ; i < 10; i++)
    {
        stuck.submitTask(new MyTask("task-" + i));
    }


    }
    {
        executeMe();
    }

    private void executeMe() {
        while (true)
        {
            System.out.println("In executeMe");

            try {
                Runnable r = queue.take();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("executed");
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

class MyTask implements Runnable{

    String name;
    MyTask(String name){this.name = name;}
    @Override
    public void run() {
        System.out.println("I am running" + this.name);
    }
}
