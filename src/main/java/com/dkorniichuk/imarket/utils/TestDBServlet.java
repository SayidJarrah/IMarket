package com.dkorniichuk.imarket.utils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/testDbServlet")
public class TestDBServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String user = "root";
        String password = "1234";
        String jdbcURL = "jdbc:mysql://localhost:3306/imarket?useSSL=false&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";

        try {
            PrintWriter out = resp.getWriter();
            out.println("Connecting to database : " + jdbcURL);
            Class.forName(driver);
            Connection myConn = DriverManager.getConnection(jdbcURL, user, password);
            out.println("Success!");
            myConn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
