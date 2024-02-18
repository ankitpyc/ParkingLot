package domain.dto.Observers;

import domain.dto.enums.ParkingLevelEvent;
import domain.enums.VehicleType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingEvent {
    ParkingLevelEvent parkingLevelEvent;
    int level;
    VehicleType vehicleType;
}
