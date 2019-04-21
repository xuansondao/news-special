package service.impl;

import dao.IUserDAO;
import dao.impl.UserDaoImpl;
import model.User;
import model.request.Auth;
import service.IUserService;

public class UserService implements IUserService {

    private IUserDAO userDAO = new UserDaoImpl();

    @Override
    public User findUserByUserNameAndPassword(Auth auth) {
        return userDAO.findUserByUserNameAndPassword(auth.getUserName(), auth.getPassword());
    }
}
