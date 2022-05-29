package Controller.web;

import Dao.*;
import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/EditUser")
public class EditUserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id=req.getParameter("userid");
        UserDao userDao = new UserDao();
        RoleDao roleDao = new RoleDao();
        List<RoleModel> list = roleDao.getRoleModels();
        UserModel userModel = userDao.getUserModelbyuserid(id);
        req.setAttribute("user",userModel);
        req.setAttribute("rolelist",list);
        req.getRequestDispatcher("/WebContent/views/Edit_user.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
