package database.interfaces;

import domain.dto.ParkingSlot;
import domain.enums.ParkingLevel;
import domain.enums.VehicleType;

public interface ParkingStoreInf {
    public ParkingSlot getParkingSlot(VehicleType vehicleType, String vehicleNo);

    public void freeParkingSlot(ParkingLevel parkingLevel, VehicleType vehicleType);

}
