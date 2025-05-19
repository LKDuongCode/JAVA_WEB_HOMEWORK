package com.duong.ss10.controller.hw07;

import com.duong.ss10.model.Project;
import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ProjectController {

    @Autowired
    ServletContext servletContext;

    @GetMapping("/hw07")
    public String showForm(Model model, HttpSession session) {
        if (!model.containsAttribute("project")) {
            model.addAttribute("project", new Project());
        }

        List<Project> projectList = (List<Project>) session.getAttribute("projectList");
        if (projectList == null) projectList = new ArrayList<>();
        model.addAttribute("projectList", projectList);

        return "hw07_project_form";
    }

    @PostMapping("/hw07-create")
    public String createProject(@ModelAttribute("project") Project project,
                                @RequestParam("documentFiles") List<MultipartFile> documentFiles,
                                RedirectAttributes redirectAttributes, HttpSession session) {

        String uploadDir = "D:/Learn/JavaWeb/ss10/src/main/webapp/uploads";
        File dir = new File(uploadDir);
        if (!dir.exists() && !dir.mkdirs()) {
            redirectAttributes.addFlashAttribute("errorMessage", "Không thể tạo thư mục để lưu file.");
            return "redirect:/hw07";
        }

        List<String> savedFiles = new ArrayList<>();
        for (MultipartFile file : documentFiles) {
            if (!file.isEmpty()) {
                try {
                    String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
                    file.transferTo(new File(dir, fileName));
                    savedFiles.add(fileName);
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                    redirectAttributes.addFlashAttribute("errorMessage", "Upload file thất bại.");
                    return "redirect:/hw07";
                }
            }
        }

        project.setDocuments(savedFiles);
        List<Project> projectList = (List<Project>) session.getAttribute("projectList");
        if (projectList == null) projectList = new ArrayList<>();

        projectList.add(project);
        session.setAttribute("projectList", projectList);

        redirectAttributes.addFlashAttribute("message", "Dự án đã được tạo.");
        return "redirect:/hw07";
    }

    @GetMapping("/hw07-edit")
    public String editProject(@RequestParam("index") int index, HttpSession session, Model model) {
        List<Project> projectList = (List<Project>) session.getAttribute("projectList");
        if (projectList != null && index >= 0 && index < projectList.size()) {
            model.addAttribute("project", projectList.get(index));
            model.addAttribute("editIndex", index);
        }
        model.addAttribute("projectList", projectList);
        return "hw07_project_form";
    }

    @PostMapping("/hw07-update")
    public String updateProject(@ModelAttribute("project") Project project,
                                @RequestParam("editIndex") int index,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {

        List<Project> projectList = (List<Project>) session.getAttribute("projectList");
        if (projectList != null && index >= 0 && index < projectList.size()) {
            projectList.set(index, project);
            session.setAttribute("projectList", projectList);
            redirectAttributes.addFlashAttribute("message", "Dự án đã được cập nhật.");
        }

        return "redirect:/hw07";
    }

    @GetMapping("/hw07-delete")
    public String deleteProject(@RequestParam("index") int index,
                                HttpSession session,
                                RedirectAttributes redirectAttributes) {

        List<Project> projectList = (List<Project>) session.getAttribute("projectList");
        if (projectList != null && index >= 0 && index < projectList.size()) {
            projectList.remove(index);
            redirectAttributes.addFlashAttribute("message", "Dự án đã bị xoá.");
        }

        return "redirect:/hw07";
    }
}