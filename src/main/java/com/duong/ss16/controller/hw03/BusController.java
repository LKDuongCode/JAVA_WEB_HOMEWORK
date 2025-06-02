package com.duong.ss16.controller.hw03;

import com.duong.ss16.dto.hw03.CreateBusDTO;
import com.duong.ss16.dto.hw03.UpdateBusDTO;
import com.duong.ss16.model.hw03.Bus;
import com.duong.ss16.service.hw03.BusService;
import jakarta.servlet.ServletContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
@RequestMapping("/bus")
public class BusController {
    private final BusService busService;
    private final ServletContext servletContext;

    public BusController(BusService busService, ServletContext servletContext) {
        this.busService = busService;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String showBusList(Model model) {
        model.addAttribute("buses", busService.getAll());
        return "hw03_bus_list";
    }

    @GetMapping("/add")
    public String showAddBusForm(@ModelAttribute("createBusDTO") CreateBusDTO createBusDTO) {
        return "hw03_bus_add";
    }

    @PostMapping("/add")
    public String handleAddBus(@Valid @ModelAttribute("createBusDTO") CreateBusDTO createBusDTO, BindingResult bindingResult, Model model) {


        if (bindingResult.hasErrors()) {
            return "hw03_bus_add";
        }

        MultipartFile file = createBusDTO.getFile();
        try {
            String originalFilename = file.getOriginalFilename();
            String filename = (originalFilename != null) ? originalFilename.replaceAll("\\s+", "_") : "unknown.jpg";


            String realUploadPath = servletContext.getRealPath("/uploads");
            File realDir = new File(realUploadPath);
            if (!realDir.exists()) realDir.mkdirs();


            Path srcUploadPath = Paths.get("D:/Learn/JavaWeb/homeworks/ss16/src/main/webapp/uploads");
            File srcDir = srcUploadPath.toFile();
            if (!srcDir.exists()) srcDir.mkdirs();

            byte[] bytes = file.getBytes();
            FileCopyUtils.copy(bytes, new File(realDir, filename));
            FileCopyUtils.copy(bytes, new File(srcDir, filename));

            createBusDTO.setImage(filename);

            boolean inserted = busService.insertBus(createBusDTO);

            if (!inserted) {
                model.addAttribute("message", "Failed to insert bus!");
                return "error";
            }

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("message", "File upload error: " + e.getMessage());
            return "error";
        }


        return "redirect:/bus";
    }

    @PostMapping("/delete/{id}")
    public String handleDeleteBus(@PathVariable("id") int id, Model model) {

        boolean deleted = busService.deleteBus(id);
        if (!deleted) {
            model.addAttribute("message", "Failed to delete!");
            return "error";
        }

        return "redirect:/bus";
    }


    @GetMapping("/edit/{id}")
    public String showUpdateBusForm(@PathVariable("id") int id, Model model) {
        Optional<Bus> optionalBus = busService.findById(id);
        if (optionalBus.isEmpty()) {
            model.addAttribute("message", "Không tìm thấy xe bus!");
            return "error";
        }

        Bus bus = optionalBus.get();

        UpdateBusDTO dto = new UpdateBusDTO();
        dto.setId(bus.getId());
        dto.setLicensePlate(bus.getLicensePlate());
        dto.setType(bus.getType());
        dto.setRowSeat(bus.getRowSeat());
        dto.setColSeat(bus.getColSeat());
        dto.setImage(bus.getImage());

        model.addAttribute("updateBusDTO", dto);
        return "hw03_bus_edit";
    }

    @PostMapping("/edit")
    public String handleUpdateBus(@Valid @ModelAttribute("updateBusDTO") UpdateBusDTO updateBusDTO,
                                  BindingResult result,
                                  Model model) {

        if (result.hasErrors()) return "hw03_bus_edit";

        MultipartFile file = updateBusDTO.getFile();

        try {
            if (file != null && !file.isEmpty()) {
                String originalFilename = file.getOriginalFilename();
                String filename = (originalFilename != null) ? originalFilename.replaceAll("\\s+", "_") : "unknown.jpg";

                String realUploadPath = servletContext.getRealPath("/uploads");
                File realDir = new File(realUploadPath);
                if (!realDir.exists()) realDir.mkdirs();

                Path srcUploadPath = Paths.get("D:/Learn/JavaWeb/homeworks/ss16/src/main/webapp/uploads");
                File srcDir = srcUploadPath.toFile();
                if (!srcDir.exists()) srcDir.mkdirs();

                byte[] bytes = file.getBytes();
                FileCopyUtils.copy(bytes, new File(realDir, filename));
                FileCopyUtils.copy(bytes, new File(srcDir, filename));

                updateBusDTO.setImage(filename);
            }

            boolean updated = busService.updateBus(updateBusDTO);
            if (!updated) {
                model.addAttribute("message", "Cập nhật thất bại!");
                return "error";
            }

        } catch (IOException e) {
            model.addAttribute("message", "File error: " + e.getMessage());
            return "error";
        }

        return "redirect:/bus";
    }



}
