package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.GithubUtils;
import fr.wildcodeschool.githubtracker.dao.GithuberDAO;
import fr.wildcodeschool.githubtracker.dao.InMemory;
import fr.wildcodeschool.githubtracker.dao.MemoryGithuberDAO;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class GithubersService  {


    private @InMemory GithuberDAO listDao;

    @Inject
    public GithubersService(@InMemory GithuberDAO listDao)
    {
        this.listDao = listDao;
    }

    public List<Githuber> getAllGithubers(){
        return listDao.getGithubers();
    }

    public Githuber getGithuber(String login){
    List<Githuber> listGithubers=listDao.getGithubers();
        Githuber githuber = listGithubers.stream()
                .filter(x -> login.equals(x.getLogin()))
                .findAny()
                .orElse(null);
        return githuber;
    }

    public void track(String login){
       // TODO
    }
}
