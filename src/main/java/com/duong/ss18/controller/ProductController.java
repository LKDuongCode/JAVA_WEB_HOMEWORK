package com.duong.ss18.controller;

import com.duong.ss18.dto.product.CreateProductDTO;
import com.duong.ss18.dto.product.UpdateProductDTO;
import com.duong.ss18.entity.Product;
import com.duong.ss18.service.product.ProductService;
import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    private ServletContext servletContext;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public String listProducts(@RequestParam(name = "page", defaultValue = "1") int page,
                               @RequestParam(name = "size", defaultValue = "5") int size,
                               Model model) {
        List<Product> products = productService.getAllProductsWithPagination(page, size);
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        return "admin_products_management";
    }



    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productDTO", new CreateProductDTO());
        return "product_form";
    }


    @PostMapping("/create")
    public String handleCreate(@ModelAttribute("productDTO") CreateProductDTO dto,
                               RedirectAttributes redirectAttributes,
                               Model model) {
        MultipartFile file = dto.getImageFile();

        try {
            String fileName = saveFile(file);
            Product product = new Product();
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setQuantity(dto.getQuantity());
            product.setImage(fileName);

            productService.addProduct(product);
            redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
            return "redirect:/admin/products";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi upload ảnh: " + e.getMessage());
            return "error";
        }
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Product> optionalProduct = productService.getProductById(id);
        if (optionalProduct.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Không tìm thấy sản phẩm.");
            return "redirect:/admin/products";
        }

        Product product = optionalProduct.get();
        UpdateProductDTO dto = new UpdateProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getQuantity(),
                null
        );

        model.addAttribute("productDTO", dto);
        model.addAttribute("oldImage", product.getImage());

        return "product_edit_form";
    }


    @PostMapping("/edit")
    public String handleEdit(@ModelAttribute("productDTO") UpdateProductDTO dto,
                             @RequestParam("oldImage") String oldImage,
                             RedirectAttributes redirectAttributes,
                             Model model) {
        try {
            String fileName = oldImage;
            MultipartFile newFile = dto.getImageFile();

            if (newFile != null && !newFile.isEmpty()) {
                fileName = saveFile(newFile);
            }

            Product product = new Product();
            product.setId(dto.getId());
            product.setName(dto.getName());
            product.setDescription(dto.getDescription());
            product.setPrice(dto.getPrice());
            product.setQuantity(dto.getQuantity());
            product.setImage(fileName);

            productService.updateProduct(product);
            redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
            return "redirect:/admin/products";
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("message", "Lỗi khi cập nhật sản phẩm: " + e.getMessage());
            return "error";
        }
    }


    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable ("id") int id, RedirectAttributes redirectAttributes) {
        productService.deleteProduct(id);
        redirectAttributes.addFlashAttribute("message", "Đã xoá sản phẩm.");
        return "redirect:/admin/products";
    }


    private String saveFile(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) return null;

        String originalFilename = file.getOriginalFilename();
        String filename = (originalFilename != null) ? originalFilename.replaceAll("\\s+", "_") : "unknown.jpg";


        String realUploadPath = servletContext.getRealPath("/uploads");
        File realDir = new File(realUploadPath);
        if (!realDir.exists()) realDir.mkdirs();

        Path srcUploadPath = Paths.get("D:/Learn/JavaWeb/theories/ss18/src/main/webapp/uploads");
        File srcDir = srcUploadPath.toFile();
        if (!srcDir.exists()) srcDir.mkdirs();

        byte[] bytes = file.getBytes();
        FileCopyUtils.copy(bytes, new File(realDir, filename));
        FileCopyUtils.copy(bytes, new File(srcDir, filename));

        return filename;
    }
}
