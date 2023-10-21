package database;

import domain.ParkingLevelDetails;
import domain.enums.ParkingLevel;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class parkingStore {

    Map<ParkingLevel, ParkingLevelDetails> parkingLevelDetails;
}
