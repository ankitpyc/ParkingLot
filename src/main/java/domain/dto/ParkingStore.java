package domain.dto;

import database.interfaces.ParkingStoreInf;
import domain.ParkingLevelDetails;
import domain.enums.EventType;
import domain.enums.ParkingLevel;
import domain.enums.VehicleType;
import domain.observerSubscribe.Observer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import service.TicketService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ParkingStore implements ParkingStoreInf, Observer {
    Map<ParkingLevel, ParkingLevelDetails> parkingLevelDetails;

    @Autowired
    TicketService ticketGenerator;

    public ParkingStore() {
        this.parkingLevelDetails = new HashMap<>();
        ticketGenerator.addObserver(this);
    }

    @Override
    public synchronized ParkingSlot getParkingSlot(VehicleType vehicleType, String vehicleNo) {

        ParkingLevel parkingLevel = getParkingLevel(vehicleType);
        return ParkingSlot.builder().parkingEntryTime(new Date()).parkingLevel(parkingLevel).vehicleNo(vehicleNo).build();

    }

    private ParkingLevel getParkingLevel(VehicleType vehicleType) {
        for (Map.Entry<ParkingLevel, ParkingLevelDetails> details : parkingLevelDetails.entrySet()) {
            ParkingLevelDetails details1 = details.getValue();
            if (details1.getParkingDetails().get(vehicleType) > 0) {
                return details.getKey();
            }
        }
        return null;
    }

    @Override
    public synchronized void freeParkingSlot(ParkingLevel parkingLevel, VehicleType vehicleType) {
        ParkingLevelDetails parkingDetails = parkingLevelDetails.get(parkingLevel);
        int parkingSlotsOccupied = parkingDetails.getParkingDetails().get(vehicleType);
        parkingDetails.getParkingDetails().put(vehicleType, parkingSlotsOccupied + 1);
    }

    @Override
    public void onChange(Object object, EventType eventType) {
        ParkingTicket parkingTicket = null;
        int totalAvailableSlots = this.parkingLevelDetails.get(parkingTicket.getParkingLevel()).getParkingDetails().get(parkingTicket.getVehicleType());
        switch (eventType) {
            case PARKING_SLOT_BOOKED:
                parkingTicket = (ParkingTicket) object;
                this.parkingLevelDetails.get(parkingTicket.getParkingLevel()).getParkingDetails().put(parkingTicket.getVehicleType(), totalAvailableSlots - 1);
            case PARKING_SLOT_EMPTY:
                parkingTicket = (ParkingTicket) object;
                totalAvailableSlots = this.parkingLevelDetails.get(parkingTicket.getParkingLevel()).getParkingDetails().get(parkingTicket.getVehicleType());
                this.parkingLevelDetails.get(parkingTicket.getParkingLevel()).getParkingDetails().put(parkingTicket.getVehicleType(), totalAvailableSlots + 1);
            case ADDED_NEW_SLOT:
                this.parkingLevelDetails.get(parkingTicket.getParkingLevel()).getParkingDetails().put(parkingTicket.getVehicleType(), totalAvailableSlots + 1);
        }
    }
}