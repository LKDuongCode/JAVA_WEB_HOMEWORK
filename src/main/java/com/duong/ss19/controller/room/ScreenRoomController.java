package com.duong.ss19.controller.room;

import com.duong.ss19.dto.room.ScreenRoomDTO;
import com.duong.ss19.service.room.ScreenRoomService;
import com.duong.ss19.service.theater.TheaterService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/screen-rooms")
public class ScreenRoomController {

    private final ScreenRoomService screenRoomService;
    private final TheaterService theaterService;

    public ScreenRoomController(ScreenRoomService screenRoomService, TheaterService theaterService) {
        this.screenRoomService = screenRoomService;
        this.theaterService = theaterService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("screenRooms", screenRoomService.getAllActive());
        return "room_list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("screenRoomDTO", new ScreenRoomDTO());
        model.addAttribute("theaters", theaterService.getAll());
        return "room_create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute("screenRoomDTO") ScreenRoomDTO dto,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("theaters", theaterService.getAll());
            return "room_create";
        }
        screenRoomService.create(dto);
        return "redirect:/screen-rooms";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable("id") Long id, Model model) {
        ScreenRoomDTO dto = screenRoomService.getById(id);
        if (dto == null) return "redirect:/screen-rooms";
        model.addAttribute("screenRoomDTO", dto);
        model.addAttribute("theaters", theaterService.getAll());
        return "room_edit";
    }

    @PostMapping("/edit")
    public String update(@Valid @ModelAttribute("screenRoomDTO") ScreenRoomDTO dto,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("theaters", theaterService.getAll());
            return "room_edit";
        }
        screenRoomService.update(dto);
        return "redirect:/screen-rooms";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        screenRoomService.delete(id);
        return "redirect:/screen-rooms";
    }
}
