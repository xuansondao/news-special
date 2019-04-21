package service;

import model.User;
import model.request.Auth;

public interface IUserService {
    User findUserByUserNameAndPassword(Auth auth);
}
