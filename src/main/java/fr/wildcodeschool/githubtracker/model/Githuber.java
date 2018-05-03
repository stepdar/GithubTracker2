package fr.wildcodeschool.githubtracker.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class Githuber {
    private String name;
    private String email;
    private String login;
    private  int id;
    private String avatar_url;

    public Githuber() {
    }

    @JsonCreator
    public Githuber(@JsonProperty("name") String name, @JsonProperty("email") String email,
                    @JsonProperty("login")String login,@JsonProperty("id") int id, @JsonProperty("avatar_url") String avatar_url) {
        this.name = name;
        this.email = email;
        this.login = login;
        this.id = id;
        this.avatar_url = avatar_url;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }
}
