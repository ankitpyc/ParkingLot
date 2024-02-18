package domain.dto.Ticket;

import domain.dto.PaymentMethod;
import domain.dto.enums.PaymentStatus;
import domain.enums.VehicleType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.Duration;
import java.time.Instant;

@Data
@AllArgsConstructor
@Builder
public class ParkingTicket {
 int parkingLevel;
 Instant parkingEntryDateTime;
 String vehicleNumber;
 Duration parkingDuration;
 PaymentStatus paymentStatus;
 PaymentMethod paymentMethod;
 VehicleType vehicleType;

}
