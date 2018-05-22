package fr.wildcodeschool.githubtracker.controller;

import fr.wildcodeschool.githubtracker.model.Githuber;
import fr.wildcodeschool.githubtracker.service.GithubersService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@ApplicationScoped
@Named("githubersController")
public class GithubersController {

    private List<Githuber> allGithubers;

    @Inject
    private GithubersService ghs;

    /*public void getAllGithubers(){
        ghs.getAllGithubers();
    }*/

    public List<Githuber> getAllGithubers() {
        return ghs.getAllGithubers();
    }

    public void  untrack(long githuberId){
        ghs.untrack2(githuberId);
    }
}
