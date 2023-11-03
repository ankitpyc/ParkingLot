package domain;

import domain.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Map;
@Builder
@Data
@AllArgsConstructor
public class ParkingLevelDetails {
    Map<VehicleType,Integer> parkingDetails;
}
