package com.duong.ss04;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Hw09_FilmServlet", value = "/hw09")
public class Hw09_FilmServlet extends HttpServlet {

    private List<Hw09_Seat> seats;

    @Override
    public void init() {
        seats = new ArrayList<>();
        String[] rows = {"A", "B", "C", "D", "E"};
        for (String row : rows) {
            for (int i = 1; i <= 10; i++) {
                boolean booked = row.equals("C") && (i >= 5 && i <= 8); // C5-C8 đã đặt
                seats.add(new Hw09_Seat(row + i, row + i, 50000, booked));
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("seats", seats);
        req.getRequestDispatcher("hw09_booking_film_ticket.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String[] selectedSeats = req.getParameterValues("selectedSeats");
        double total = 0;

        if (selectedSeats != null) {
            for (String code : selectedSeats) {
                for (Hw09_Seat seat : seats) {
                    if (seat.getCode().equals(code)) {
                        total += seat.getPrice();
                    }
                }
            }
        }

        req.setAttribute("seats", seats);
        req.setAttribute("total", total);
        req.setAttribute("hasSelection", selectedSeats != null && selectedSeats.length > 0);
        req.getRequestDispatcher("hw09_booking_film_ticket.jsp").forward(req, resp);
    }
}
