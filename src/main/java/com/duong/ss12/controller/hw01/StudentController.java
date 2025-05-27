package com.duong.ss12.controller.hw01;

import com.duong.ss12.dto.hw01.CreateStudentDTO;
import com.duong.ss12.dto.hw01.UpdateStudentDTO;
import com.duong.ss12.model.Student;
import com.duong.ss12.service.hw01.StudentService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String listStudent (Model model){
        List<Student> students = studentService.getAll();

        model.addAttribute("students", students);
        return "hw01_list";
    }

    @GetMapping("/add")
    public String addForm (@ModelAttribute("createDTO")CreateStudentDTO createStudentDTO){
        return "hw01_add";
    }

    @PostMapping("/add")
    public String handleAdd (@Valid @ModelAttribute("createDTO") CreateStudentDTO createStudentDTO, BindingResult result, Model model){
        if(result.hasErrors()) return "hw01_add";

        if(!studentService.insertStudent(createStudentDTO)) {
            model.addAttribute("message","hw01 - insert error");
            return "error";
        }
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editForm (@PathVariable("id") int id, @ModelAttribute("updateDTO") UpdateStudentDTO updateStudentDTO, Model model){
        Optional<Student> opt = studentService.findById(id);
        if(opt.isEmpty()){
           model.addAttribute("message","cannot find student to edit!");
            return "error";
        }
        Student student = opt.get();
        updateStudentDTO.setId(student.getId());
        updateStudentDTO.setEmail(student.getEmail());
        updateStudentDTO.setName(student.getName());
        updateStudentDTO.setDob(student.getDob());

        return "hw01_edit";
    }

    @PostMapping("/edit")
    public String handleUpdate (@Valid @ModelAttribute("updateDTO") UpdateStudentDTO updateStudentDTO, BindingResult result){
        if(result.hasErrors()) return "hw01_edit";

        studentService.updateStudent(updateStudentDTO);
        return "redirect:/students";
    }

    @PostMapping("/delete/{id}")
    public String handleDelete (@PathVariable("id") int id, Model model){
        if(studentService.deleteStudent(id)) return "redirect:/students";
        model.addAttribute("message", "cannot find student to delete!");
        return "error";
    }
}
