package threading.printHiBye;

public class PrintHi implements Runnable {

    PrintHiByeInOrder printHiByeInOrder;

    PrintHi(PrintHiByeInOrder printHiByeInOrder) {
        this.printHiByeInOrder = printHiByeInOrder;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                printHiByeInOrder.printHi();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
