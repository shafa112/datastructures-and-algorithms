package examples.elevator;

/**
 *
 */
public class ElevatorManager {

    ElevatorSelector elevatorSelector;

    // user requesting elevator from outside to come to this floor
    void callElevator(int floorNumber) {
        Elevator elevator = elevatorSelector.getElevator(floorNumber);
        // add request to elevator e1 that you also have this serve
        elevator.addRequestInQueue(new Request(floorNumber));
    }
}
