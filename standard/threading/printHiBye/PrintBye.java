package threading.printHiBye;

public class PrintBye implements Runnable{

    PrintHiByeInOrder printHiByeInOrder;

    PrintBye(PrintHiByeInOrder printHiByeInOrder) {
        this.printHiByeInOrder = printHiByeInOrder;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                printHiByeInOrder.printBye();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
