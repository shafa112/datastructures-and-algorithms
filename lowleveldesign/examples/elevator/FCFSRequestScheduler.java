package examples.elevator;

// First come, first serve request scheduler.
public class FCFSRequestScheduler implements RequestScheduler{

    //Queue
    private Elevator elevator;
    @Override
    public void addRequest(Request request) {
    }

    public void run() {
        while(true) {
            Request request = fetchNextRequest();
            elevator.moveToFloor(request.floor);//10s
        }
    }

    private Request fetchNextRequest() {
        // remove from queue
        return null;
    }

}