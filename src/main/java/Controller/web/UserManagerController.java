package Controller.web;

import Dao.ProductsDao;
import Dao.UserDao;
import Model.ProductsModel;
import Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Usermanager")
public class UserManagerController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDao userDao = new UserDao();
        int total = userDao.getTotalUsers();
        List<UserModel> list = userDao.getAllUserModels();
        req.setAttribute("total",total);
        req.setAttribute("listuser",list);
        req.getRequestDispatcher("/WebContent/views/User_manager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String search = req.getParameter("searchuser");
        UserDao userDao = new UserDao();
        int total = userDao.getTotalUsers();
        List<UserModel> list = userDao.getAllUserModelsbysearch(search);
        req.setAttribute("total",total);
        session.setAttribute("listuser",list);
        req.getRequestDispatcher("/WebContent/views/User_manager.jsp").forward(req, resp);
    }
}
