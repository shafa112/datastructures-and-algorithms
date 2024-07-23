package examples.elevator;

public class ElevatorButton implements Button {
    int floor;
    Elevator elevator;
    @Override
    public void press() {
        elevator.addRequestInQueue(new Request(floor));
    }
}
