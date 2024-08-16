package com.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = (int) request.getSession().getAttribute("userId");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departure_date");
        String returnDate = request.getParameter("return_date");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/travel", "mysql_user", "mysql_password");
            String query = "INSERT INTO Bookings (user_id, destination, departure_date, return_date) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, userId);
            stmt.setString(2, destination);
            stmt.setDate(3, java.sql.Date.valueOf(departureDate));
            stmt.setDate(4, java.sql.Date.valueOf(returnDate));
            stmt.executeUpdate();

            response.sendRedirect("confirmation.jsp");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("booking.jsp?error=Internal%20error");
        }
    }
}
