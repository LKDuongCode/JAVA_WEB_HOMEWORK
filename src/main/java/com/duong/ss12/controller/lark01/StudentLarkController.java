package com.duong.ss12.controller.lark01;

import com.duong.ss12.dto.lark01.CreateStudentLarkDTO;
import com.duong.ss12.dto.lark01.UpdateStudentLarkDTO;
import com.duong.ss12.model.StudentLark;
import com.duong.ss12.service.lark01.StudentLarkService;
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
@RequestMapping("/students-lark")
public class StudentLarkController {

    private final StudentLarkService studentService;
    private final ServletContext servletContext;

    public StudentLarkController(StudentLarkService studentService, ServletContext servletContext) {
        this.studentService = studentService;
        this.servletContext = servletContext;
    }


    @GetMapping("/add")
    public String showAddForm(@ModelAttribute("createDTO") CreateStudentLarkDTO createDTO) {
        return "lark01_add";
    }

    @PostMapping("/add")
    public String handleAdd(@Valid @ModelAttribute("createDTO") CreateStudentLarkDTO dto,
                            BindingResult result, Model model) {

        if (result.hasErrors()) return "lark01_add";

        MultipartFile file = dto.getAvatarFile();
        if (file != null && !file.isEmpty()) {
            try {
                String filename = file.getOriginalFilename().replaceAll("\\s+", "_");

                String realPath = servletContext.getRealPath("/uploads");
                File realDir = new File(realPath);
                if (!realDir.exists()) realDir.mkdirs();

                String srcPath = "D:/Learn/JavaWeb/theories/ss12/src/main/webapp/uploads";
                File srcDir = new File(srcPath);
                if (!srcDir.exists()) srcDir.mkdirs();

                byte[] bytes = file.getBytes();
                FileCopyUtils.copy(bytes, new File(realDir, filename));
                FileCopyUtils.copy(bytes, new File(srcDir, filename));

                dto.setAvatar(filename);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Avatar upload failed: " + e.getMessage());
                return "error";
            }
        }

        boolean success = studentService.insertStudent(dto);
        if (!success) {
            model.addAttribute("message", "Insert student failed!");
            return "error";
        }

        return "redirect:/students-lark";
    }



    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Optional<StudentLark> opt = studentService.findById(id);
        if (opt.isPresent()) {
            StudentLark s = opt.get();
            UpdateStudentLarkDTO dto = new UpdateStudentLarkDTO(
                    s.getId(), s.getName(), s.getEmail(), s.getPhone(),
                    s.getSex(), s.getBod(), s.getAvatar(), null, s.getStatus()
            );
            model.addAttribute("updateDTO", dto);
            return "lark01_edit";
        }
        model.addAttribute("message", "Student not found!");
        return "error";
    }

    @PostMapping("/edit")
    public String handleEdit(@Valid @ModelAttribute("updateDTO") UpdateStudentLarkDTO dto,
                             BindingResult result, Model model) {

        if (result.hasErrors()) return "lark01_edit";

        MultipartFile newFile = dto.getAvatarFile();
        if (newFile != null && !newFile.isEmpty()) {
            try {
                String filename = newFile.getOriginalFilename().replaceAll("\\s+", "_");

                String realPath = servletContext.getRealPath("/uploads");
                File realDir = new File(realPath);
                if (!realDir.exists()) realDir.mkdirs();

                String srcPath = "D:/Learn/JavaWeb/theories/ss12/src/main/webapp/uploads";
                File srcDir = new File(srcPath);
                if (!srcDir.exists()) srcDir.mkdirs();

                byte[] bytes = newFile.getBytes();
                FileCopyUtils.copy(bytes, new File(realDir, filename));
                FileCopyUtils.copy(bytes, new File(srcDir, filename));

                dto.setAvatar(filename);
            } catch (IOException e) {
                e.printStackTrace();
                model.addAttribute("message", "Avatar upload failed: " + e.getMessage());
                return "error";
            }
        }

        boolean updated = studentService.updateStudent(dto);
        if (!updated) {
            model.addAttribute("message", "Update failed!");
            return "error";
        }

        return "redirect:/students-lark";
    }

    // ------------------ Hiển thị danh sách ------------------
    @GetMapping
    public String showStudentList(Model model) {
        List<StudentLark> students = studentService.getAll();
        model.addAttribute("students", students);
        return "lark01_list";
    }

    // ------------------ Xoá sinh viên ------------------
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") String id, Model model) {
        boolean deleted = studentService.deleteStudent(id);
        if (!deleted) {
            model.addAttribute("message", "Cannot delete student with ID: " + id);
            return "error";
        }
        return "redirect:/students-lark";
    }

    // ------------------ Tìm kiếm theo tên gần đúng ------------------
    @GetMapping("/search")
    public String searchStudents(@RequestParam("keyword") String keyword, Model model) {
        List<StudentLark> results = studentService.findByNameLike(keyword);
        model.addAttribute("results", results);
        model.addAttribute("keyword", keyword);
        return "lark01_search";
    }

}
