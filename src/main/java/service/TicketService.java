package service;

import domain.Vehicle;
import domain.dto.Ticket.ParkingTicket;
import database.interfaces.TicketGeneratorInf;
import domain.dto.PaymentMethod;
import domain.dto.enums.PaymentStatus;
import domain.enums.EventType;
import domain.observerSubscribe.Observer;
import domain.observerSubscribe.Subject;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


/**
 * This Service is responsible for generating Ticket and taking payments , dynamically updates the numbers around available slot and non-available slot
 */
@Service
public class TicketService implements TicketGeneratorInf, Subject {

    List<Observer> observerList;

    @PostConstruct
    public void init() {
        observerList = new ArrayList<>();
    }


    public ParkingTicket generateParkingTicket(Vehicle vehicle,int parkingLevel) {
        ParkingTicket parkingTicket = ParkingTicket.builder()
                .parkingLevel(parkingLevel)
                .parkingEntryDateTime(Instant.now())
                .vehicleNumber(vehicle.getVehicleNumber())
                .parkingDuration(vehicle.getParkingDuration())
                .paymentStatus(PaymentStatus.PAYMENT_PENDING)
                .build();
        return parkingTicket;
    }

    public Double calculateParkingAmount(ParkingTicket parkingTicket){
        return Double.valueOf(((parkingTicket.getParkingDuration().getSeconds())/3600) * parkingTicket.getVehicleType().price);
    }


    /**
     * The Fare Calculation Strategy
     *
     * @param parkingTicket
     * @return Parking Ticket object with the update Price
     */
    @Override
    public ParkingTicket calculateFare(ParkingTicket parkingTicket) {
        return null;
    }

    /**
     * @param parkingTicket
     * @return
     */
    @Override
    public Boolean makePayment(ParkingTicket parkingTicket) {
        PaymentMethod paymentMethod = parkingTicket.getPaymentMethod();
        return null;
    }

    /**
     * @param object    -  the data that needs to be passed to subscriber objects
     * @param eventType - the event Type that determines the Type of update.
     */
    @Override
    public void notifyObserver(Object object, EventType eventType) {
        for (Observer observer : observerList) {
            observer.onChange(object, eventType);
        }
    }

    @Override
    public void addObserver(Observer observer) {

        this.observerList.add(observer);

    }

    @Override
    public void unsubscribe(Observer ob) {
        this.observerList.remove(ob);
    }

}
