package service.impl;

import dao.IRoleDAO;
import dao.impl.RoleDaoImpl;
import model.Role;
import service.IRoleService;

public class RoleService implements IRoleService {

    private IRoleDAO roleDAO;

    public RoleService(){
        this.roleDAO = new RoleDaoImpl();
    }

    @Override
    public Role findRoleById(Long id) {
        return roleDAO.findRoleById(id);
    }
}
