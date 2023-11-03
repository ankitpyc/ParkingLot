package database.interfaces;

import database.ParkingSlot;
import database.ParkingTicket;

public interface TicketGeneratorInf {

    public ParkingTicket generateParkingTicket(ParkingSlot parkingSlot);

    public ParkingTicket calculateFare(ParkingTicket parkingTicket);
}
