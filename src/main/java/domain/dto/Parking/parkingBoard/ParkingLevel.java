package domain.dto.Parking.parkingBoard;

import domain.dto.Observers.ParkingEvent;
import domain.dto.config.ParkingLevelConfiguration;
import domain.enums.VehicleType;

import java.util.*;

import static domain.dto.enums.ParkingLevelEvent.*;

public class ParkingLevel extends Observable {

    Map<VehicleType, Integer> vehicleTypeMap;
    int parkingLevel;

    private ParkingLevelConfiguration parkingLevelConfiguration;

    public ParkingLevel(int level) {
        this.vehicleTypeMap = new HashMap<>();
        initializeParkingBoard();
    }

    public int getLevel() {
        return parkingLevel;
    }

    private void initializeParkingBoard() {
        ParkingEvent parkingEvent = ParkingEvent.builder().parkingLevelEvent(INITIALIZE_LEVEL).level(parkingLevel).build();
        notifyObservers(parkingEvent);
    }

    public void parkVehicle(VehicleType vehicleType) {
        vehicleTypeMap.put(vehicleType, vehicleTypeMap.getOrDefault(vehicleType, 0) + 1);
        int currentCount = vehicleTypeMap.get(vehicleType);
        if (currentCount != parkingLevelConfiguration.getParkingLevelLimit().get(vehicleType)) {
            ParkingEvent parkingEvent = ParkingEvent.builder()
                    .parkingLevelEvent(PARK_VEHICLE)
                    .level(parkingLevel)
                    .vehicleType(vehicleType)
                    .build();
            notifyObservers(parkingEvent);
        }
    }

    public void unparkVehicle(VehicleType vehicleType) {
        vehicleTypeMap.put(vehicleType, vehicleTypeMap.get(vehicleType) - 1);
        int currentCount = vehicleTypeMap.get(vehicleType);
        if (currentCount == parkingLevelConfiguration.getParkingLevelLimit().get(vehicleType)) {
            ParkingEvent parkingEvent = ParkingEvent.builder()
                    .parkingLevelEvent(UNPARK_VEHICLE)
                    .level(parkingLevel)
                    .vehicleType(vehicleType)
                    .build();
            notifyObservers(parkingEvent);
        }
    }

    public Boolean isFreeSlotAvailable(VehicleType vehicleType) {
        if (vehicleTypeMap.get(vehicleType)
                .equals(parkingLevelConfiguration.getParkingLevelLimit().get(vehicleType))) {
            return true;
        }
        return false;
    }
}
