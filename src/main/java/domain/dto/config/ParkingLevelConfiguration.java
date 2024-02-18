package domain.dto.config;

import domain.dto.Parking.parkingBoard.ParkingLevel;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@ConfigurationProperties
@Data
public class ParkingLevelConfiguration {
    Map<ParkingLevel,Integer> parkingLevelLimit;
}
