package database;

import domain.enums.ParkingLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
@Builder
public class ParkingSlot {

    ParkingLevel parkingLevel;
    String vehicleNo;
    Date parkingEntryTime;
}
