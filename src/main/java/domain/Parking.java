package domain;

import domain.enums.ParkingLevel;
import domain.enums.VehicleType;

import java.util.Date;


public class Parking {
    String parkingId;
    String parkingType;
    ParkingLevel parkingLevel;
    Date parkingStartTime;
    Date parkingEndTime;
    VehicleType vehicleType;
}
