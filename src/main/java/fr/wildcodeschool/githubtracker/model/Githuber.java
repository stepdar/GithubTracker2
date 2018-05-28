package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ejb.Stateful;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="githuber")
public class Githuber implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="github_id")
    private long githubId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "login")
    private String login;

    @Column(name = "avatar_url")
    private String avatar_url;


    public Githuber() {
    }

    @JsonCreator
    public Githuber(@JsonProperty("name") String name, @JsonProperty("email") String email,
                    @JsonProperty("login")String login,@JsonProperty("id") long id, @JsonProperty("avatar_url") String avatar_url) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.githubId = id;
        this.avatar_url = avatar_url;
    }

    public long getGithubId() {
        return githubId;
    }

    public void setGithubId(long githubId) {
        this.githubId = githubId;
    }

    @Transient
    public boolean isNew() {
        return id == null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
