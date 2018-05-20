package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.DumbGithuberDAO;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/githubers")
public class GithubersServlet extends HttpServlet {
    @Inject
    private GithubersService ghs ;

    @Override
    public void init() throws ServletException {
       //ghs= new GithubersService(new DumbGithuberDAO());partie 2
       //listDao = new DumbGithuberDAO(); partie 1
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       /*String login = req.getParameter("login");
        if(login!=null){
            ghs.track(login);
        }*/

        req.setAttribute("listGithuber",ghs.getAllGithubers());
        req.getRequestDispatcher("/githubers.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
