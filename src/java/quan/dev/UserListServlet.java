/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package quan.dev;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import quan.dev.data.dao.DatabaseDao;
import quan.dev.data.dao.UserDao;
import quan.dev.data.model.User;

/**
 *
 * @author Admin
 */
@WebServlet(name = "UserListServlet", urlPatterns = {"/UserListServlet"})
public class UserListServlet extends BaseServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        List<User> allUsers = userDao.findAll();

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Danh sách người dùng</title></head>");
        out.println("<body>");
        out.println("<h2>Danh sách người dùng</h2>");
        out.println("<table border='1' cellpadding='10' cellspacing='0'>");
        out.println("<tr>");
        out.println("<th>ID</th>");
        out.println("<th>Gmaill</th>");
        out.println("<th>Mật khẩu</th>");
        out.println("<th>Vai trò</th>");
        out.println("</tr>");
        
        
        for (User user : allUsers) {
            out.println("<tr>");
            out.println("<td>" + user.getId() + "</td>");
            out.println("<td>" + user.getEmail() + "</td>");
            out.println("<td>" + user.getPassword() + "</td>");
            out.println("<td>" + user.getRole() + "</td>");
            out.println(String.format("<td><a href=\"EditUserServlet?id=%d\">Edit</a></td>", user.getId()));
            out.println(String.format("<td><a href=\"DeleteUserServlet?id=%d\">Delete</a></td>", user.getId()));
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
