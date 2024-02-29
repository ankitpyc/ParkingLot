package domain;

import domain.enums.VehicleType;
import lombok.*;

import java.time.Duration;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    VehicleType vehicleType;
    String vehicleNumber;
    Duration parkingDuration;
}
