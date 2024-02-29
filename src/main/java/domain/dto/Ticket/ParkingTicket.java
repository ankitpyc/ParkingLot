package domain.dto.Ticket;

import domain.dto.PaymentMethod;
import domain.dto.enums.PaymentStatus;
import domain.enums.VehicleType;
import lombok.*;

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

 public int getParkingLevel() {
  return parkingLevel;
 }

 public void setParkingLevel(int parkingLevel) {
  this.parkingLevel = parkingLevel;
 }

 public Instant getParkingEntryDateTime() {
  return parkingEntryDateTime;
 }

 public void setParkingEntryDateTime(Instant parkingEntryDateTime) {
  this.parkingEntryDateTime = parkingEntryDateTime;
 }

 public String getVehicleNumber() {
  return vehicleNumber;
 }

 public void setVehicleNumber(String vehicleNumber) {
  this.vehicleNumber = vehicleNumber;
 }

 public Duration getParkingDuration() {
  return parkingDuration;
 }

 public void setParkingDuration(Duration parkingDuration) {
  this.parkingDuration = parkingDuration;
 }

 public PaymentStatus getPaymentStatus() {
  return paymentStatus;
 }

 public void setPaymentStatus(PaymentStatus paymentStatus) {
  this.paymentStatus = paymentStatus;
 }

 public PaymentMethod getPaymentMethod() {
  return paymentMethod;
 }

 public void setPaymentMethod(PaymentMethod paymentMethod) {
  this.paymentMethod = paymentMethod;
 }

 public VehicleType getVehicleType() {
  return vehicleType;
 }

 public void setVehicleType(VehicleType vehicleType) {
  this.vehicleType = vehicleType;
 }
}
