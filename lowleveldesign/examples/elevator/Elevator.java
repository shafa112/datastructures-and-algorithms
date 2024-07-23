package examples.elevator;

import java.util.List;

/**
 * See https://github.com/shadab005/DataStructureAndAlgo/tree/master/softwaredesign/src/module/elevator/latest
 */
public class Elevator {
    String elevatorId;
    ElevatorStatus elevatorStatus;
    int currentFloor;
    RequestScheduler requestScheduler;


    void moveToFloor(int floor) {
        // validate lift is already not moving.
        // update ElevatorStatus to moving.
        // moving lift to that floor.
        // update currentFloor
    }

    public void addRequestInQueue(Request request) {
        requestScheduler.addRequest(request);
    }

    public void stop() {
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
