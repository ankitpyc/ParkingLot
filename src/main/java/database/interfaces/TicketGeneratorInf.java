package database.interfaces;

import domain.dto.ParkingSlot;
import domain.dto.ParkingTicket;

public interface TicketGeneratorInf {

    public ParkingTicket generateParkingTicket(ParkingSlot parkingSlot);

    public ParkingTicket calculateFare(ParkingTicket parkingTicket);

    public Boolean makePayment(ParkingTicket parkingTicket);
}
