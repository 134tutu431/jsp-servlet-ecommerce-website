package Controller.web;

import Dao.ProductsDao;
import Dao.UserDao;
import Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Userinfor")
public class UserInforController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WebContent/views/User_infor.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        UserModel userModel = (UserModel) session.getAttribute("user");
        int id = userModel.getId();
        String name= req.getParameter("name");
        String phone= req.getParameter("phone");
        String email= req.getParameter("email");
        String password= req.getParameter("password");
        String confirmpass= req.getParameter("password-confirm");
        UserDao userDao = new UserDao();
        try {
            userDao.updateUserbyid(id,email,password,confirmpass,name,phone);
        } catch (Exception e) {
            e.printStackTrace();
        }
        req.setAttribute("notify","Your information has been changed !!!");
        req.getRequestDispatcher("/WebContent/views/User_infor.jsp").forward(req,resp);
    }
}
