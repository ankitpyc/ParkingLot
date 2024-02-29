import domain.Vehicle;
import domain.dto.Parking.parkingBoard.ParkingLevel;
import domain.dto.ParkingManager;
import domain.dto.Ticket.ParkingTicket;
import domain.enums.VehicleType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ParkingApplication implements CommandLineRunner {
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
    }

    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the no of parking levels : ");
        // Read the input from the user
        String parkingLevelsSize = scanner.nextLine();
        initializeParkingLevels(Integer.parseInt(parkingLevelsSize));
        ParkingManager parkingManager = new ParkingManager(parkingLevelList);
        while (true) {
            System.out.print("Enter the vehicleType and vehicle no : ");
            String vehicle = scanner.nextLine();
            String vehicleNo = scanner.nextLine();

            VehicleType vehicleType = VehicleType.valueOf(vehicle);
            Vehicle vehicle1 = new Vehicle();
            ParkingTicket parkingTicket = parkingManager.getParkingTicket(vehicle1);
            System.out.println("Parking level :" + parkingTicket.getParkingLevel());
            System.out.println("Vehicle Number :" + parkingTicket.getVehicleNumber());
            System.out.println("Parking Time :" + parkingTicket.getParkingEntryDateTime());
            System.out.println("Parking Exit :" + parkingTicket.getParkingEntryDateTime().plus(parkingTicket.getParkingDuration()));
            parkingManager.parkVehicle(parkingTicket);
        }
    }
}
