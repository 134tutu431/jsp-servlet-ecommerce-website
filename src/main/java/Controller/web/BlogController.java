package Controller.web;

import Dao.ArticlesDao;
import Model.ArticlesModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/Blog")
public class BlogController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ArticlesDao articlesDao = new ArticlesDao();
        List<ArticlesModel> list  = articlesDao.getArticlesModels();
        session.setAttribute("articles",list);
        req.getRequestDispatcher("/WebContent/views/Blog.jsp").forward(req,resp);
    }
}
