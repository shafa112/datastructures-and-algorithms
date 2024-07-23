package examples.uber;

public class Trip {
    String tripId;
    Location currentLocation;
    TripStatus tripStatus;
    Double estimatedFare; // if trip status is completed estimated fare becomes actual fare.
}
