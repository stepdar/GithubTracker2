package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;


import java.util.List;


public interface GithuberDAO {
    List getGithubers();

    Githuber getGithuber(String login);

    void saveGithuber(Githuber githuber);

    void removeGithuber(String login);

    void removeGithuberId(long id);
}
