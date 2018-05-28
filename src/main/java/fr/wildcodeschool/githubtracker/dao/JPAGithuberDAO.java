package fr.wildcodeschool.githubtracker.dao;

import fr.wildcodeschool.githubtracker.model.Githuber;


import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@InJpa
public class JPAGithuberDAO implements GithuberDAO{

    @Inject
    GithubUtils utils;

    @PersistenceContext(unitName = "MyAppUnit")
    private EntityManager em;

    @Override
    public List<Githuber> getGithubers() {
        Query query = em.createQuery("SELECT m from Githuber as m");
        List<Githuber> l = query.getResultList();
        return query.getResultList();
    }

    @Override
    public Githuber getGithuber(String login) {

        return null;
    }

    @Override
    public void saveGithuber (Githuber githuber){

        saveDetached(githuber);


    }

    @Override
    public void removeGithuber(String login) {

    }

    @Override
    @Transactional
    public void removeGithuberId(long id) {
        Githuber githuber = em.find(Githuber.class, id);

        em.remove(githuber);
        //em.getTransaction().commit();
    }

    public Githuber saveDetached(final Githuber entity) {
        if(entity.isNew()) {
            em.persist(entity);
            return entity;
        }
        else {
            return em.merge(entity);
        }
    }
}
