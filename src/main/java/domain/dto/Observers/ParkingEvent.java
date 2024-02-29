package domain.dto.Observers;

import domain.dto.enums.ParkingLevelEvent;
import domain.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParkingEvent {
    ParkingLevelEvent parkingLevelEvent;
    int level;
    VehicleType vehicleType;
}
