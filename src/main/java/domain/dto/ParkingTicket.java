package domain.dto;

import domain.enums.ParkingLevel;
import domain.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
@Builder
public class ParkingTicket {
 ParkingLevel parkingLevel;
 Date parkingEntryDateTime;
 String vehicleNumber;
 PaymentMethod paymentMethod;
 VehicleType vehicleType;
}
