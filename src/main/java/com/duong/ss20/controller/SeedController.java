package com.duong.ss20.controller;

import com.duong.ss20.dto.CreateSeedDTO;
import com.duong.ss20.dto.SearchSeedDTO;
import com.duong.ss20.dto.UpdateSeedDTO;
import com.duong.ss20.entity.Seed;
import com.duong.ss20.service.SeedService;
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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/seeds")
public class SeedController {
    private final SeedService seedService;
    private final ServletContext servletContext;
    private static final List<String> ALLOWED_EXTENSIONS = List.of("jpg", "jpeg", "png", "gif");
    private static final long MAX_FILE_SIZE_MB = 5;

    public SeedController(SeedService seedService, ServletContext servletContext) {
        this.seedService = seedService;
        this.servletContext = servletContext;
    }

    @GetMapping("/{page}")
    public String showSeeds (@PathVariable("page") int page, Model model){
        int pageSize = 5;

        List<Seed> seeds = seedService.getAll(page,pageSize);
        int totalSeeds = seedService.count();
        int totalPages = (int) Math.ceil((double) totalSeeds/pageSize);

        model.addAttribute("seeds",seeds);
        model.addAttribute("totalPages",totalPages);
        model.addAttribute("curPage",page);
        model.addAttribute("title","SEEDS MANAGER");


        return "seed_list";
    }

    @GetMapping("/add")
    public String showAddForm (Model model){
        model.addAttribute("title","ADD SEED");
        model.addAttribute("createDTO",new CreateSeedDTO());
        return "seed_add";
    }

    @PostMapping("/add")
    public String handleAdd(@Valid @ModelAttribute("createDTO") CreateSeedDTO createSeedDTO,
                            BindingResult result) {
        if (result.hasErrors()) return "seed_add";

        try {
            String filename = saveImage(createSeedDTO.getFile());
            createSeedDTO.setImage(filename);

            if (!seedService.insert(createSeedDTO)) {
                return "seed_add";
            }
        }
        catch (IOException e) {
            result.rejectValue("file", null, "Upload failed: " + e.getMessage());
            return "seed_add";
        }
        catch (Exception e) {
            System.err.println("ERROR " + e.getMessage());
            return "seed_add";
        }

        return "redirect:/seeds/1";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm (@PathVariable("id") int id, Model model){
        Optional<Seed> seedOptional = seedService.findById(id);
        if(seedOptional.isEmpty()) return "seed_list";


        model.addAttribute("updateDTO",parseToUpdateDTO(seedOptional.get()));
        model.addAttribute("title","UPDATE SEED");
        return "seed_edit";
    }


    @PostMapping("/edit")
    public String handleEdit (@Valid @ModelAttribute("updateDTO") UpdateSeedDTO updateSeedDTO, BindingResult result, Model model){
        if(result.hasErrors()) return "seed_edit";
        try {
            if (updateSeedDTO.getFile() != null && !updateSeedDTO.getFile().isEmpty()) {
                String filename = saveImage(updateSeedDTO.getFile());
                updateSeedDTO.setImage(filename);
            }

            if(!seedService.update(updateSeedDTO)) {
                System.err.println("ERROR");
                return "seed_edit";
            }
        }
        catch (IOException e){
            result.rejectValue("file", null, "Upload failed: " + e.getMessage());
            return "seed_edit";
        }
        catch (Exception e){
            System.err.println("ERROR" + e.getMessage());
            return "seed_edit";
        }
        return "redirect:/seeds/1";
    }

    @PostMapping("/delete/{id}")
    private String handleDelete (@PathVariable("id") int id){
        Optional<Seed> seedOptional = seedService.findById(id);
        if(seedOptional.isEmpty()) return "seed_list";

        if(!seedService.delete(seedOptional.get())) return "seed_list";

        return "redirect:/seeds/1";
    }

    @GetMapping("/search")
    public String handleSearch(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "min", required = false, defaultValue = "0") double min,
            @RequestParam(name = "max", required = false, defaultValue = "0") double max,
            Model model
    ) {
        List<Seed> results = seedService.searchByFilter(name, min, max);

        model.addAttribute("seeds", results);
        model.addAttribute("title", "SEARCH RESULT");

        model.addAttribute("name", name);
        model.addAttribute("min", min);
        model.addAttribute("max", max);

        return "seed_list";
    }


    private String saveImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) throw new IOException("File is empty");

        String originalFilename = file.getOriginalFilename();
        String extension = getExtension(originalFilename);

        if (!ALLOWED_EXTENSIONS.contains(extension.toLowerCase())) {
            throw new IOException("Invalid file type: " + extension);
        }
        
        long sizeInMB = file.getSize() / (1024 * 1024);
        if (sizeInMB > MAX_FILE_SIZE_MB) {
            throw new IOException("File too large: " + sizeInMB + "MB (max is " + MAX_FILE_SIZE_MB + "MB)");
        }

        String filename = originalFilename.replaceAll("\\s+", "_");

        String deployUploadPath = servletContext.getRealPath("/uploads");
        new File(deployUploadPath).mkdirs();

        Path srcUploadPath = Paths.get("D:/Learn/JavaWeb/homeworks/ss20/src/main/webapp/uploads");
        new File(srcUploadPath.toString()).mkdirs();

        byte[] bytes = file.getBytes();
        FileCopyUtils.copy(bytes, new File(deployUploadPath, filename));
        FileCopyUtils.copy(bytes, new File(srcUploadPath.toString(), filename));

        return filename;
    }

    private String getExtension(String filename) {
        int dotIndex = filename.lastIndexOf('.');
        if (dotIndex != -1 && dotIndex < filename.length() - 1) {
            return filename.substring(dotIndex + 1);
        }
        return "";
    }

    private UpdateSeedDTO parseToUpdateDTO (Seed seed){
        UpdateSeedDTO updateSeedDTO = new UpdateSeedDTO();
        updateSeedDTO.setId(seed.getId());
        updateSeedDTO.setName(seed.getName());
        updateSeedDTO.setDescription(seed.getDescription());
        updateSeedDTO.setPrice(seed.getPrice());
        updateSeedDTO.setStock(seed.getStock());
        updateSeedDTO.setImage(seed.getImage());
        return updateSeedDTO;
    }

}
