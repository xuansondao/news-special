package dao.impl;

import dao.IRoleDAO;
import mapper.RoleMapper;
import model.Role;

import java.util.List;

public class RoleDaoImpl extends AbtractDAO<Role> implements IRoleDAO {
    @Override
    public Role findRoleById(Long id) {
        String sql = "SELECT * FROM role WHERE roleid = ?";
        List<Role> roles = query(sql, new RoleMapper(), id);

        return roles.isEmpty() ? null : roles.get(0);
    }
}
