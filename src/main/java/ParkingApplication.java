import domain.Vehicle;
import domain.dto.Parking.parkingBoard.ParkingLevel;
import domain.dto.ParkingManager;
import domain.dto.Ticket.ParkingTicket;
import domain.enums.VehicleType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ParkingApplication {
    //Create Parking Levels
    public static final int parkingLevels = 5;

    public static List<ParkingLevel> parkingLevelList;

    private static void initializeParkingLevels(int parkingLevels) {
        for (int i = 0; i < parkingLevels; i++) {
            parkingLevelList.add(new ParkingLevel(i + 1));
        }
    }

    public static void main(String args[]) {
        parkingLevelList = new ArrayList<>();
        initializeParkingLevels(parkingLevels);
        ParkingManager parkingManager = new ParkingManager(parkingLevelList);
        Vehicle vehicle = Vehicle.builder()
                .vehicleType(VehicleType.BIKE)
                .vehicleNumber("2").build();
        ParkingTicket parkingTicket = parkingManager.getParkingTicket(vehicle);
        parkingManager.parkVehicle(parkingTicket);
    }


}
