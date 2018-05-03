package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;


import java.util.List;


public interface GithuberDAO {
    List<Githuber> getGithubers();

    Githuber getGithuber(String login);

    void saveGithuber(Githuber githuber);
}
