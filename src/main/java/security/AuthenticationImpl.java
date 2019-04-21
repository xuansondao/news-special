package security;

import model.Role;
import model.User;
import model.request.Auth;
import service.IRoleService;
import service.IUserService;
import service.impl.RoleService;
import service.impl.UserService;
import utils.SessionUtil;

import javax.servlet.http.HttpServletRequest;

public class AuthenticationImpl implements Authentication{
    private String userName;
    private String password;
    private IUserService userService;
    private IRoleService roleService;

    public AuthenticationImpl(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.userService = new UserService();
        this.roleService = new RoleService();
    }

    @Override
    public String urlRedirect(HttpServletRequest request) {
        User user = userService.findUserByUserNameAndPassword(new Auth(userName, password));
        if (user != null) {
            SessionUtil.getSessionUtilIntance().putValue(request, "MODEL", user);
            Role role = roleService.findRoleById(user.getRoleId());
            if (role.getRoleName().equals("ADMIN")){
                return "/admin";
            }else if(role.getRoleName().equals("USER")){
                return "/home";
            }
        } else {
            return "/login?message=userNameOrPasswordInvalid";
        }
        return null;
    }
}
