package com.duong.ss09.controller;

import com.duong.ss09.model.Schedule;
import com.duong.ss09.model.ScreenRoom;
import com.duong.ss09.model.Seat;
import com.duong.ss09.service.hw03.ScheduleService;
import com.duong.ss09.service.hw03.ScreenRoomService;
import com.duong.ss09.service.hw04.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private ScheduleService scheduleService;

    @Autowired
    private ScreenRoomService screenRoomService;

    @Autowired
    private SeatService seatService;

    @GetMapping("/booking/{scheduleId}")
    public String showBookingPage(@PathVariable("scheduleId") Long scheduleId, Model model) {
        scheduleService.findById(scheduleId).ifPresentOrElse(
                schedule -> {
                    ScreenRoom room = screenRoomService.findById(schedule.getScreenRoomId()).orElse(null);
                    List<Seat> seats = seatService.findByScreenRoomId(schedule.getScreenRoomId());

                    model.addAttribute("schedule", schedule);
                    model.addAttribute("screenRoom", room);
                    model.addAttribute("seats", seats);
                },
                () -> model.addAttribute("error", "Không tìm thấy lịch chiếu.")
        );

        return "booking";

    };
}