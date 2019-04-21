package dao.impl;

import dao.IUserDAO;
import mapper.UserMapper;
import model.User;

import java.util.List;

public class UserDaoImpl extends AbtractDAO<User> implements IUserDAO {
    @Override
    public User findUserByUserNameAndPassword(String userName, String password) {
        String sql = "SELECT * FROM user WHERE userName = ? AND password = ?";
        List<User> users = query(sql,new UserMapper(),userName,password);
        return users.isEmpty() ? null : users.get(0);
    }
}
