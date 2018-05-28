package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.*;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "TrackServlet", urlPatterns = "/track")
public class TrackServlet extends HttpServlet {
   //quete jdbc
   /* @Inject
   @InDatabase
   GithuberDAO dao;*/

   @Inject
   @InJpa
   GithuberDAO daoJpa;

   @Inject
   GithubUtils utils;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String login = request.getParameter("login");

          daoJpa.saveGithuber(utils.parseGithuber(login));
            response.sendRedirect("/GithubTracker2/githubers?login="+login);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response );
    }
}
