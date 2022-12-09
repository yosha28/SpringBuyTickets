package com.example.hwspringbuytickets;

import com.example.hwspringbuytickets.service.CustomerService;
import com.example.hwspringbuytickets.service.EventService;
import com.example.hwspringbuytickets.service.PlaceService;
import com.example.hwspringbuytickets.service.TicketService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;

@Slf4j
@SpringBootApplication
public class HwSpringBuyTicketsApplication {
    @Autowired
    private EventService eventService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private PlaceService placeService;
    @Autowired
    private TicketService ticketService;


    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    public static void main(String[] args) {
        SpringApplication.run(HwSpringBuyTicketsApplication.class, args);



    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void Init() throws ParseException {
////a. Создать ивент из ДТО
//          createEvent();
////b. Создать пользователя
//        //   CustomerDto customerTest = createCustomer();
//
////d. Поиск ближайших(будущих) ивентов
//        List<EventDto> possibleEvent = eventService.getListPossibleEvent(new Date());
//
//        if (possibleEvent.size() > 0) {
////c. Поиск свободных билетов по ивенту.Из доступных первый в списке.
//            var searchEvent = 0;
//            while (searchEvent < possibleEvent.size()) {
//                List<TicketDto> ticketsFree = getFreeTickets(possibleEvent.get(searchEvent));
//                if (ticketsFree.size() > 0) {
//                    CustomerDto customerDto = customerService.getCustomerForEmail("maya@gmail.com");
//                    if (customerDto != null) {
//                        // e. Присвоение билета пользователю
//                        ticketService.buyTicket(ticketsFree.get(0).getId(), customerDto);
//                        System.out.println("Maiia buy ticket");
//                        break;
//                    } else
//                        System.out.println("Bad purchase. customerDto = null");
//
//                } else
//                    searchEvent++;
//            }
//            if (searchEvent == possibleEvent.size()) {
//                System.out.println(" All tickets sold out. No upcoming events .");
//            }
//
//        } else
//            System.out.println("Bad purchase. possibleEvent.size() = 0");
//
//    }
//
//    public void createEvent() throws ParseException {
//        List<TicketPackDto> tickets = new ArrayList<TicketPackDto>();
//        tickets.add(TicketPackDto.builder().cost(100).count(1).build());
//        tickets.add(TicketPackDto.builder().cost(200).count(2).build());
//
//        EventCreationDto dto = new EventCreationDto();
//        dto.setEvent_date(format.parse("2022-12-29"));
//        dto.setName("Event 7");
//        PlaceDto placeDto = PlaceDto.builder().address("str.First").name("ConcertHall 7").build();
//        dto.setPlace(placeDto);
//        dto.setTicketPack(tickets);
//
//        eventService.saveEvent(dto);
//    }
//
//    public CustomerDto createCustomer() {
//
//        CustomerDto customerDto = new CustomerDto();
//        customerDto.setName("Maiia");
//        //email-unique.
//        customerDto.setEmail("maya@gmail.com");
//        customerDto.setPhone("0660515582");
//
//        customerService.saveCustomer(customerDto);
//        return customerDto;
//
//    }
//
//    public List<TicketDto> getFreeTickets(EventDto eventDto) {
//        return ticketService.getListFreeTicketFromEvent(eventDto);
//    }

}
