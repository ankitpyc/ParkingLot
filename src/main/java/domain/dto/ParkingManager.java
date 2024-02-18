package domain.dto;

import database.interfaces.ParkingStoreInf;
import domain.Vehicle;
import domain.dto.Parking.parkingBoard.ParkingLevel;
import domain.dto.Ticket.ParkingTicket;
import domain.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TicketService;

import java.util.List;

@Component
public class ParkingManager implements ParkingStoreInf {

    public List<ParkingLevel> parkingLevelList;

    @Autowired
    TicketService ticketGenerator;

    @Autowired
    PaymentService paymentService;

    public ParkingManager(List<ParkingLevel> parkingLevelList) {
        this.parkingLevelList = parkingLevelList;
    }

    @Override
    public synchronized ParkingTicket getParkingTicket(Vehicle vehicle) {
        int parkingLevel = getParkingLevel(vehicle.getVehicleType());
        return ticketGenerator.generateParkingTicket(vehicle, parkingLevel);

    }

    private int getParkingLevel(VehicleType vehicleType) {
        for (ParkingLevel parkingLevel : parkingLevelList) {
            if (parkingLevel.isFreeSlotAvailable(vehicleType)) {
                return parkingLevel.getLevel();
            }
        }
        return -1;
    }

    @Override
    public synchronized void freeParkingSlot(ParkingTicket parkingTicket) {
        Double parkingAmount = ticketGenerator.calculateParkingAmount(parkingTicket);
        parkingLevelList.get(parkingTicket.getParkingLevel()).unparkVehicle(parkingTicket.getVehicleType());
        paymentService.payTicketPrice(parkingTicket);

    }

    public void parkVehicle(ParkingTicket parkingTicket) {
        parkingLevelList.get(parkingTicket.getParkingLevel()).parkVehicle(parkingTicket.getVehicleType());
    }
}
