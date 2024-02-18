package database.interfaces;

import domain.Vehicle;
import domain.dto.Ticket.ParkingTicket;

public interface ParkingStoreInf {
    public ParkingTicket getParkingTicket(Vehicle vehicle);

    public void freeParkingSlot(ParkingTicket parkingTicket);

}
