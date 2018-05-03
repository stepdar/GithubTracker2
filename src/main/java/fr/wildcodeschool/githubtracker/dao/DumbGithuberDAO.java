package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.enterprise.context.Dependent;
import java.util.ArrayList;
import java.util.List;

@Dependent
public class DumbGithuberDAO implements GithuberDAO {

   private List<Githuber> giters;



    public List<Githuber> getGithubers() {
        giters = new ArrayList<Githuber>();
        giters.add(new Githuber("darracq", "stephanedar@yahoo.fr", "stepdar", 1, "https://avatars.githubusercontent.com/stepdar?s=56"));
        giters.add(new Githuber("Sahli", "christellsahli@gmail.com", "christellsahli", 2, "http://essai1.fr"));
        giters.add(new Githuber("Brureau", "backtopa@gmail.com", "Gregbee", 3, "http://essai2.fr"));
        giters.add(new Githuber("Bentejac", "maxime.bentejac@gmail.com", "mbentejac", 4, "http://essai3.fr"));
        giters.add(new Githuber("Diague", "diaguelucile@gmail.com", "Lucilediague", 5, "http://essai3.fr"));

        return giters;
    }

    public Githuber getGithuber(String login) {

        Githuber result = giters.stream()
                .filter(x->login.equals(x.getLogin()))
                .findAny()
                .orElse(null);
        return result;
    }

    @Override
    public void saveGithuber(Githuber githuber) {
        throw new UnsupportedOperationException();
    }
}
