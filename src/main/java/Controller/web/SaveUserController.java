package Controller.web;

import Dao.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SaveUser")
public class SaveUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WebContent/views/User_manager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String userid = req.getParameter("id");
        String role = req.getParameter("role");
        UserDao userDao = new UserDao();
        try {
            userDao.updateUser(userid,role);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("Usermanager");
    }
}
