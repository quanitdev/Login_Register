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
import quan.dev.data.dao.DatabaseDao;
import quan.dev.data.dao.UserDao;
import quan.dev.data.model.User;
import quan.dev.data.impl.UserImpl;

/**
 *
 * @author Admin
 */
@WebServlet(name = "LoginUserServlet", urlPatterns = {"/LoginUserServlet"})
public class LoginUserServlet extends BaseServlet {

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
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "GET method is not supported ");
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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.checkAccount(email, password);

        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head><title>Đăng nhập</title></head>");
        out.println("<body>");

        if (user != null) {
            out.println("<h2>Đăng nhập thành công!</h2>");
            out.println("<p>Trang web sẽ chuyển hướng sau vài giây...</p>");

            out.println("<script>");
            out.println("setTimeout(function() { window.location.href = 'UserListServlet'; }, 3000);");
            out.println("</script>");
        } else {
            out.println("<h2>Đăng nhập thất bại!</h2>");
            out.println("<p>Email hoặc mật khẩu không đúng.</p>");
            out.println("<p><a href='login.html'>Thử lại</a></p>");
        }

        out.println("</body>");
        out.println("</html>");
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
}
