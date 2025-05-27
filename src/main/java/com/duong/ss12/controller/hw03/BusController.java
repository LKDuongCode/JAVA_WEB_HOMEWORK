package com.duong.ss12.controller.hw03;

import com.duong.ss12.dto.hw03.CreateBusDTO;
import com.duong.ss12.dto.hw03.UpdateBusDTO;
import com.duong.ss12.model.Bus;
import com.duong.ss12.service.hw03.BusService;
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
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/buses")
public class BusController {
    private final BusService busService;
    private final ServletContext servletContext;

    public BusController(BusService busService, ServletContext servletContext) {
        this.busService = busService;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String displayBuses(Model model) {
        List<Bus> buses = busService.getAllBus();
        model.addAttribute("buses", buses);
        return "hw03_list";
    }

    @GetMapping("/add")
    public String displayAddForm(@ModelAttribute("createDTO") CreateBusDTO createBusDTO) {
        return "hw03_add";
    }

    @PostMapping("/add")
    public String handleAddBus(@Valid @ModelAttribute("createDTO") CreateBusDTO dto,
                               BindingResult result,
                               Model model) {

        if (result.hasErrors()) return "hw03_add";

        MultipartFile file = dto.getImageFile();

        try {
            String originalFilename = file.getOriginalFilename();
            String filename = originalFilename != null ? originalFilename.replaceAll("\\s+", "_") : "unknown.jpg";

            String realUploadPath = servletContext.getRealPath("/uploads");
            File realDir = new File(realUploadPath);
            if (!realDir.exists()) realDir.mkdirs();

            String srcUploadPath = "D:/Learn/JavaWeb/theories/ss12/src/main/webapp/uploads";
            File srcDir = new File(srcUploadPath);
            if (!srcDir.exists()) srcDir.mkdirs();

            byte[] bytes = file.getBytes();
            FileCopyUtils.copy(bytes, new File(realDir, filename));
            FileCopyUtils.copy(bytes, new File(srcDir, filename));

            dto.setImage(filename);
            busService.insertBus(dto);
        } catch (IOException e) {
            model.addAttribute("message", "File upload error: " + e.getMessage());
            return "error";
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }

        return "redirect:/buses";
    }

    @GetMapping("/edit/{id}")
    public String displayEditForm(@PathVariable("id") int id, Model model) {
        Optional<Bus> opt = busService.findById(id);
        if (opt.isPresent()) {
            Bus bus = opt.get();
            UpdateBusDTO dto = new UpdateBusDTO(
                    bus.getId(),
                    bus.getLicensePlate(),
                    bus.getBusType(),
                    bus.getRowSeat(),
                    bus.getColSeat(),
                    bus.getImage()
            );
            model.addAttribute("updateDTO", dto);
            return "hw03_edit";
        }
        model.addAttribute("message", "Cannot find bus with ID = " + id);
        return "error";
    }

    @PostMapping("/edit")
    public String handleEdit(@ModelAttribute("updateDTO") @Valid UpdateBusDTO dto,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) return "hw03_edit";

        MultipartFile newImage = dto.getImageFile();
        if (newImage != null && !newImage.isEmpty()) {
            try {
                String originalFilename = newImage.getOriginalFilename();
                String filename = originalFilename != null ? originalFilename.replaceAll("\\s+", "_") : "unknown.jpg";

                String realUploadPath = servletContext.getRealPath("/uploads");
                File realDir = new File(realUploadPath);
                if (!realDir.exists()) realDir.mkdirs();

                String srcUploadPath = "D:/Learn/JavaWeb/theories/ss12/src/main/webapp/uploads";
                File srcDir = new File(srcUploadPath);
                if (!srcDir.exists()) srcDir.mkdirs();

                byte[] bytes = newImage.getBytes();
                FileCopyUtils.copy(bytes, new File(realDir, filename));
                FileCopyUtils.copy(bytes, new File(srcDir, filename));

                dto.setImage(filename);
            } catch (IOException e) {
                model.addAttribute("message", "File upload error: " + e.getMessage());
                return "error";
            }
        }

        boolean updated = busService.updateBus(dto);
        if (!updated) {
            model.addAttribute("message", "Cannot update bus!");
            return "error";
        }

        return "redirect:/buses";
    }

    @PostMapping("/delete/{id}")
    public String deleteBus(@PathVariable("id") int id, Model model) {
        boolean deleted = busService.deleteBus(id);
        if (!deleted) {
            model.addAttribute("message", "Cannot find bus to delete!");
            return "error";
        }
        return "redirect:/buses";
    }
}
