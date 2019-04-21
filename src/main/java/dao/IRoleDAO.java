package dao;

import model.Role;

public interface IRoleDAO extends GenericDAO<Role> {
    Role findRoleById(Long id);
}
