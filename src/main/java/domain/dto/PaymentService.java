package domain.dto;

import domain.dto.Ticket.ParkingTicket;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    Boolean payTicketPrice(ParkingTicket parkingTicket){
        return true;
    }
}
