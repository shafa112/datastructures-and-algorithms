package examples.uber;


// This service will be invoked by rider/customer.
public class TripService {

    TripBookedDetail bookTrip(TripBookRequest request) {
        // get all nearby cabs
        // send notification to each cab mobile with information tripId, riderId, location, estimated cost
        return null;
    }

    void cancelTrip(String tripId) {
        return;
    }

    Trip getTrip(String tripId) {
        return null;
    }
}
