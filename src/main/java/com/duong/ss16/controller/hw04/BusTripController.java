package com.duong.ss16.controller.hw04;

import com.duong.ss16.dto.hw04.CreateBusTripDTO;
import com.duong.ss16.dto.hw04.UpdateBusTripDTO;
import com.duong.ss16.model.hw04.BusTrip;
import com.duong.ss16.service.hw04.BusTripService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Controller
@RequestMapping("/bus-trip")
public class BusTripController {

    private final BusTripService busTripService;
    private final ServletContext servletContext;

    public BusTripController(BusTripService busTripService, ServletContext servletContext) {
        this.busTripService = busTripService;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String showBusTripList(Model model) {
        model.addAttribute("busTrips", busTripService.getAll());
        return "hw04_bus_trip_list";
    }

    @GetMapping("/add")
    public String showAddBusTripForm(@ModelAttribute("createBusTripDTO") CreateBusTripDTO dto) {
        return "hw04_bus_trip_add";
    }

    @PostMapping("/add")
    public String handleAddBusTrip(@Valid @ModelAttribute("createBusTripDTO") CreateBusTripDTO dto,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) return "hw04_bus_trip_add";

        try {
            MultipartFile file = dto.getFile();
            if (file != null && !file.isEmpty()) {
                String filename = file.getOriginalFilename().replaceAll("\\s+", "_");

                String realPath = servletContext.getRealPath("/uploads");
                String srcPath = "D:/Learn/JavaWeb/homeworks/ss16/src/main/webapp/uploads";

                File realDir = new File(realPath);
                if (!realDir.exists()) realDir.mkdirs();

                File srcDir = new File(srcPath);
                if (!srcDir.exists()) srcDir.mkdirs();

                byte[] bytes = file.getBytes();
                FileCopyUtils.copy(bytes, new File(realDir, filename));
                FileCopyUtils.copy(bytes, new File(srcDir, filename));

                dto.setImage(filename);
            }

            boolean inserted = busTripService.insertBusTrip(dto);
            if (!inserted) {
                model.addAttribute("message", "Insert failed!");
                return "error";
            }

        } catch (IOException e) {
            model.addAttribute("message", "Upload error: " + e.getMessage());
            return "error";
        }

        return "redirect:/bus-trip";
    }

    @GetMapping("/edit/{id}")
    public String showEditBusTripForm(@PathVariable("id") int id, Model model) {
        Optional<BusTrip> opt = busTripService.findById(id);
        if (opt.isEmpty()) {
            model.addAttribute("message", "Bus trip not found!");
            return "error";
        }

        BusTrip busTrip = opt.get();
        UpdateBusTripDTO dto = new UpdateBusTripDTO();

        dto.setId(busTrip.getId());
        dto.setDeparturePoint(busTrip.getDeparturePoint());
        dto.setDestination(busTrip.getDestination());
        dto.setDepartureTime(busTrip.getDepartureTime());
        dto.setArrivalTime(busTrip.getArrivalTime());
        dto.setBusId(busTrip.getBusId());
        dto.setSeatsAvailable(busTrip.getSeatsAvailable());
        dto.setImage(busTrip.getImage());

        model.addAttribute("updateBusTripDTO", dto);
        return "hw04_bus_trip_edit";
    }

    @PostMapping("/edit")
    public String handleEditBusTrip(@Valid @ModelAttribute("updateBusTripDTO") UpdateBusTripDTO dto,
                                    BindingResult result,
                                    Model model) {
        if (result.hasErrors()) return "hw04_bus_trip_edit";

        try {
            MultipartFile file = dto.getFile();
            if (file != null && !file.isEmpty()) {
                String filename = file.getOriginalFilename().replaceAll("\\s+", "_");

                String realPath = servletContext.getRealPath("/uploads");
                String srcPath = "D:/Learn/JavaWeb/homeworks/ss16/src/main/webapp/uploads";

                File realDir = new File(realPath);
                if (!realDir.exists()) realDir.mkdirs();

                File srcDir = new File(srcPath);
                if (!srcDir.exists()) srcDir.mkdirs();

                byte[] bytes = file.getBytes();
                FileCopyUtils.copy(bytes, new File(realDir, filename));
                FileCopyUtils.copy(bytes, new File(srcDir, filename));

                dto.setImage(filename);
            }

            boolean updated = busTripService.updateBusTrip(dto);
            if (!updated) {
                model.addAttribute("message", "Update failed!");
                return "error";
            }

        } catch (IOException e) {
            model.addAttribute("message", "Upload error: " + e.getMessage());
            return "error";
        }

        return "redirect:/bus-trip";
    }

    @PostMapping("/delete/{id}")
    public String handleDeleteBusTrip(@PathVariable("id") int id, Model model) {
        Optional<BusTrip> opt = busTripService.findById(id);
        if (opt.isEmpty()) {
            model.addAttribute("message", "Bus trip not found!");
            return "error";
        }

        BusTrip trip = opt.get();

        boolean deleted = busTripService.deleteBusTrip(id);
        if (!deleted) {
            model.addAttribute("message", "Delete failed!");
            return "error";
        }

        try {
            String realPath = servletContext.getRealPath("/uploads");
            String srcPath = "D:/Learn/JavaWeb/homeworks/ss16/src/main/webapp/uploads";

            File realFile = new File(realPath, trip.getImage());
            File srcFile = new File(srcPath, trip.getImage());

            if (realFile.exists()) realFile.delete();
            if (srcFile.exists()) srcFile.delete();

        } catch (Exception e) {
            System.err.println("Xoá file thất bại: " + e.getMessage());
        }

        return "redirect:/bus-trip";
    }



}
