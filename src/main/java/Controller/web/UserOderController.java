package Controller.web;

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

@WebServlet("/UserOder")
public class UserOderController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oderby =req.getParameter("oderby");
        UserDao userDao = new UserDao();
        int total = userDao.getTotalUsers();
        HttpSession session = req.getSession();
        req.setAttribute("total",total);
        if(oderby.equals("nameasc")){
            List<UserModel> list = userDao.getUserModelsoderbynameasc();
            session.setAttribute("listuser",list);
            req.setAttribute("total",total);
            req.getRequestDispatcher("/WebContent/views/User_manager.jsp").forward(req, resp);
        }else if(oderby.equals("namedesc")){
            List<UserModel> list = userDao.getUserModelsoderbynamedesc();
            session.setAttribute("listuser",list);
            req.setAttribute("total",total);
            req.getRequestDispatcher("/WebContent/views/User_manager.jsp").forward(req, resp);
        }else if(oderby.equals("idasc")){
            List<UserModel> list = userDao.getUserModelsoderbypriceasc();
            session.setAttribute("listuser",list);
            req.setAttribute("total",total);
            req.getRequestDispatcher("/WebContent/views/User_manager.jsp").forward(req, resp);
        }else if(oderby.equals("iddesc")){
            List<UserModel> list = userDao.getUserModelsoderbypricedesc();
            session.setAttribute("listuser",list);
            req.setAttribute("total",total);
            req.getRequestDispatcher("/WebContent/views/User_manager.jsp").forward(req, resp);
        }
    }
}
