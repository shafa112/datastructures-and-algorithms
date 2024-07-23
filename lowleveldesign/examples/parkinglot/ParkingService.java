package examples.parkinglot;

public class ParkingService {

    ParkingSpotHandler spotHandler;
    ParkingTicketHandler ticketHandler;
    PaymentService paymentService;

    // For entire city ParkingTicket park(vehicle, parkingLotId)
    ParkingTicket park(Vehicle vehicle) {
        ParkingSpot parkingSpot = spotHandler.getFreeParkingSpot(vehicle.vehicleType);
        spotHandler.reserveParkingSpot(vehicle, parkingSpot.spotId);
        ParkingTicket ticket = ticketHandler.generateParkingTicket(vehicle, parkingSpot.spotId);
        return ticket;
    }

    void unPark(String ticketId) {
        // validate if ticket payment is complete
        String spotId = ticketHandler.getSpotIdFromTicket(ticketId);
        spotHandler.freeUpReservedParkingSpot(spotId);
        ticketHandler.updateTicketStatus(ticketId);
    }
}