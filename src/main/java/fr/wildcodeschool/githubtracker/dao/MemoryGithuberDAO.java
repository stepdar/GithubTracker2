package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
@InMemory
public class MemoryGithuberDAO implements GithuberDAO  {

    @Inject
   private GithubUtils util;

    private List<Githuber> listgithubers;

    private Map<String,Githuber> mapGithubers = new HashMap<String,Githuber>();

    @Override
    public List<Githuber> getGithubers() {
        listgithubers=new ArrayList<>();
            for(Map.Entry<String,Githuber> entry : mapGithubers.entrySet()){
                listgithubers.add(entry.getValue());
            }

        return listgithubers;
    }

    @Override
    public Githuber getGithuber(String login) {

            for(Map.Entry<String,Githuber> git: mapGithubers.entrySet()){
                if(git.getKey().equals(login)){
                    return git.getValue();
                }
            }

        return null;
    }

    @Override
    public void saveGithuber(Githuber githuber) {
        if(githuber!=null) {
            mapGithubers.put(githuber.getLogin(),githuber );
        }
    }



    @PostConstruct
    private void getMemoryGithubers(){
        saveGithuber(util.parseGithuber("stepdar"));
        saveGithuber(util.parseGithuber("christellsahli"));
        saveGithuber(util.parseGithuber("Gregbee"));
        saveGithuber(util.parseGithuber("mbentejac"));
        saveGithuber(util.parseGithuber("Lucilediague"));
    }
}
