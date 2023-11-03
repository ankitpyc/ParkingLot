package database;

import database.interfaces.ParkingStoreInf;
import domain.ParkingLevelDetails;
import domain.enums.ParkingLevel;
import domain.enums.VehicleType;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class ParkingStore implements ParkingStoreInf {
    Map<ParkingLevel, ParkingLevelDetails> parkingLevelDetails;

    public ParkingStore() {
        this.parkingLevelDetails = new HashMap<>();
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
}
