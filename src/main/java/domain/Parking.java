package domain;

import domain.enums.ParkingLevel;
import domain.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class Parking {
    String parkingId;
    String parkingType;
    ParkingLevel parkingLevel;
    Date parkingStartTime;
    Date parkingEndTime;
    VehicleType vehicleType;
    Double ticketPrice;
}
