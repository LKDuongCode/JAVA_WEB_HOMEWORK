package com.duong.ss16.controller.hw05;

import com.duong.ss16.dto.hw05.CreateTicketDTO;
import com.duong.ss16.model.hw04.BusTrip;
import com.duong.ss16.service.hw04.BusTripService;
import com.duong.ss16.service.hw05.TicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class TicketController {

    private final BusTripService busTripService;
    private final TicketService ticketService;

    public TicketController(BusTripService busTripService, TicketService ticketService) {
        this.busTripService = busTripService;
        this.ticketService = ticketService;
    }

    @GetMapping
    public String showList (Model model){
        model.addAttribute("busTrips", busTripService.getAll());
        return "hw01_hw02_user_home";
    }

    @GetMapping("/{id}")
    public String showBookingForm(@PathVariable("id") int id, Model model) {
        Optional<BusTrip> opt = busTripService.findById(id);
        if (opt.isEmpty()) {
            model.addAttribute("message", "Trip not found!");
            return "error";
        }

        BusTrip trip = opt.get();
        model.addAttribute("trip", trip);

        CreateTicketDTO createTicketDTO = new CreateTicketDTO();
        createTicketDTO.setUserId(2);
        createTicketDTO.setTripBusId(trip.getId());
        createTicketDTO.setDepartureDate(trip.getDepartureTime().toLocalDate());

        model.addAttribute("createTicketDTO", createTicketDTO);
        return "hw05_ticket_book";
    }


    @PostMapping
    public String handleBooking(@ModelAttribute("createTicketDTO") CreateTicketDTO dto, Model model) {
//        boolean success = ticketService.insertTicket(dto);
//        if (!success) {
//            model.addAttribute("message", "Failed to book ticket!");
//            return "error";
//        }
//        return "redirect:/book";
        return "success";
    }
}
