package examples.elevator;

import java.util.List;

public class ElevatorSelector {

    List<Elevator> elevatorList;
    ElevatorSelectorStrategy elevatorSelectorStrategy;

    Elevator getElevator(int floor) {
        elevatorSelectorStrategy.selectElevator(elevatorList, floor);
        return null;
    }
}
