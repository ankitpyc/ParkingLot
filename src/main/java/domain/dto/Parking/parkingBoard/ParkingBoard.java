package domain.dto.Parking.parkingBoard;

import domain.dto.Observers.ParkingEvent;
import domain.dto.config.ParkingLevelConfiguration;
import domain.enums.VehicleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ParkingBoard implements Observer {

    Map<Integer, Map<VehicleType, Integer>> vehicleCountMap;

    Map<VehicleType, Integer> parkingCount;

    @Autowired
    ParkingLevelConfiguration parkingLevelConfiguration;

    public ParkingBoard() {
        vehicleCountMap = new HashMap<>();
    }

    /**
     * This method is called whenever the observed object is changed. An
     * application calls an <tt>Observable</tt> object's
     * <code>notifyObservers</code> method to have all the object's
     * observers notified of the change.
     *
     * @param o   the observable object.
     * @param arg an argument passed to the <code>notifyObservers</code>
     *            method.
     */

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof ParkingLevel) {
            ParkingEvent parkingEvent = (ParkingEvent) arg;
            switch (parkingEvent.getParkingLevelEvent()) {
                case PARKING_FULL:
                    parkingCount = vehicleCountMap.get(parkingEvent.getLevel());
                    parkingCount.put(parkingEvent.getVehicleType(), 0);
                    vehicleCountMap.put(parkingEvent.getLevel(), parkingCount);
                    break;
                case INITIALIZE_LEVEL:
                    Map<VehicleType, Integer> parkingLevels = new HashMap<>();
                    for (Map.Entry entry : parkingLevelConfiguration.getParkingLevelLimit().entrySet()) {
                        VehicleType vehicleType = (VehicleType) entry.getKey();
                        Integer countVehicles = (Integer) entry.getValue();
                        parkingLevels.put(vehicleType, countVehicles);
                        vehicleCountMap.put(parkingEvent.getLevel(), parkingLevels);
                    }
                    break;
                case PARK_VEHICLE:
                    parkingCount = vehicleCountMap.get(parkingEvent.getLevel());
                    parkingCount.put(parkingEvent.getVehicleType(), parkingCount.get(parkingEvent.getVehicleType()) + 1);
                    vehicleCountMap.put(parkingEvent.getLevel(), parkingCount);
                    break;

            }
            displayBoard();
        }
    }

    public void displayBoard() {
        for (Map.Entry entry : vehicleCountMap.entrySet()) {
            System.out.println("=========== " + (int) entry.getKey() + " ================");
            Map<VehicleType, Integer> etr = (Map<VehicleType, Integer>) entry.getValue();
            for (Map.Entry entry1 : etr.entrySet()) {
                System.out.println((VehicleType) entry1.getKey() + " : " + (Integer) entry1.getValue());
            }
            System.out.println("=====================================");
        }
    }
}
