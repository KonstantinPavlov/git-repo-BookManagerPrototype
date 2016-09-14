package com.konstpavlov.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konstantin on 14.09.2016.
 *
 *
 *
 */
public class DAO {

    public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useLegacyDatetimeCode=false&serverTimezone=America/New_York","root","root");
    }


    public static List<Post> getPosts() throws SQLException, ClassNotFoundException {



        try(
            Connection c = getConnection();
            PreparedStatement ps= c.prepareStatement("SELECT id,text FROM test.posts");
            ResultSet resSet = ps.executeQuery();)
        {
            ArrayList<Post> posts = new ArrayList<>();
            while (resSet.next())
            {
                int id = resSet.getInt("id");
                String text = resSet.getString("text");
                posts.add(new Post(id,text));
            }
           return posts;}

    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.printf(getPosts().toString());
    }

    public static void deletePost(int id) throws SQLException, ClassNotFoundException {

        try(Connection c = getConnection();
        PreparedStatement ps= c.prepareStatement("DELETE FROM posts WHERE id=?");){

        ps.setInt(1,id);
        ps.executeUpdate();}


    }

    public static void AddPost(String text) throws SQLException, ClassNotFoundException {


        try(Connection c = getConnection();
            PreparedStatement ps= c.prepareStatement("INSERT INTO  posts (text) VALUES (?)");)
        {
            ps.setString(1,text);
            ps.executeUpdate();}


    }
}
