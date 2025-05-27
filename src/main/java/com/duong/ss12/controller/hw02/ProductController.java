package com.duong.ss12.controller.hw02;

import com.duong.ss12.dto.hw02.CreateProductDTO;
import com.duong.ss12.dto.hw02.UpdateProductDTO;
import com.duong.ss12.model.Product;
import com.duong.ss12.service.hw02.ProductService;
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
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;
    private final ServletContext servletContext;

    public ProductController(ProductService productService, ServletContext servletContext) {
        this.productService = productService;
        this.servletContext = servletContext;
    }

    @GetMapping
    public String displayProducts (Model model){
        List<Product> products = productService.getAllProduct();
        model.addAttribute("products",products);
        return "hw02_list";
    }

    @GetMapping("/add")
    public String displayAddForm (@ModelAttribute("createDTO") CreateProductDTO createProductDTO){
        return "hw02_add";
    }

    @PostMapping("/add")
    public String handleAddProduct (@Valid @ModelAttribute("createDTO")CreateProductDTO createProductDTO, BindingResult result, Model model){

        if(result.hasErrors()) return "hw02_add";
        MultipartFile file = createProductDTO.getImage();

        try {
            // lấy tên file
            String originalFilename = file.getOriginalFilename();
            String filename = originalFilename != null ?
                    originalFilename.replaceAll("\\s+","_") :
                    "unknown.jpg";
            
            // lấy đường dẫn deploy
            String realUploadPath = servletContext.getRealPath("/uploads");
            File realDir = new File(realUploadPath);
            if(!realDir.exists()) realDir.mkdirs(); // đoạn này có phải là kiểm tra nêú thư mục đó không tồn tại thì tạo mới không?
            
            // lấy đường dẫn scr
            String scrUploadPath = "D:/Learn/JavaWeb/theories/ss12/src/main/webapp/uploads";
            File scrDir = new File(scrUploadPath);
            if(!scrDir.exists()) scrDir.mkdirs(); // với cả mình thấy mkdir nữa. cái có s cái thì không. mà những method đó là gì thế.

            //đọc file
            byte[] bytes = file.getBytes();
            
            // ghi file vào 2 nơi
            FileCopyUtils.copy(bytes,new File(realDir,filename)); // hàm này để làm gì
            FileCopyUtils.copy(bytes,new File(scrDir,filename));

            // gán filename cho trường file
            createProductDTO.setFilename(filename);
            productService.insertProduct(createProductDTO);

        }
        catch (IOException e){
            e.printStackTrace();
            model.addAttribute("message","file upload error " + e.getMessage());
            return "error";
        }
        catch (Exception e){
            System.err.println("Lỗi bất định " + e.getMessage());
        }

        return "redirect:/products";
    }


    @GetMapping("/edit/{id}")
    public String displayEditForm(@PathVariable("id") int id, Model model) {
        Optional<Product> opt = productService.findById(id);
        if (opt.isPresent()) {
            Product product = opt.get();
            UpdateProductDTO dto = new UpdateProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getQuantity(),
                    product.getImage()
            );
            model.addAttribute("updateDTO", dto);
            return "hw02_edit";
        }
        model.addAttribute("message", "cannot find product with id = " + id);
        return "error";
    }


    @PostMapping("/edit")
    public String handleEdit(@ModelAttribute("updateDTO") @Valid UpdateProductDTO dto,
                             BindingResult result,
                             Model model) {
        if (result.hasErrors()) return "hw02_edit";

        MultipartFile newImage = dto.getImageFile();
        if (newImage != null && !newImage.isEmpty()) {
            try {
                String originalFilename = newImage.getOriginalFilename();
                String filename = originalFilename != null ?
                        originalFilename.replaceAll("\\s+", "_") :
                        "unknown.jpg";

                // real path
                String realUploadPath = servletContext.getRealPath("/uploads");
                File realDir = new File(realUploadPath);
                if (!realDir.exists()) realDir.mkdirs();

                // source path
                String scrUploadPath = "D:/Learn/JavaWeb/theories/ss12/src/main/webapp/uploads";
                File scrDir = new File(scrUploadPath);
                if (!scrDir.exists()) scrDir.mkdirs();

                byte[] bytes = newImage.getBytes();

                // Ghi file mới
                FileCopyUtils.copy(bytes, new File(realDir, filename));
                FileCopyUtils.copy(bytes, new File(scrDir, filename));

                dto.setImage(filename);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "file upload error " + e.getMessage());
                return "error";
            }
        }

        boolean updated = productService.updateProduct(dto);
        if (!updated) {
            model.addAttribute("message", "cannot update product!");
            return "error";
        }

        return "redirect:/products";
    }


    @PostMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model) {
        boolean deleted = productService.deleteProduct(id);
        if (!deleted) {
            model.addAttribute("message", "Cannot find product to delete!");
            return "error";
        }
        return "redirect:/products";
    }

}
