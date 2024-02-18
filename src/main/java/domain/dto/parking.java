package domain.dto;

import domain.dto.Parking.parkingBoard.ParkingLevel;
import domain.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
public class parking {
    String parkingId;
    String parkingType;
    ParkingLevel parkingLevel;
    Date parkingStartTime;
    Date parkingEndTime;
    VehicleType vehicleType;
    Double ticketPrice;
}
