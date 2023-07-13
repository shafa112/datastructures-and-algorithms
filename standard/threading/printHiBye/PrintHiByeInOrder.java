package threading.printHiBye;

public class PrintHiByeInOrder {

    String str = "Bye";

    synchronized void printHi() throws InterruptedException {
        while(str.equals("Hi")) {
            wait();
        }
        str = "Hi";
        System.out.println(str);
        notifyAll();
    }

    synchronized void printBye() throws InterruptedException {
        while(str.equals("Bye")) {
            wait();
        }
        str = "Bye";
        System.out.println(str);
        notifyAll();
    }





}
