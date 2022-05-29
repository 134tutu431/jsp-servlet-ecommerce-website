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

@WebServlet("/Article")
public class ArticleController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String arid =req.getParameter("arid");
        ArticlesDao articlesDao = new ArticlesDao();
        ArticlesModel articlesModel = articlesDao.getArticlesModelbyid(arid);
        session.setAttribute("aribyid",articlesModel);
        req.getRequestDispatcher("/WebContent/views/Articlept.jsp").forward(req, resp);
    }
}
