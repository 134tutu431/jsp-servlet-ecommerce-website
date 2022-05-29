package Controller.web;

import Dao.UserDao;
import Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/Login")
public class AccountController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {        HttpSession session = req.getSession();
        String action = req.getParameter("action");
        Cookie arr[] = req.getCookies();
        if (action == null) {
            if (arr != null){
                for (Cookie cookie : arr){
                    if (cookie.getName().equals("emailU")){
                        req.setAttribute("email",cookie.getValue());
                    }
                    if (cookie.getName().equals("passU")){
                        req.setAttribute("password",cookie.getValue());
                    }
                }
            }else if (arr == null){
                session.removeAttribute("user");
                resp.sendRedirect("Login");
            }
            req.getRequestDispatcher("/WebContent/views/Login.jsp").forward(req, resp);
        } else {
            if (action.equalsIgnoreCase("logout")) {
                session.removeAttribute("username");
                session.removeAttribute("user");
                resp.sendRedirect("Login");
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String email = req.getParameter("email").trim();
        String password = req.getParameter("password").trim();
        UserDao userDao = new UserDao();
        UserModel userModel = userDao.Login(email,password);
        if(userModel != null ){
            session.setAttribute("username",email);
            session.setAttribute("user",userModel);
            Cookie m = new Cookie("emailU",email);
            Cookie p = new Cookie("passU",password);
            m.setMaxAge(15*60);
            p.setMaxAge(15*60);
            resp.addCookie(m);
            resp.addCookie(p);
            resp.sendRedirect("Home");
        }else {
            req.setAttribute("error", "Invalid Email or Password!!!");
            req.getRequestDispatcher("/WebContent/views/Login.jsp").forward(req, resp);
        }
    }



}
