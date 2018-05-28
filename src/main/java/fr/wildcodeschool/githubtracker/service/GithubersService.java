package fr.wildcodeschool.githubtracker.service;

import fr.wildcodeschool.githubtracker.dao.*;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.List;

@Dependent
public class GithubersService  {

    //code pour quete CDOI?
    //private @InMemory GithuberDAO listDao;

    /* @Inject
       public GithubersService(@InMemory GithuberDAO listDao)
       {
           this.listDao = listDao;
       }*/

    //ligne pour quete JDBC sans annotation
   // private GithuberDAO listDao2;

  //ligne pour quete JDBC
    /*@Inject
    public GithubersService(@InDatabase GithuberDAO listDao2){
        this.listDao2 = listDao2;
    }*/


    //quete CDI?
   /* public List<Githuber> getAllGithubers(){
        return listDao.getGithubers();
    }*/

    @InJpa
    private GithuberDAO listDao2;

    @Inject
    public GithubersService(@InJpa GithuberDAO listDao2){
        this.listDao2 = listDao2;
    }


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

    public void untrack2(Long id){
        Githuber githu = getGithuberID(id);
        if(githu != null){
            listDao2.removeGithuberId(id);
        }
    }

    private Githuber getGithuberID(Long id) {
        List<Githuber> listGithubers=listDao2.getGithubers();//listDao.getGithuber
        Githuber githuber = listGithubers.stream()
                .filter(x -> id==x.getId())
                .findAny()
                .orElse(null);
        return githuber;
    }
}
