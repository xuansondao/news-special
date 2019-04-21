package controller.admin.api;

import model.News;
import model.User;
import service.INewsService;
import service.IUserService;
import service.impl.NewService;
import service.impl.UserService;
import utils.MapJsonToModelUtil;
import utils.SessionUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/admin/news")
public class NewsApiController extends HttpServlet {

    private INewsService newsService;

    public NewsApiController(){
       this.newsService = new NewService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("application/json");
        News news = MapJsonToModelUtil
                .of(req.getReader())
                .toModel(News.class);
        User user = (User) SessionUtil
                .getSessionUtilIntance()
                .getValue(req,"MODEL");
//        news.setCreatedBy(user.getUserName());

        newsService.createdNews(news);
    }
}
