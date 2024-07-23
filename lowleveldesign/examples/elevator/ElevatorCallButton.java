package examples.elevator;

public class ElevatorCallButton implements Button{

    int floor;
    ElevatorManager elevatorManager;

    @Override
    public void press() {
        elevatorManager.callElevator(floor);
    }
}
