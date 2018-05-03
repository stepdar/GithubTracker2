package fr.wildcodeschool.githubtracker.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.io.IOException;
import java.net.URL;

@Dependent
public class GithubUtils {

    @Inject
    private ObjectMapper mapper;

    public Githuber parseGithuber(String login)
    {
        Githuber oneGithuber = null;
        try {
            oneGithuber=mapper.readValue(new URL("https://api.github.com/users/"+login), Githuber.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(oneGithuber!=null){return oneGithuber;}
        else{return null;}
    }
}
