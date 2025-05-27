package com.duong.ss12.controller.hw03;

import com.duong.ss12.dto.hw03.CreateSeatDTO;
import com.duong.ss12.dto.hw03.UpdateSeatDTO;
import com.duong.ss12.model.Seat;
import com.duong.ss12.service.hw03.SeatService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/seats")
public class SeatController {

    private final SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/bus/{busId}")
    public String displaySeatList(@PathVariable("busId") int busId, Model model) {
        List<Seat> seats = seatService.getSeatsByBusId(busId);
        model.addAttribute("seats", seats);
        model.addAttribute("busId", busId);
        return "hw03_seat_list";
    }

    @GetMapping("/add/{busId}")
    public String displayAddForm(@PathVariable("busId") int busId, Model model) {
        CreateSeatDTO dto = new CreateSeatDTO();
        dto.setBusId(busId);
        model.addAttribute("createSeatDTO", dto);
        model.addAttribute("busId", busId);
        return "hw03_seat_add";
    }

    @PostMapping("/add/{busId}")
    public String handleAddSeat(@PathVariable("busId") int busId,
                                @ModelAttribute("createSeatDTO") @Valid CreateSeatDTO dto,
                                BindingResult result,
                                Model model) {
        dto.setBusId(busId);

        if (result.hasErrors()) {
            model.addAttribute("busId", busId);
            return "hw03_seat_add";
        }

        boolean success = seatService.insertSeat(dto);
        if (!success) {
            model.addAttribute("message", "Insert seat failed!");
            return "error";
        }

        return "redirect:/seats/bus/" + busId;
    }

    @GetMapping("/edit/{id}")
    public String displayEditForm(@PathVariable("id") int id, Model model) {
        Optional<Seat> opt = seatService.findById(id);
        if (opt.isPresent()) {
            Seat s = opt.get();
            UpdateSeatDTO dto = new UpdateSeatDTO(
                    s.getId(),
                    s.getBusId(),
                    s.getNameSeat(),
                    s.getPrice(),
                    s.getStatus()
            );
            model.addAttribute("updateSeatDTO", dto);
            return "hw03_seat_edit";
        }

        model.addAttribute("message", "Seat not found!");
        return "error";
    }


    @PostMapping("/edit")
    public String handleEdit(@ModelAttribute("updateSeatDTO") @Valid UpdateSeatDTO dto,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) return "hw03_seat_edit";

        boolean success = seatService.updateSeat(dto);
        if (!success) {
            model.addAttribute("message", "Update seat failed!");
            return "error";
        }

        return "redirect:/buses";
    }

    @PostMapping("/delete/{id}")
    public String deleteSeat(@PathVariable("id") int id, Model model) {
        boolean success = seatService.deleteSeatById(id);
        if (!success) {
            model.addAttribute("message", "Cannot delete seat!");
            return "error";
        }

        return "redirect:/buses";
    }
}
