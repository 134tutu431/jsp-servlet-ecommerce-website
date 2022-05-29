package Controller.web;

import Dao.ChitietDao;
import Dao.CommentDao;
import Model.ChitietModel;
import Model.CommentModel;
import Model.UserModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@WebServlet("/Detail")
public class DetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        CommentDao commentDao = new CommentDao();
        String id = req.getParameter("proid");
        List<CommentModel> commentModelList = commentDao.commentModelsbyproid(id);
        req.setAttribute("listcomment",commentModelList);
        ChitietDao chitietDao = new ChitietDao();
        ChitietModel chitiet = chitietDao.getChitietModelsbyid(id);
        req.setAttribute("productid",id);
        req.setAttribute("chi",chitiet);
        req.getRequestDispatcher("/WebContent/views/Product.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String proid = req.getParameter("productid");
        String comment = req.getParameter("comment").trim();
        String email = req.getParameter("email").trim();
        String name = req.getParameter("name"). trim();
        String date = String.valueOf(LocalDate.now());
        CommentDao commentDao = new CommentDao();
        try {
            commentDao.addComment(comment,name,proid,date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("Detail?proid="+proid);
    }
}
