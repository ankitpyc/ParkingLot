package domain;

import domain.enums.VehicleType;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Builder
@Data
public class Vehicle {
    VehicleType vehicleType;
    String vehicleNumber;
    Duration parkingDuration;
}
