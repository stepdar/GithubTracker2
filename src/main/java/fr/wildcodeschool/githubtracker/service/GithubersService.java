package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.*;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class GithubersService  {


    //private @InMemory GithuberDAO listDao;


    private GithuberDAO listDao2;

   /* @Inject
    public GithubersService(@InMemory GithuberDAO listDao)
    {
        this.listDao = listDao;
    }*/
    @Inject
    public GithubersService(@InDatabase GithuberDAO listDao2){
        this.listDao2 = listDao2;
    }

   /* public List<Githuber> getAllGithubers(){
        return listDao.getGithubers();
    }*/
   public List<Githuber> getAllGithubers(){
       return listDao2.getGithubers();
   }

    public Githuber getGithuber(String login){
    List<Githuber> listGithubers=listDao2.getGithubers();//listDao.getGithuber
        Githuber githuber = listGithubers.stream()
                .filter(x -> login.equals(x.getLogin()))
                .findAny()
                .orElse(null);
        return githuber;
    }

    public void track(String login){
       Githuber githu = getGithuber(login);
       if(githu != null){
           listDao2.saveGithuber(githu);
       }
    }

    public void untrack(String login){
        Githuber githu = getGithuber(login);
        if(githu != null){
            listDao2.removeGithuber(login);
        }
    }
}
