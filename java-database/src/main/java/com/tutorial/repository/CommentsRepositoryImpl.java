package com.tutorial.repository;

import com.tutorial.ConnectionUtil;
import com.tutorial.entity.Comments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentsRepositoryImpl implements CommentsRespository{

    @Override
    public void insert(Comments comments) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "insert into comments(email,comment) values (?,?)";
            try(PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
                statement.setString(1, comments.getEmail());
                statement.setString(2, comments.getComment());
                statement.executeUpdate();

                try(ResultSet resultSet = statement.getGeneratedKeys()){
                    if (resultSet.next()){
                        comments.setId(resultSet.getInt(1));
                    }
                }
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public Comments findById(Integer id) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "select * from comments where id=?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                statement.setInt(1, id);

                try(ResultSet resultSet = statement.executeQuery()){
                    if (resultSet.next()){
                        return new Comments(
                          resultSet.getInt("id"),
                          resultSet.getString("email"),
                          resultSet.getString("comment")
                        );
                    }else {
                        return null;
                    }
                }
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Comments> findAll() {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "select * from comments";
            try(Statement statement = connection.createStatement()){
                try(ResultSet resultSet = statement.executeQuery(sql)) {
                    List<Comments> comments = new ArrayList<>();
                    while (resultSet.next()) {
                        comments.add(new Comments(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comments")
                        ));
                    }
                    return comments;
                }
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public List<Comments> findAllByEmail(String email) {
        try(Connection connection = ConnectionUtil.getDataSource().getConnection()){
            String sql = "select * from comments where email=?";
            try(PreparedStatement statement = connection.prepareStatement(sql)){
                try(ResultSet resultSet = statement.executeQuery()){
                    List<Comments> comments = new ArrayList<>();
                    while (resultSet.next()){
                        comments.add(new Comments(
                                resultSet.getInt("id"),
                                resultSet.getString("email"),
                                resultSet.getString("comments")
                        ));
                    }
                    return comments;
                }
            }
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }
}
