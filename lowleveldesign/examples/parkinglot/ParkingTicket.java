package examples.parkinglot;

import java.time.LocalDateTime;

public class ParkingTicket {
    String ticketId;
    // For entire city, add -> String parkingLotId;
    String spotId;
    String vehicleId;
    LocalDateTime dateTime;
    TicketStatus ticketStatus;
}
