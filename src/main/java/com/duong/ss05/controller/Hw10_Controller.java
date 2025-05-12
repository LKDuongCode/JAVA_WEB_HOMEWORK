package com.duong.ss05.controller;

import com.duong.ss05.model.Contact;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw10_Controller", value = "/contacts")
public class Hw10_Controller extends HttpServlet {

    private List<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                req.getRequestDispatcher("/views/hw10_contact_form.jsp").forward(req, resp);
                break;

            case "edit":
                int editId = Integer.parseInt(req.getParameter("id"));
                Contact contactToEdit = contacts.stream().filter(c -> c.getId() == editId).findFirst().orElse(null);
                if (contactToEdit != null) {
                    req.setAttribute("contact", contactToEdit);
                    req.getRequestDispatcher("/views/hw10_contact_form.jsp").forward(req, resp);
                } else {
                    resp.sendRedirect(req.getContextPath() + "/contacts");
                }
                break;

            default:
                req.setAttribute("contacts", contacts);
                req.getRequestDispatcher("/views/hw10_contacts.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if ("create".equals(action)) {
            String firstName = req.getParameter("firstName");
            String lastName = req.getParameter("lastName");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone");

            Contact newContact = new Contact(nextId++, firstName, lastName, email, phone);
            contacts.add(newContact);

            resp.sendRedirect(req.getContextPath() + "/contacts");

        } else if ("update".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            for (Contact contact : contacts) {
                if (contact.getId() == id) {
                    contact.setFirstName(req.getParameter("firstName"));
                    contact.setLastName(req.getParameter("lastName"));
                    contact.setEmail(req.getParameter("email"));
                    contact.setPhone(req.getParameter("phone"));
                    break;
                }
            }
            resp.sendRedirect(req.getContextPath() + "/contacts");

        } else if ("delete".equals(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            contacts.removeIf(c -> c.getId() == id);
            resp.sendRedirect(req.getContextPath() + "/contacts");
        }
    }
}
