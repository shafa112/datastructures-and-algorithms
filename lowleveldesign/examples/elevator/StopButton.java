package examples.elevator;

public class StopButton implements Button {
    Elevator elevator;

    @Override
    public void press() {
        elevator.stop();
    }
}
