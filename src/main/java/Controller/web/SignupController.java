package Controller.web;

import Dao.UserDao;
import Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Signup")
public class SignupController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public SignupController(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        if (action == null) {
            req.getRequestDispatcher("/WebContent/views/Signup.jsp").forward(req, resp);
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String name = req.getParameter("name").trim();
        String phone = req.getParameter("phone") ;
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        String confirm_pass =req.getParameter("password-confirm");
        UserDao userDao = new UserDao();
        UserModel userModel = new UserModel(email,password,confirm_pass,name,phone);
        if(!password.equals(confirm_pass)){
            req.setAttribute("error", "Please check the pass and confirmpass !!!");
            req.getRequestDispatcher("/WebContent/views/Signup.jsp").forward(req, resp);
        }else{
            if(userDao.addUser(userModel) ){
                session.setAttribute("username",email);
                req.getRequestDispatcher("/WebContent/views/Login.jsp").forward(req, resp);
            }else {
                req.setAttribute("error", "Email has been registered with another account !!!");
                req.getRequestDispatcher("/WebContent/views/Signup.jsp").forward(req, resp);
            }
        }
    }
}
