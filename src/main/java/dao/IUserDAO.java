package dao;

import model.User;

public interface IUserDAO extends GenericDAO<User> {

    User findUserByUserNameAndPassword(String userName, String password);

}
