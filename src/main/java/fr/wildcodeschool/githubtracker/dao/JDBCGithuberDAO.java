package fr.wildcodeschool.githubtracker.dao;


import fr.wildcodeschool.githubtracker.model.Githuber;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

import static java.sql.DriverManager.getConnection;

import java.sql.*;

import static java.sql.ResultSet.CONCUR_READ_ONLY;
import static java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * class permettant de se connecter à la BDD et de requeter via jdbc simple connection (code mort) et datasource code actif
 */
@ApplicationScoped
@InDatabase
public class JDBCGithuberDAO implements GithuberDAO {
    private static final Logger LOGGER = Logger.getLogger( JDBCGithuberDAO.class.getName() );
    private final String  INSERT_GITHUBER = "INSERT INTO githuber (id, github_id, name, login, url, email, bio, location, avatar_url) "
            + " VALUES (null, ?, ?, ? ,null, ? , null , null , ?)";


    @Resource(name = "jdbc/TestPool")
   private DataSource githubertackerSource;

    //private static pour jdbc simple

    /*private static Connection conn;
    private static final String URL = "jdbc:mysql://localhost:3306/githubtracker?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    private static final String USER = "root";

    private static final String PASS = "SD1966";*/
    int count ;
    /**

     * Get a connection to database pour jdbc simple

     * @return Connection object

     */

   /* public static Connection getConnection() throws ClassNotFoundException

    {
        try {
            conn = java.sql.DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }*/

    @Override
    public List<Githuber> getGithubers() {
        List<Githuber> listGithuber=new ArrayList<>();
            try {
                //jdbc simple
               //Statement stmt = JDBCGithuberDAO.getConnection().createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
                //jdbc datasource
                Statement stmt = githubertackerSource.getConnection().createStatement(TYPE_SCROLL_INSENSITIVE, CONCUR_READ_ONLY);
                String sql;
                sql = "SELECT * FROM githuber";
                ResultSet rs = stmt.executeQuery(sql);
                while(rs.next()){
                    //Retrieve by column name
                    long id  = rs.getLong("id");
                    int github_id  = rs.getInt("github_id");
                    String name = rs.getString("name");
                    String login = rs.getString("login");
                    String url = rs.getString("url");
                    String email = rs.getString("email");
                    String bio= rs.getString("bio");
                    String location = rs.getString("location");
                    String avatar_url = rs.getString("avatar_url");

                    listGithuber.add(new Githuber(name,email ,login, github_id, avatar_url ));
                }
                // Clean-up environment
                rs.close();
                stmt.close();
               // conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return listGithuber;
        }





    @Override
    public Githuber getGithuber(String login) {


        return null;
    }

    @Override
    public void saveGithuber(Githuber githuber) {

        try {
                // simple jdbc
           // PreparedStatement stmt = JDBCGithuberDAO.getConnection().prepareStatement("SELECT count(login) AS count_login FROM githuber WHERE login=?");

            //datasource
            PreparedStatement stmt = githubertackerSource.getConnection().prepareStatement("SELECT count(login) AS count_login FROM githuber WHERE login=?");
            stmt.setString(1, githuber.getLogin());
            ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            count = rs.getInt("count_login");
        }
        } catch (SQLException ex) {

            ex.printStackTrace();

        }

        if(count==0) {
            PreparedStatement ordre;

            try {

                //simple jdbc
               // ordre = JDBCGithuberDAO.getConnection().prepareStatement(INSERT_GITHUBER);
                //datasource
                ordre = githubertackerSource.getConnection().prepareStatement(INSERT_GITHUBER);
                //valoriser les paramètres
                ordre.setLong(1, githuber.getId());
                ordre.setString(2, githuber.getName());
                ordre.setString(3, githuber.getLogin());
                ordre.setString(4, githuber.getEmail());
                ordre.setString(5, githuber.getAvatar_url());

                //executer l'ordre
                ordre.executeUpdate();

                ordre.close();
               // conn.close(); pour jdbc simple

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void removeGithuber(String login)  {
        PreparedStatement pst;

        try {
            //simple jdbc
            //pst= JDBCGithuberDAO.getConnection().prepareStatement("DELETE FROM githuber WHERE login = ?");

            //datasource
            pst= githubertackerSource.getConnection().prepareStatement("DELETE FROM githuber WHERE login = ?");
            pst.setString(1, login);

            pst.executeUpdate();
            getGithubers();
            pst.close();
            //conn.close(); pour jdbc simple
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeGithuberId(long id) {
        PreparedStatement pst;

        try {
            pst= githubertackerSource.getConnection().prepareStatement("DELETE FROM githuber WHERE github_id = ?");
            pst.setLong(1, id);

            pst.executeUpdate();
            //getGithubers();
            pst.close();
        } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
