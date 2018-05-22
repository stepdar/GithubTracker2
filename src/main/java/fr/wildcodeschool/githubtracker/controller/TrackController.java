package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.dao.GithubUtils;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InDatabase;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class TrackController {

    @Inject
    GithubUtils utils;

    @Inject
    @InDatabase
    GithuberDAO memoryList;

    @Inject
    private GithubersService ghs;

    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String track(){

        if(utils.parseGithuber(login)!=null) {
            memoryList.saveGithuber(utils.parseGithuber(login));

            return "/faces/githubers.jsf?faces-redirect=true";
        }else {
            FacesMessage fm = new FacesMessage("Non-existent Github user: " + login);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return  null;
        }
    }
}
