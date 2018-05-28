package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UntrackServlet", urlPatterns = "/untrack")
public class UntrackServlet extends HttpServlet {

    @Inject
    private GithubersService ghs ;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("idGit");
        Long idGithuber = Long.parseLong(id);
        ghs.untrack2(idGithuber);
        request.setAttribute("listGithuber",ghs.getAllGithubers());
        request.getRequestDispatcher("/githubers.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
