package dao.impl;

import dao.GenericDAO;
import mapper.RowMapper;
import model.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AbtractDAO<T> implements GenericDAO<T> {

    public Connection getConnection(){
        String url = "jdbc:mysql://localhost:3306/news";
        String user = "root";
        String password = "1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url,user,password);
        } catch (ClassNotFoundException e) {
           return null;
        } catch (SQLException e) {
           return null;
        }
    }

    @Override
    public List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters) {
        Connection connection = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        List<T> results = new ArrayList<>();
        try {
            connection = getConnection();
            ps = connection.prepareStatement(sql);
            setParamets(ps, parameters);
            rs = ps.executeQuery();
            while (rs.next()){
                T t= rowMapper.mapRow(rs);
                results.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    @Override
    public void insertOrUpdate(String sql, Object... parameters) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = getConnection();
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(sql);
            setParamets(ps, parameters);
            ps.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            if (ps != null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void setParamets(PreparedStatement ps,Object...parametera){
        try{
            int length = parametera.length;
            for (int i = 0; i < length; i++){
                int index = i + 1;
                Object parameter = parametera[i];
                if (parameter instanceof String){
                    ps.setString(index, (String) parameter);
                }else if (parameter instanceof Long){
                    ps.setLong(index, (Long) parameter);
                }else if (parameter instanceof Timestamp){
                    ps.setTimestamp(index, (Timestamp) parameter);
                }else if (parameter instanceof Boolean){
                    ps.setBoolean(index, (Boolean) parameter);
                }else if (parameter instanceof Integer){
                    ps.setInt(index, (Integer) parameter);
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
