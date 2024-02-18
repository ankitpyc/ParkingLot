package database.interfaces;

import domain.dto.Ticket.ParkingTicket;

public interface TicketGeneratorInf {


    public ParkingTicket calculateFare(ParkingTicket parkingTicket);

    public Boolean makePayment(ParkingTicket parkingTicket);
}
