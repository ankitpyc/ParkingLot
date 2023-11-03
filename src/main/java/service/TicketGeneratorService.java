package service;

import database.ParkingSlot;
import database.ParkingTicket;
import database.interfaces.TicketGeneratorInf;
import org.springframework.stereotype.Service;

@Service
public class TicketGeneratorService implements TicketGeneratorInf {
    @Override
    public ParkingTicket generateParkingTicket(ParkingSlot parkingSlot) {
        return ParkingTicket.builder().parkingLevel(parkingSlot.getParkingLevel()).parkingEntryDateTime(parkingSlot.getParkingEntryTime()).vehicleNumber(parkingSlot.getVehicleNo()).build();
    }

    @Override
    public ParkingTicket calculateFare(ParkingTicket parkingTicket) {
        return null;
    }
}
