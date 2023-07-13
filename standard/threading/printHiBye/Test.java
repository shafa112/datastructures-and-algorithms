package threading.printHiBye;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        PrintHiByeInOrder printHiByeInOrder = new PrintHiByeInOrder();
        PrintHi printHi = new PrintHi(printHiByeInOrder);
        PrintBye printBye = new PrintBye(printHiByeInOrder);


        Thread t2 = new Thread(printBye);
        //Thread t3 = new Thread(printBye);
        //Thread t4 = new Thread(printHi);
        Thread t1 = new Thread(printHi);
        t1.start();
        t2.start();
        //t3.start();
        //t4.start();

        t1.join();
        t2.join();
        //t3.join();
        //t4.join();

        System.out.println("Main end");

    }
}
